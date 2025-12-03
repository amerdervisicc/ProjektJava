/**
 * Board class represents the game board for Tic-Tac-Toe.
 * Handles board display, move validation, and win/draw detection.
 */
public class Board {
    private char[][] grid;
    private int size;
    private static final char EMPTY = ' ';
    
    /**
     * Constructor creates a new board with the specified size.
     * @param size The size of the board (size x size)
     */
    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeBoard();
    }
    
    /**
     * Initializes the board with empty spaces.
     */
    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = EMPTY;
            }
        }
    }
    
    /**
     * Displays the current state of the board.
     */
    public void display() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            // Display row with values
            for (int j = 0; j < size; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            
            // Display separator line
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    if (j < size - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    
    /**
     * Places a marker at the specified position.
     * @param position The position (1-9 for 3x3, or calculated for larger boards)
     * @param marker The marker to place (X or O)
     * @return true if the move was successful, false otherwise
     */
    public boolean makeMove(int position, char marker) {
        int row = (position - 1) / size;
        int col = (position - 1) % size;
        
        if (isValidMove(position)) {
            grid[row][col] = marker;
            return true;
        }
        return false;
    }
    
    /**
     * Checks if a move is valid (position is within bounds and cell is empty).
     * @param position The position to check
     * @return true if the move is valid, false otherwise
     */
    public boolean isValidMove(int position) {
        if (position < 1 || position > size * size) {
            return false;
        }
        
        int row = (position - 1) / size;
        int col = (position - 1) % size;
        return grid[row][col] == EMPTY;
    }
    
    /**
     * Checks if there is a winner on the board.
     * @return The winning marker (X or O), or EMPTY if no winner
     */
    public char checkWinner() {
        // Check rows
        for (int i = 0; i < size; i++) {
            if (grid[i][0] != EMPTY) {
                boolean win = true;
                for (int j = 1; j < size; j++) {
                    if (grid[i][j] != grid[i][0]) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return grid[i][0];
                }
            }
        }
        
        // Check columns
        for (int j = 0; j < size; j++) {
            if (grid[0][j] != EMPTY) {
                boolean win = true;
                for (int i = 1; i < size; i++) {
                    if (grid[i][j] != grid[0][j]) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return grid[0][j];
                }
            }
        }
        
        // Check main diagonal
        if (grid[0][0] != EMPTY) {
            boolean win = true;
            for (int i = 1; i < size; i++) {
                if (grid[i][i] != grid[0][0]) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return grid[0][0];
            }
        }
        
        // Check anti-diagonal
        if (grid[0][size - 1] != EMPTY) {
            boolean win = true;
            for (int i = 1; i < size; i++) {
                if (grid[i][size - 1 - i] != grid[0][size - 1]) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return grid[0][size - 1];
            }
        }
        
        return EMPTY;
    }
    
    /**
     * Checks if the board is full (draw condition).
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Gets the size of the board.
     * @return The board size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Gets the total number of positions on the board.
     * @return Total number of positions
     */
    public int getTotalPositions() {
        return size * size;
    }
    
    /**
     * Resets the board to an empty state.
     */
    public void reset() {
        initializeBoard();
    }
}

