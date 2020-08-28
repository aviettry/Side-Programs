package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import backend.Player;

public class PlayerTest {

	@Test
	public void containsFalse() {
		Player p1 = new Player("Ali");
		Player p2 = new Player("Jimmy");
		assertFalse(p1.equals(p2));
		Player p3 = new Player("ali");
		assertTrue(p1.equals(p3));
	}

	@Test
	public void containsTrue() {
		Player p1 = new Player("Ali");
		Player p3 = new Player("ali");
		assertTrue(p1.equals(p3));
	}
}
