// This class represents a player
public class Player {
    // Player's name
    private String name;
    // Player's marker (X or O)
    private char marker;
    // How many times this player has won
    private int wins;
    
    // Constructor - create a new player
    public Player(String name, char marker) {
        // Save the name
        this.name = name;
        // Save the marker
        this.marker = marker;
        // Start with 0 wins
        this.wins = 0;
    }
    
    // Get the player's name
    public String getName() {
        return name;
    }
    
    // Get the player's marker (X or O)
    public char getMarker() {
        return marker;
    }
    
    // Add one win to this player
    public void addWin() {
        wins = wins + 1;
    }
    
    // Get how many wins this player has
    public int getWins() {
        return wins;
    }
    
    // Reset wins back to 0
    public void resetWins() {
        wins = 0;
    }
}

