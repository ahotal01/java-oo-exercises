
public class Rectangle {

	private int length;
	private int width;
	
	public int get_length()
	{
		return this.length;
	}
	
	public int get_width()
	{
		return this.width;
	}
	
	public int perimeter()
	{
		return this.length * 2 + this.width * 2;
	}
	
	public int area()
	{
		return this.length * this.width;
	}
	
	public boolean is_smaller(Rectangle r_2)
	{
		if (this.area() < r_2.area())
		{
			return true;
		}
		else return false;
	}
	
	public boolean is_square()
	{
		if (this.length == this.width)
		{
			return true;
		}
		else return false;
	}
	
	public static void main(String[] args) {
		// TODO Unit tests go here
	}

}
