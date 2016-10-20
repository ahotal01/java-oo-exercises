
public class Rectangle {

	private int length;
	private int width;
	
	public Rectangle(int length, int width)
	{
		this.length = length;
		this.width = width;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int perimeter()
	{
		return this.length * 2 + this.width * 2;
	}
	
	public int area()
	{
		return this.length * this.width;
	}
	
	public boolean isSmaller(Rectangle r_2)
	{
		if (this.area() < r_2.area())
		{
			return true;
		}
		else return false;
	}
	
	public boolean isSquare()
	{
		if (this.length == this.width)
		{
			return true;
		}
		else return false;
	}

}
