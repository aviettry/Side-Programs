

import java.io.FileNotFoundException;

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
	 * @throws FileNotFoundException 
	 */
	public Player(String name) throws InstantiationException {
		if( (name == null) || (name == "") )
			throw new InstantiationException("Error: Player name must be alpha characters only.");
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
