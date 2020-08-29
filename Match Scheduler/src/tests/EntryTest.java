package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import backend.Entry;
import backend.Player;

public class EntryTest {
	static Player Ali, aLI, Jamie, Jim;
	
	@BeforeAll
	public static void setup() throws InstantiationException {
		Ali = new Player("Ali");
		aLI = new Player("aLI");
		Jamie = new Player("Jamie");
		Jim = new Player("Jim");
	}
	
	@Test
	public void containsTrue() {
		Entry entry = new Entry(Ali, Jamie);
		Entry entry2 = new Entry(aLI);
		assertTrue(entry.contains(entry2));
		
	}

	@Test
	public void containsFalse() {
		Entry entry = new Entry(Ali, Jamie);
		Entry entry2 = new Entry(Jim);
		assertFalse(entry.contains(entry2));
	}

}
