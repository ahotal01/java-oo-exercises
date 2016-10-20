
public class Fraction {

	//Attributes:
	private int numerator;
	private int denominator;
	
	//Methods:
	public Fraction(int num, int denom) {
		this.numerator = num;
		this.denominator = denom;
	}
	
	public int getNum() {
		return this.numerator;
	}
	
	public int getDen() {
		return this.denominator;
	}
	
	public Fraction add(Fraction f) {
		int new_num = this.numerator * f.denominator + f.numerator * this.denominator;
		int new_den = this.denominator * f.denominator;
		Fraction sum = new Fraction(new_num, new_den);
		return sum.simplify();
	}
	
	public Fraction multiply(Fraction f) {
		Fraction product = new Fraction(this.numerator * f.numerator, this.denominator * f.denominator);
		return product.simplify();
	}
	
	public Fraction reciprocal() {
		Fraction recip = new Fraction(this.denominator, this.numerator);
		return recip.simplify();
	}
	
	public Fraction simplify() {
		int gcf = gcf(this.numerator, this.denominator);
		Fraction result = new Fraction(this.numerator / gcf, this.denominator / gcf);
		return result;
	}
	
	private int gcf(int num_one, int num_two) {
		int x = 0;
		if (num_one < num_two) {
			x = num_one;
		}
		else x = num_two;
		for (int i = x; i > 0; i--) {
			if (num_one % x == 0 && num_two % x == 0) {
				return x;
			}
		}
		return 1;
	}

}
