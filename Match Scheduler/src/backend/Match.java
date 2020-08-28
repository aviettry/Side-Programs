/**
 * 
 */
package backend;

/**
 * Consists of two entries, one entry from each team competing against one
 * another.
 */
public class Match {
	private Entry[] entries = new Entry[2];

	/**
	 * Creates a match with two entries.
	 * 
	 * @param side1 The entry from the first team.
	 * @param side2 The entry from the other team.
	 */
	public Match(Entry side1, Entry side2) {
		entries[0] = side1;
		entries[1] = side2;
	}

	/**
	 * Checks if any of the players from this match are also a player in the other
	 * match.
	 * 
	 * @param  match The other match.
	 * @return       True if there is a player in both matches. False otherwise.
	 */
	public boolean contains(Match match) {
		for (Entry entry : this.entries) {
			for (Entry entry2 : match.entries) {
				if (entry.contains(entry2))
					return true;
			}
		}
		return false;
	}

	/**
	 * Checks if this match and the other match are the same.
	 * 
	 * @param  match The other match.
	 * @return       True if all entries are the same. False otherwise.
	 */
	public boolean equals(Match match) {
		for (Entry entry : this.entries) {
			for (Entry entry2 : match.entries) {
				if (!entry.contains(entry2))
					return false;
			}
		}
		return true;
	}
}
