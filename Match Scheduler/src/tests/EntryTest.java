package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import backend.Entry;
import backend.Player;

public class EntryTest {

	@Test
	public void containsTrue() {
		Entry entry = new Entry(new Player("Ali"), new Player("Jamie"));
		Entry entry2 = new Entry(new Player("aLI"));
		assertTrue(entry.contains(entry2));
		
	}

	@Test
	public void containsFalse() {
		Entry entry = new Entry(new Player("Ali"), new Player("Jamie"));
		Entry entry2 = new Entry(new Player("Jim"));
		assertFalse(entry.contains(entry2));
	}

}
