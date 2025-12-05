import java.util.Scanner;

// This is the main class that starts the game
public class Main {
    // Scanner to read input from user
    private static Scanner scanner = new Scanner(System.in);
    
    // Main method - this is where the program starts
    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Välkommen till Tre-i-rad! ===");
        System.out.println();
        
        // Ask user for board size
        int boardSize = getBoardSize();
        
        // Get name for player 1
        System.out.print("Ange namn för spelare 1 (X): ");
        String player1Name = scanner.nextLine().trim();
        // If player doesn't enter a name, use default
        if (player1Name.isEmpty()) {
            player1Name = "Spelare 1";
        }
        
        // Get name for player 2
        System.out.print("Ange namn för spelare 2 (O): ");
        String player2Name = scanner.nextLine().trim();
        // If player doesn't enter a name, use default
        if (player2Name.isEmpty()) {
            player2Name = "Spelare 2";
        }
        
        // Tell players the game is starting
        System.out.println("\nSpelet börjar! " + player1Name + " börjar.\n");
        
        // Create a new game
        Game game = new Game(boardSize, scanner);
        // Set up the players with their names
        game.setupPlayers(player1Name, player2Name);
        
        // Keep playing until player says no
        boolean playAgain = true;
        while (playAgain) {
            // Play one game
            game.play();
            
            // Ask if they want to play again
            System.out.print("Vill ni spela igen? (j/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            // Check if they said yes
            if (response.equals("j") || response.equals("ja") || response.equals("y") || response.equals("yes")) {
                playAgain = true;
            } else {
                playAgain = false;
            }
            
            // If they want to play again, reset the game
            if (playAgain) {
                game.reset();
                System.out.println("\nNytt spel börjar!\n");
            }
        }
        
        // Say goodbye
        System.out.println("\nTack för att ni spelade!");
        scanner.close();
    }
    
    // Method to get the board size from user
    private static int getBoardSize() {
        System.out.print("Ange storlek på spelplanen (minst 3, standard är 3): ");
        
        // Keep asking until we get a valid number
        while (true) {
            try {
                // Read what user typed
                String input = scanner.nextLine().trim();
                // If they didn't type anything, use default size 3
                if (input.isEmpty()) {
                    return 3;
                }
                
                // Convert string to number
                int size = Integer.parseInt(input);
                // Check if size is at least 3
                if (size >= 3) {
                    return size;
                } else {
                    // Size is too small, ask again
                    System.out.print("Storleken måste vara minst 3. Försök igen: ");
                }
            } catch (NumberFormatException e) {
                // User didn't type a number, ask again
                System.out.print("Ogiltig inmatning! Vänligen ange ett nummer (minst 3): ");
            }
        }
    }
}

