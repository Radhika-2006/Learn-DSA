class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0, startC = 0;
        int[][] litter = new int[m][n];
        int count = 0;

        // Find S and assign index to every L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litter[i][j] = count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        }

        int target = (1 << count) - 1;

        // visited[row][col][energy][mask]
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << count];

        Queue<int[]> q = new LinkedList<>();

        // row, col, remainingEnergy, mask
        q.offer(new int[]{startR, startC, energy, 0});

        visited[startR][startC][energy][0] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                // All litter collected
                if (mask == target) {
                    return moves;
                }

                // No energy left
                if (e == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newEnergy = e - 1;
                    int newMask = mask;

                    // Reset energy
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    // Collect litter
                    if (classroom[nr].charAt(nc) == 'L') {
                        int index = litter[nr][nc];
                        newMask = mask | (1 << index);
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(new int[]{
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}