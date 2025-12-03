import java.util.Scanner;

/**
 * Main class is the entry point for the Tic-Tac-Toe game.
 * Handles game initialization and the main game loop.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Main method starts the game application.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Välkommen till Tre-i-rad! ===");
        System.out.println();
        
        // Get board size
        int boardSize = getBoardSize();
        
        // Get player names
        System.out.print("Ange namn för spelare 1 (X): ");
        String player1Name = scanner.nextLine().trim();
        if (player1Name.isEmpty()) {
            player1Name = "Spelare 1";
        }
        
        System.out.print("Ange namn för spelare 2 (O): ");
        String player2Name = scanner.nextLine().trim();
        if (player2Name.isEmpty()) {
            player2Name = "Spelare 2";
        }
        
        System.out.println("\nSpelet börjar! " + player1Name + " börjar.\n");
        
        // Create and setup game
        Game game = new Game(boardSize, scanner);
        game.setupPlayers(player1Name, player2Name);
        
        // Main game loop
        boolean playAgain = true;
        while (playAgain) {
            game.play();
            
            // Ask if players want to play again
            System.out.print("Vill ni spela igen? (j/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("j") || response.equals("ja") || response.equals("y") || response.equals("yes");
            
            if (playAgain) {
                game.reset();
                System.out.println("\nNytt spel börjar!\n");
            }
        }
        
        System.out.println("\nTack för att ni spelade!");
        scanner.close();
    }
    
    /**
     * Gets a valid board size from the user.
     * @return The board size (minimum 3)
     */
    private static int getBoardSize() {
        System.out.print("Ange storlek på spelplanen (minst 3, standard är 3): ");
        
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    return 3; // Default size
                }
                
                int size = Integer.parseInt(input);
                if (size >= 3) {
                    return size;
                } else {
                    System.out.print("Storleken måste vara minst 3. Försök igen: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Ogiltig inmatning! Vänligen ange ett nummer (minst 3): ");
            }
        }
    }
}

