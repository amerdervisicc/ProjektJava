import java.util.Scanner;

/**
 * Game class manages the main game logic and flow.
 * Handles player turns, move validation, and game state.
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;
    private boolean gameOver;
    
    /**
     * Constructor initializes a new game.
     * @param boardSize The size of the game board
     * @param scanner Scanner for user input
     */
    public Game(int boardSize, Scanner scanner) {
        this.board = new Board(boardSize);
        this.scanner = scanner;
        this.gameOver = false;
    }
    
    /**
     * Sets up the players with their names.
     * @param player1Name Name of player 1
     * @param player2Name Name of player 2
     */
    public void setupPlayers(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 'X');
        this.player2 = new Player(player2Name, 'O');
        this.currentPlayer = player1;
    }
    
    /**
     * Starts and runs the game loop.
     */
    public void play() {
        while (!gameOver) {
            board.display();
            playTurn();
            checkGameState();
        }
    }
    
    /**
     * Handles a single player turn.
     */
    private void playTurn() {
        System.out.print(currentPlayer.getName() + " (" + currentPlayer.getMarker() + 
                        "), vilken ruta (1-" + board.getTotalPositions() + ")? ");
        
        int position = getValidInput();
        
        while (!board.isValidMove(position)) {
            System.out.println("Ogiltigt drag! Rutan är antingen redan tagen eller utanför spelplanen.");
            System.out.print(currentPlayer.getName() + " (" + currentPlayer.getMarker() + 
                            "), vilken ruta (1-" + board.getTotalPositions() + ")? ");
            position = getValidInput();
        }
        
        board.makeMove(position, currentPlayer.getMarker());
    }
    
    /**
     * Gets valid integer input from the user.
     * @return A valid integer position
     */
    private int getValidInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int position = Integer.parseInt(input);
                return position;
            } catch (NumberFormatException e) {
                System.out.print("Ogiltig inmatning! Vänligen ange ett nummer (1-" + 
                               board.getTotalPositions() + "): ");
            }
        }
    }
    
    /**
     * Checks the current game state (win, draw, or continue).
     */
    private void checkGameState() {
        char winner = board.checkWinner();
        
        if (winner != ' ') {
            board.display();
            currentPlayer.addWin();
            System.out.println("Grattis " + currentPlayer.getName() + "! Du vann!");
            displayStatistics();
            gameOver = true;
        } else if (board.isFull()) {
            board.display();
            System.out.println("Oavgjort! Ingen vinnare denna gång.");
            displayStatistics();
            gameOver = true;
        } else {
            // Switch to the other player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
    
    /**
     * Displays current win statistics for both players.
     */
    private void displayStatistics() {
        System.out.println("\n--- Statistik ---");
        System.out.println(player1.getName() + ": " + player1.getWins() + " vinster");
        System.out.println(player2.getName() + ": " + player2.getWins() + " vinster");
        System.out.println("----------------\n");
    }
    
    /**
     * Resets the game for a new round.
     */
    public void reset() {
        board.reset();
        currentPlayer = player1;
        gameOver = false;
    }
    
    /**
     * Checks if the game is over.
     * @return true if game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * Gets player 1.
     * @return Player 1
     */
    public Player getPlayer1() {
        return player1;
    }
    
    /**
     * Gets player 2.
     * @return Player 2
     */
    public Player getPlayer2() {
        return player2;
    }
}

