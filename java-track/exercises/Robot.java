
public class Robot {
	
	private String name;
	private int x_coord;
	private int y_coord;
	private int speed;
	private int orientation;
	
	public Robot(String name, int x_coord, int y_coord, int speed, int orientation)
	{
		this.name = name;
		this.x_coord = x_coord;
		this.y_coord = y_coord;
		this.speed = speed;
		this.orientation = orientation;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getX_coord() {
		return this.x_coord;
	}
	
	public int getY_coord() {
		return this.y_coord;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getOrientation() {
		return this.orientation;
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
		
		return Math.sqrt((x_one - x_two) * (x_one - x_two) + (y_one - y_two) * (y_one - y_two));
	}
	
	public String toString()
	{
		return String.format("%s is at (%s, %s), with an orientation of %s degrees", this.name, this.x_coord, this.y_coord, this.orientation);
	}

	public static void main(String[] args) {
		
	}

}
