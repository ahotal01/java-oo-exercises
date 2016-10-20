import static org.junit.Assert.*;

import org.junit.Test;

public class BaseballPlayerTest {

	@Test
	public void testAddGame() {
		BaseballPlayer bp = new BaseballPlayer("Adam", 6, "right");
		assertTrue("Error initializing player", bp.getGames() == 0);
		bp.addGame(2, 5);
		assertTrue("Error adding game data, games = " + bp.getGames(), bp.getGames() == 1);
		assertTrue("Error adding game data, runs = " + bp.getRuns(), bp.getRuns() == 2);
		assertTrue("Error adding game data, rbis = " + bp.getRBIs(), bp.getRBIs() == 5);
	}

}
