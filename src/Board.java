// This class represents the game board
public class Board {
    // 2D array to store the board
    private char[][] grid;
    // Size of the board (size x size)
    private int size;
    // Empty space character
    private static final char EMPTY = ' ';
    
    // Constructor - creates a new board
    public Board(int size) {
        // Save the size
        this.size = size;
        // Create a 2D array for the board
        this.grid = new char[size][size];
        // Fill it with empty spaces
        initializeBoard();
    }
    
    // Fill the board with empty spaces
    private void initializeBoard() {
        // Go through each row
        for (int i = 0; i < size; i++) {
            // Go through each column
            for (int j = 0; j < size; j++) {
                // Set this position to empty
                grid[i][j] = EMPTY;
            }
        }
    }
    
    // Print the board to the screen
    public void display() {
        // Print empty line first
        System.out.println();
        // Go through each row
        for (int i = 0; i < size; i++) {
            // Go through each column in this row
            for (int j = 0; j < size; j++) {
                // Print the value at this position
                System.out.print(" " + grid[i][j] + " ");
                // If not the last column, print a separator
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            // Go to next line after each row
            System.out.println();
            
            // Print separator line between rows (but not after last row)
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    // If not the last column, print a plus
                    if (j < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
        // Print empty line at the end
        System.out.println();
    }
    
    // Place X or O at a position
    public boolean makeMove(int position, char marker) {
        // Calculate which row this position is in
        int row = (position - 1) / size;
        // Calculate which column this position is in
        int col = (position - 1) % size;
        
        // Check if this is a valid move
        if (isValidMove(position) == true) {
            // Place the marker
            grid[row][col] = marker;
            return true;
        }
        // Move was not valid
        return false;
    }
    
    // Check if a position is valid (not taken and within bounds)
    public boolean isValidMove(int position) {
        // Check if position is too small or too big
        if (position < 1 || position > size * size) {
            return false;
        }
        
        // Calculate row and column
        int row = (position - 1) / size;
        int col = (position - 1) % size;
        // Check if this spot is empty
        if (grid[row][col] == EMPTY) {
            return true;
        } else {
            return false;
        }
    }
    
    // Check if someone has won
    public char checkWinner() {
        // Check each row to see if all are the same
        for (int i = 0; i < size; i++) {
            // Only check if first spot is not empty
            if (grid[i][0] != EMPTY) {
                // Assume it's a win
                boolean win = true;
                // Check all other spots in this row
                for (int j = 1; j < size; j++) {
                    // If any spot is different, it's not a win
                    if (grid[i][j] != grid[i][0]) {
                        win = false;
                        break;
                    }
                }
                // If all spots were the same, we have a winner
                if (win == true) {
                    return grid[i][0];
                }
            }
        }
        
        // Check each column to see if all are the same
        for (int j = 0; j < size; j++) {
            // Only check if first spot is not empty
            if (grid[0][j] != EMPTY) {
                // Assume it's a win
                boolean win = true;
                // Check all other spots in this column
                for (int i = 1; i < size; i++) {
                    // If any spot is different, it's not a win
                    if (grid[i][j] != grid[0][j]) {
                        win = false;
                        break;
                    }
                }
                // If all spots were the same, we have a winner
                if (win == true) {
                    return grid[0][j];
                }
            }
        }
        
        // Check diagonal from top-left to bottom-right
        if (grid[0][0] != EMPTY) {
            // Assume it's a win
            boolean win = true;
            // Check all spots on this diagonal
            for (int i = 1; i < size; i++) {
                // If any spot is different, it's not a win
                if (grid[i][i] != grid[0][0]) {
                    win = false;
                    break;
                }
            }
            // If all spots were the same, we have a winner
            if (win == true) {
                return grid[0][0];
            }
        }
        
        // Check diagonal from top-right to bottom-left
        if (grid[0][size - 1] != EMPTY) {
            // Assume it's a win
            boolean win = true;
            // Check all spots on this diagonal
            for (int i = 1; i < size; i++) {
                // If any spot is different, it's not a win
                if (grid[i][size - 1 - i] != grid[0][size - 1]) {
                    win = false;
                    break;
                }
            }
            // If all spots were the same, we have a winner
            if (win == true) {
                return grid[0][size - 1];
            }
        }
        
        // No winner found
        return EMPTY;
    }
    
    // Check if board is completely full
    public boolean isFull() {
        // Go through every position
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // If we find an empty spot, board is not full
                if (grid[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        // All spots are filled
        return true;
    }
    
    // Get the size of the board
    public int getSize() {
        return size;
    }
    
    // Get total number of positions on the board
    public int getTotalPositions() {
        return size * size;
    }
    
    // Reset the board - clear everything
    public void reset() {
        // Fill board with empty spaces again
        initializeBoard();
    }
}

