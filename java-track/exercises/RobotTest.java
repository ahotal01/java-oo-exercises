import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testMove() {
		Robot r = new Robot("Adam", 0, 0, 3, 0);
		assertTrue("Problem initializing Robot positions", r.getX_coord() == 0);
		assertTrue("Problem initializing Robot positions", r.getY_coord() == 0);
		r.move();
		assertTrue("Problem moving Robot", r.getX_coord() == 0);
		assertTrue("Problem moving Robot", r.getY_coord() == 3);
	}

	@Test
	public void testRotateL() {
		Robot r = new Robot("Adam", 0, 0, 3, 90);
		assertTrue("Problem initializing orientation", r.getOrientation() == 90);
		r.rotate_l();
		assertTrue("Problem rotating Robot left", r.getOrientation() == 0);
		r.rotate_l();
		assertTrue("Problem rotating Robot left past 0", r.getOrientation() == 270);
	}
	
	@Test
	public void testRotateR() {
		Robot r = new Robot("Adam", 0, 0, 3, 180);
		assertTrue("Problem initializing orientation", r.getOrientation() == 180);
		r.rotate_r();
		assertTrue("Problem rotating Robot right", r.getOrientation() == 270);
		r.rotate_r();
		assertTrue("Problem rotating Robot right past 0", r.getOrientation() == 0);
	}
	
	@Test
	public void testDistance() {
		Robot r = new Robot("Adam", 0, 0, 3, 0);
		Robot s = new Robot("Hotaling", 3, 4, 1, 0);
		assertTrue("Problem calculating distance, expected 5.0, actual " + r.distance(s), 5.0 == r.distance(s));
	}
	
	@Test
	public void testToString() {
		Robot r = new Robot("Adam", 1, 2, 3, 0);
		assertTrue("Problem printing info, printed: " + r.toString(), "Adam is at (1, 2), with an orientation of 0 degrees".equals(r.toString()));
	}
}
