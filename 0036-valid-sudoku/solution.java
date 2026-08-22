class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        // Checking both row and column numbers, must have exactly 
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                char number = board[row][column];

                if (number != '.') {
                    String row_key = number + " in row " + row;
                    String column_key = number + " in column" + column;
                    String box_key = number + " in box" + (row / 3) + "-" + (column / 3);
                    if (!seen.add(row_key) || !seen.add(column_key) || !seen.add(box_key)) {
                        return false;
                    }
                }
            }
        }

        return true;
        
    }
}
