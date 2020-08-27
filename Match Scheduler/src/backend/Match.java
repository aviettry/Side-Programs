/**
 * 
 */
package backend;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Match {

	private Entry[] entries = new Entry[2];

	public Match(Entry side1, Entry side2) {
		entries[0] = side1;
		entries[1] = side2;
	}

	public List<Entry> entries() {
		return Arrays.asList(entries);
	}

	public boolean contains(Match match2) {
		for (Entry entry : this.entries) {
			for (Entry entry2 : match2.entries()) {
				if (entry.contains(entry2))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Entry entry = new Entry(new Player("Ali"), new Player("Alisa"));
		Entry entry2 = new Entry(new Player("Jim"), new Player("Alison"));
		Entry entry3 = new Entry(new Player("Tim"), new Player("Alice"));
		Entry entry4 = new Entry(new Player("Lin"), new Player("Ali"));
		
		Match match1 = new Match(entry, entry2);
		Match match2 = new Match(entry4, entry3);
		System.out.println(match1.contains(match2));
	}
}
