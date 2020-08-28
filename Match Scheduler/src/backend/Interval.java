/**
 * 
 */
package backend;

import java.util.ArrayList;

/**
 * An interval of matches in the schedule.
 */
public class Interval {
	private ArrayList<Match> matches;

	private int courtsRemaining;

	/**
	 * Creates an interval with the number of available courts.
	 */
	public Interval(int numCourts) {
		courtsRemaining = numCourts;
	}

	/**
	 * Checks if the new match already has a player scheduled in this interval.
	 * 
	 * @param  newMatch The new match to be scheduled.
	 * @return          True if there is a match that contains a player from the
	 *                  new match. False otherwise.
	 */
	public boolean contains(Match newMatch) {
		for (Match match : matches) {
			if (match.contains(newMatch))
				return true;
		}
		return false;
	}

	/**
	 * Adds a new match to the interval.
	 * 
	 * @param  newMatch The new match to be scheduled.
	 * @return          True if the match was scheduled. False otherwise.
	 */
	public boolean add(Match newMatch) {
		if (!hasCourt())
			return false;
		if (contains(newMatch))
			return false;
		courtsRemaining--;
		return matches.add(newMatch);
	}

	/**
	 * Removes the last match from this interval.
	 * 
	 * @return The match that was removed.
	 */
	public Match removeMatch() {
		if (matches.size() == 0)
			return null;
		courtsRemaining++;
		return matches.remove(matches.size() - 1);
	}

	/**
	 * Checks if there are any more courts open.
	 * 
	 * @return True if there is an open court. False otherwise.
	 */
	public boolean hasCourt() {
		return courtsRemaining > 0;
	}

	/**
	 * Counts the number of matches that have a player in both intervals.
	 * 
	 * @param  interval The other interval to compare with this interval.
	 * @return          The number of matches that have a player in both
	 *                  intervals.
	 */
	public int compare(Interval interval) {
		int conflicts = 0;
		for (Match match : this.matches) {
			for (Match nextMatch : interval.matches) {
				if (match.contains(nextMatch))
					conflicts++;
			}
		}
		return conflicts;
	}
}
