package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import backend.Entry;
import backend.Match;
import backend.Player;

public class MatchTest {

	@Test
	public void containsTrue() {
		Entry entry = new Entry(new Player("Ali"), new Player("Alisa"));
		Entry entry2 = new Entry(new Player("Jim"), new Player("Alison"));
		Entry entry3 = new Entry(new Player("Tim"), new Player("Alice"));
		Entry entry4 = new Entry(new Player("Lin"), new Player("Ali"));
		
		Match match1 = new Match(entry, entry2);
		Match match2 = new Match(entry4, entry3);
		
		assertTrue(match1.contains(match2));
	}

	@Test
	public void containsFalse() {
		Entry entry = new Entry(new Player("Ali"), new Player("Alisa"));
		Entry entry2 = new Entry(new Player("Jim"), new Player("Alison"));
		Entry entry3 = new Entry(new Player("Tim"), new Player("Alice"));
		Entry entry4 = new Entry(new Player("Lin"), new Player("Aliza"));
		
		Match match1 = new Match(entry, entry2);
		Match match2 = new Match(entry4, entry3);
		
		assertFalse(match1.contains(match2));
	}

}
