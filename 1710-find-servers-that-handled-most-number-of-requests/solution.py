class Solution:
    def busiestServers(self, k: int, arrival: list[int], load: list[int]) -> list[int]:
        available_servers = list(range(k))
        busy_servers = []
        handled = [0] * k
        res = []



        if k >= len(arrival):
            for i in range(len(arrival)):
                res.append(i)

            return res
        
        # Use a min-heap to greedily track loads for any server, prioritisting the smallest loads

            # Create a min heap for 'load' array

        # Look for the first server with the smallest 'load'

        for i in range(len(arrival)):
            while busy_servers and busy_servers[0][0] <= arrival[i]:
                finish_time, server = heapq.heappop(busy_servers)

                bisect.insort(available_servers, server)

            if not available_servers:
                continue
                
            preferred = i % k

            pos = bisect.bisect_left(available_servers, preferred)
            # Wrap around if pos is not equal to a current server
            if pos == len(available_servers):
                pos = 0

            server = available_servers.pop(pos)
            handled[server] += 1

            finish_time = arrival[i] + load[i]
            heapq.heappush(busy_servers, (finish_time, server))

        max_requests = max(handled)

        for i in range(k):
            if handled[i] == max_requests:
                res.append(i)
        
        return res



        
