
public class Robot {
	
	private String name;
	private int x_coord;
	private int y_coord;
	private double speed;
	private int orientation;
	
	public Robot(String name, int x_coord, int y_coord, double speed, int orientation)
	{
		this.name = name;
		this.x_coord = x_coord;
		this.y_coord = y_coord;
		this.speed = speed;
		this.orientation = orientation;
	}
	
	public void move()
	{
		if (this.orientation == 0)
		{
			this.y_coord += this.speed;
		}
		else if (this.orientation == 90)
		{
			this.x_coord += this.speed;
		}
		else if (this.orientation == 180)
		{
			this.y_coord -= this.speed;
		}
		else this.x_coord -= this.speed;
	}
	
	public void rotate_l()
	{
		if (this.orientation == 0)
		{
			this.orientation = 270;
		}
		else this.orientation -= 90;
	}
	
	public void rotate_r()
	{
		if (this.orientation == 270)
		{
			this.orientation = 0;
		}
		else this.orientation += 90;
	}
	
	public double distance(Robot robot_two)
	{
		int x_one = this.x_coord;
		int x_two = robot_two.x_coord;
		
		int y_one = this.y_coord;
		int y_two = robot_two.y_coord;
		
		return ((x_one - x_two) * (x_one - x_two)) / ((y_one - y_two) * (y_one - y_two));
	}
	
	public String information()
	{
		return String.format("% is at (%, %), with an orientation of % degrees", this.name, this.x_coord, this.y_coord, this.orientation);
	}

	public static void main(String[] args) {
		
	}

}
