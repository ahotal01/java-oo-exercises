import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testAdd() {
		Fraction f_1 = new Fraction(1, 2);
		Fraction f_2 = new Fraction(2, 3);
		Fraction f_3 = f_1.add(f_2);
		assertTrue("Error adding Fractions (num = " + f_3.getNum() + ")", f_3.getNum() == 7);
		assertTrue("Error adding Fractions (den = " + f_3.getDen() + ")", f_3.getDen() == 6);
	}
	
	@Test
	public void testMultiply() {
		Fraction f_1 = new Fraction(1, 2);
		Fraction f_2 = new Fraction(2, 3);
		Fraction f_3 = f_1.multiply(f_2);
		assertTrue("Error multiplying Fractions (num = " + f_3.getNum() + ")", f_3.getNum() == 1);
		assertTrue("Error multiplying Fractions (den = " + f_3.getDen() + ")", f_3.getDen() == 3);
	}
	
	@Test
	public void testReciprocal() {
		Fraction f_1 = new Fraction(2, 3);
		Fraction f_2 = f_1.reciprocal();
		assertTrue("Error finding reciprocal (num = " + f_2.getNum() + ")", f_2.getNum() == 3);
		assertTrue("Error finding reciprocal (den = " + f_2.getDen() + ")", f_2.getDen() == 2);
	}

}
