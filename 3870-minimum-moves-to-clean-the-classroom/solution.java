import java.util.Hashtable;
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startX = -1;
        int startY = -1;
        int litterCount = 0;
        int[][] litterIndex = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterIndex[i], -1);

            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startX = i;
                    startY = j;
                }
                else if (ch == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }
        // Base Case: No litter to collect
        if (litterCount == 0) {
            return 0;
        }
        // Full bitmask representing all litter reamining
        int fullMask = (1 << litterCount) - 1;

        // Queue elements: {row, col, remainingEnergy, litterMask, moveCount}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, energy, fullMask, 0});

        // Track visited states: [row][col][energy][mask]
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];
        visited[startX][startY][energy][fullMask] = true;
        
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0, 1}};

        // Standard BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            // Goal check: All litter collected
            if (mask == 0) {
                return moves;
            }
            // If no energy remains, cannot make further moves from this state
            if (e == 0) {
                continue;
            }

            for (int[] dir: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                // Boundary & Obstacle Check
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X' ) {
                    continue;
                }

                int nextEnergy = e - 1;
                int nextMask = mask;
                char cellType = classroom[nr].charAt(nc);
                // If 'R' cell landed on, energy goes back to maximum energy, 'energy' variable value
                if (cellType == 'R') {
                    nextEnergy = energy;
                }

                // Collecting litter at 'L'
                if (cellType == 'L' && litterIndex[nr][nc] != -1) {
                    int bitIndex = litterIndex[nr][nc];
                    nextMask &= ~(1 << bitIndex); // Clear bit
                }

                // Add to queue if state hasn't been visited
                if (!visited[nr][nc][nextEnergy][nextMask]) {
                    visited[nr][nc][nextEnergy][nextMask] = true;
                    queue.offer(new int[]{nr, nc, nextEnergy, nextMask, moves + 1});
                }
            }
        }

        return -1; // Unreachable litter spots, blocked by 'X' cells
    }
}

