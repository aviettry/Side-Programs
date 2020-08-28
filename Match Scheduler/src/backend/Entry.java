package backend;

import java.util.ArrayList;

/**
 * An entry consists of no more than two players, one for singles, or two for
 * doubles.
 */
public class Entry {
	private ArrayList<Player> players = new ArrayList<>();

	/**
	 * Creates an entry for singles with the player.
	 * 
	 * @param player The player competing in singles.
	 */
	public Entry(Player player) {
		players.add(player);
	}

	/**
	 * Creates an entry for doubles with the partners.
	 * 
	 * @param partner1 The first partner in the doubles pair.
	 * @param partner2 The second partner in the doubles pair.
	 */
	public Entry(Player partner1, Player partner2) {
		players.add(partner1);
		players.add(partner2);
	}

	/**
	 * Checks if this entry contains any of the players from the other entry.
	 * 
	 * @param  entry The other entry.
	 * @return       True if there's a player in both entries. False otherwise.
	 */
	public boolean contains(Entry entry) {
		for (Player player : this.players) {
			for (Player player2 : entry.players) {
				if (player.equals(player2))
					return true;
			}
		}
		return false;
	}
}
