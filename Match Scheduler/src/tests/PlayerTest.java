package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import backend.Player;

public class PlayerTest {

	@Test
	public void containsFalse() throws InstantiationException {
		Player p1 = new Player("Ali");
		Player p2 = new Player("Jimmy");
		assertFalse(p1.equals(p2));
		Player p3 = new Player("ali");
		assertTrue(p1.equals(p3));
	}

	@Test
	public void containsTrue() throws InstantiationException {
		Player p1 = new Player("Ali");
		Player p3 = new Player("ali");
		assertTrue(p1.equals(p3));
	}
	
	@Test
	public void catchError() {
		try {
			new Player("");
		} catch (InstantiationException e) {
			assertTrue(true);
		} catch (Exception e) {
			
		}
		try {
			new Player(null);
		} catch (InstantiationException e) {
			assertTrue(true);
		}catch (Exception e) {
			fail("Unknown Exception thrown: " + e);
		}
		try {
			new Player("a2");
		} catch (InstantiationException e) {
			assertTrue(true);
		}catch (Exception e) {
			fail("Unknown Exception thrown: " + e);
		}
		try {
			new Player("a-");
		} catch (InstantiationException e) {
			assertTrue(true);
		}catch (Exception e) {
			fail("Unknown Exception thrown: " + e);
		}
		
	}
}
