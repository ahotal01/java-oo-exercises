import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testPerimeter() {
		Rectangle r = new Rectangle(3, 4);
		assertTrue("Error calculating perimeter", r.perimeter() == 14);
	}

	@Test
	public void testArea() {
		Rectangle r = new Rectangle(3, 4);
		assertTrue("Error calculating area", r.area() == 12);
	}
	
	@Test
	public void testIsSquare() {
		Rectangle r = new Rectangle(4, 4);
		assertTrue("Error confirming square-ness", r.isSquare());
		Rectangle s = new Rectangle(1, 4);
		assertTrue("Error disproving square-ness", !s.isSquare());
	}
	
	@Test
	public void testIsSmaller() {
		Rectangle r = new Rectangle(3, 4);
		Rectangle s = new Rectangle(2, 10);
		assertTrue("Error comparing areas", r.isSmaller(s));
		s.setWidth(3);
		assertTrue("Error comparing areas 2", !r.isSmaller(s));
	}
}
