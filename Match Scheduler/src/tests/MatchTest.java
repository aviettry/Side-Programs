package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import backend.Entry;
import backend.Match;
import backend.Player;

public class MatchTest {
	static Entry entry, entry2, entry3, entry4, entry5;

	@BeforeAll
	public static void setup() throws InstantiationException {
		entry = new Entry(new Player("Ali"), new Player("Alisa"));
		entry2 = new Entry(new Player("Jim"), new Player("Alison"));
		entry3 = new Entry(new Player("Tim"), new Player("Alice"));
		entry4 = new Entry(new Player("Lin"), new Player("Ali"));
		entry5 = new Entry(new Player("Lin"), new Player("Aliza"));
	}

	@Test
	public void containsTrue() {
		Match match1 = new Match(entry, entry2);
		Match match2 = new Match(entry4, entry3);
		assertTrue(match1.contains(match2));
	}

	@Test
	public void containsFalse() {
		Match match1 = new Match(entry, entry2);
		Match match2 = new Match(entry5, entry3);
		assertFalse(match1.contains(match2));
	}

}
