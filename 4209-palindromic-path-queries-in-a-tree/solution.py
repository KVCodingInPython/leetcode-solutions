class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.seg = [0] * (4 * self.n)
        self._build(1, 0, self.n - 1, arr)

    def _build(self, idx, l, r, arr):
        if l == r:
            self.seg[idx] = arr[l]
            return

        mid = (l + r) // 2

        self._build(idx * 2, l, mid, arr)
        self._build(idx * 2 + 1, mid + 1, r, arr)

        self.seg[idx] = self.seg[idx * 2] ^ self.seg[idx * 2 + 1]

    def update(self, pos, val):
        self._update(1, 0, self.n - 1, pos, val)

    def _update(self, idx, l, r, pos, val):
        if l == r:
            self.seg[idx] = val
            return

        mid = (l + r) // 2

        if pos <= mid:
            self._update(idx * 2, l, mid, pos, val)
        else:
            self._update(idx * 2 + 1, mid + 1, r, pos, val)

        self.seg[idx] = self.seg[idx * 2] ^ self.seg[idx * 2 + 1]

    def query(self, ql, qr):
        return self._query(1, 0, self.n - 1, ql, qr)

    def _query(self, idx, l, r, ql, qr):
        if ql <= l and r <= qr:
            return self.seg[idx]

        if r < ql or l > qr:
            return 0

        mid = (l + r) // 2

        return (
            self._query(idx * 2, l, mid, ql, qr)
            ^ self._query(idx * 2 + 1, mid + 1, r, ql, qr)
        )


class Solution(object):
    def palindromePath(self, n, edges, s, queries):

        graph = [[] for _ in range(n)]

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        parent = [-1] * n
        depth = [0] * n
        size = [0] * n
        heavy = [-1] * n

        def dfs(u, p):
            parent[u] = p
            size[u] = 1

            max_subtree = 0

            for v in graph[u]:
                if v == p:
                    continue

                depth[v] = depth[u] + 1

                dfs(v, u)

                size[u] += size[v]

                if size[v] > max_subtree:
                    max_subtree = size[v]
                    heavy[u] = v

        dfs(0, -1)

        head = [0] * n
        pos = [0] * n
        cur = [0]

        def decompose(u, h):
            head[u] = h
            pos[u] = cur[0]
            cur[0] += 1

            if heavy[u] != -1:
                decompose(heavy[u], h)

            for v in graph[u]:
                if v == parent[u] or v == heavy[u]:
                    continue

                decompose(v, v)

        decompose(0, 0)

        base = [0] * n

        for node in range(n):
            base[pos[node]] = 1 << (ord(s[node]) - ord('a'))

        seg = SegmentTree(base)

        chars = list(s)

        def path_query(u, v):
            res = 0

            while head[u] != head[v]:
                if depth[head[u]] < depth[head[v]]:
                    u, v = v, u

                res ^= seg.query(
                    pos[head[u]],
                    pos[u]
                )

                u = parent[head[u]]

            if depth[u] > depth[v]:
                u, v = v, u

            res ^= seg.query(
                pos[u],
                pos[v]
            )

            return res

        ans = []

        for q in queries:

            parts = q.split()

            if parts[0] == "update":

                node = int(parts[1])
                ch = parts[2]

                chars[node] = ch

                seg.update(
                    pos[node],
                    1 << (ord(ch) - ord('a'))
                )

            else:

                u = int(parts[1])
                v = int(parts[2])

                mask = path_query(u, v)

                ans.append(
                    mask == 0 or (mask & (mask - 1)) == 0
                )

        return ans
