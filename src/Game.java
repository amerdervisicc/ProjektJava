import java.util.Scanner;

// This class handles the game logic
public class Game {
    // The game board
    private Board board;
    // First player
    private Player player1;
    // Second player
    private Player player2;
    // Which player's turn it is now
    private Player currentPlayer;
    // Scanner to read input
    private Scanner scanner;
    // Whether the game is finished
    private boolean gameOver;
    
    // Constructor - creates a new game
    public Game(int boardSize, Scanner scanner) {
        // Create a new board with the given size
        this.board = new Board(boardSize);
        // Save the scanner
        this.scanner = scanner;
        // Game is not over yet
        this.gameOver = false;
    }
    
    // Set up the two players
    public void setupPlayers(String player1Name, String player2Name) {
        // Create player 1 with X marker
        this.player1 = new Player(player1Name, 'X');
        // Create player 2 with O marker
        this.player2 = new Player(player2Name, 'O');
        // Player 1 starts first
        this.currentPlayer = player1;
    }
    
    // Main game loop - keeps playing until game is over
    public void play() {
        // Keep playing while game is not over
        while (gameOver == false) {
            // Show the board
            board.display();
            // Let current player make a move
            playTurn();
            // Check if someone won or if it's a draw
            checkGameState();
        }
    }
    
    // Handle one player's turn
    private void playTurn() {
        // Ask player which position they want
        System.out.print(currentPlayer.getName() + " (" + currentPlayer.getMarker() + 
                        "), vilken ruta (1-" + board.getTotalPositions() + ")? ");
        
        // Get a number from the player
        int position = getValidInput();
        
        // Keep asking until they pick a valid position
        while (board.isValidMove(position) == false) {
            System.out.println("Ogiltigt drag! Rutan är antingen redan tagen eller utanför spelplanen.");
            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getMarker() + 
                            "), vilken ruta (1-" + board.getTotalPositions() + ")? ");
            position = getValidInput();
        }
        
        // Make the move on the board
        board.makeMove(position, currentPlayer.getMarker());
    }
    
    // Get a valid number from the user
    private int getValidInput() {
        // Keep trying until we get a valid number
        while (true) {
            try {
                // Read what user typed
                String input = scanner.nextLine().trim();
                // Convert to number
                int position = Integer.parseInt(input);
                // Return the number
                return position;
            } catch (NumberFormatException e) {
                // If it's not a number, ask again
                System.out.print("Ogiltig inmatning! Vänligen ange ett nummer (1-" + 
                               board.getTotalPositions() + "): ");
            }
        }
    }
    
    // Check if game is won, drawn, or should continue
    private void checkGameState() {
        // Check if there's a winner
        char winner = board.checkWinner();
        
        // If there is a winner
        if (winner != ' ') {
            // Show the board one more time
            board.display();
            // Add a win to current player
            currentPlayer.addWin();
            // Tell them they won
            System.out.println("Grattis " + currentPlayer.getName() + "! Du vann!");
            // Show statistics
            displayStatistics();
            // Game is over
            gameOver = true;
        } else if (board.isFull()) {
            // Board is full but no winner - it's a draw
            board.display();
            System.out.println("Oavgjort! Ingen vinnare denna gång.");
            // Show statistics
            displayStatistics();
            // Game is over
            gameOver = true;
        } else {
            // No winner yet, switch to other player
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }
    
    // Show how many wins each player has
    private void displayStatistics() {
        System.out.println("\n--- Statistik ---");
        System.out.println(player1.getName() + ": " + player1.getWins() + " vinster");
        System.out.println(player2.getName() + ": " + player2.getWins() + " vinster");
        System.out.println("----------------\n");
    }
    
    // Reset everything for a new game
    public void reset() {
        // Clear the board
        board.reset();
        // Player 1 starts again
        currentPlayer = player1;
        // Game is not over
        gameOver = false;
    }
    
    // Check if game is over
    public boolean isGameOver() {
        return gameOver;
    }
    
    // Get player 1
    public Player getPlayer1() {
        return player1;
    }
    
    // Get player 2
    public Player getPlayer2() {
        return player2;
    }
}

