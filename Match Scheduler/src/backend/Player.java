package backend;

/**
 * A player is a competitor for the team. To play for the team, the player will
 * be added to a team's entry.
 */
public class Player {
	private String name;

	/**
	 * Creates a player with the name.
	 * 
	 * @param name The name of the player.
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * Checks if this player is the same as the other player.
	 * 
	 * @param  player The other player.
	 * @return        True if the players are the same. False otherwise.
	 */
	public boolean equals(Player player) {
		return player.name.equalsIgnoreCase(name);
	}
}
