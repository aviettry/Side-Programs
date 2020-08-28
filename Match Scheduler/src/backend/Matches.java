package backend;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A running list of all matches to be scheduled.
 */
public class Matches {
	private Queue<Match> matches = new LinkedList<Match>();
	
	/**
	 * Constructs a running list of all matches.
	 */
	public Matches() {
		
	}
	
	/**
	 * Adds a unique match to the list. 
	 * @param match The match to add.
	 */
	public void enqueue(Match match) {
		for( Match currentMatch : matches ) {
			if (match.equals(currentMatch)) return;
		}
		matches.add(match);
	}
	
	/**
	 * Removes the next match from the list to be scheduled.
	 * @return The next match from the list if there are any remaining.
	 */
	public Match deque() {
		return matches.poll();
	}
	
	/**
	 * Retrieves the next match from the list.
	 * @return The next match from the list that needs to be scheduled.
	 */
	public Match next() {
		return matches.peek();
	}
	
	/**
	 * Checks if there are any remaining matches to be scheduled.
	 * @return True if there are no more matches remaining. False otherwise.
	 */
	public boolean finished() {
		return matches.isEmpty();
	}
	
	
}
