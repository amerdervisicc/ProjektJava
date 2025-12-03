/**
 * Player class represents a player in the Tic-Tac-Toe game.
 * Tracks player name, marker, and win statistics.
 */
public class Player {
    private String name;
    private char marker;
    private int wins;
    
    /**
     * Constructor creates a new player.
     * @param name The player's name
     * @param marker The player's marker (X or O)
     */
    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
        this.wins = 0;
    }
    
    /**
     * Gets the player's name.
     * @return The player's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the player's marker.
     * @return The player's marker (X or O)
     */
    public char getMarker() {
        return marker;
    }
    
    /**
     * Increments the player's win count.
     */
    public void addWin() {
        wins++;
    }
    
    /**
     * Gets the player's win count.
     * @return The number of wins
     */
    public int getWins() {
        return wins;
    }
    
    /**
     * Resets the player's win count.
     */
    public void resetWins() {
        wins = 0;
    }
}

