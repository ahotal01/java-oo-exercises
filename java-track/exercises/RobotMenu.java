import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	private ArrayList<Robot> robots;
	private Scanner s;
	
	public static void main(String[] args) 
	{
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x != 6);
	}
	
	public RobotMenu() 
	{
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public int startMenu()
	{
		System.out.println("Welcome to the robot menu!");
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option: ");
		int selection = s.nextInt();
		while (selection < 0 || selection > 6)
		{
			System.out.println("Invalid selection, please try again: ");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection)
	{
		switch(selection) {
			case 1: createRobot();
			case 2: displayRobots();
			case 3: {
				displayRobots();
				Robot r = selectRobot();
				r.move();
			}
			case 4: {
				displayRobots();
				Robot r = selectRobot();
				System.out.println("Rotate right or left? (Enter R/L)");
				String dir = s.next();
				while (dir != "R" && dir != "L")
				{
					System.out.println("Invalid direction. Please enter R or L.");
					dir = s.next();
				}
				if (dir == "R")
				{
					r.rotate_r();
				} else r.rotate_l();
				System.out.println("The Robot now has an orientation of " 
						+ r.getOrientation() + " degrees.");
			}
			case 5: {
				displayRobots();
				Robot r_1 = selectRobot();
				Robot r_2 = selectRobot();
				System.out.println("The distance between " + r_1.getName() + " and " 
						+ r_2.getName() + " is " + r_1.distance(r_2) + " units.");
			}
			default: break;
		}
	}
	
	private void displayRobots()
	{
		for (int i = 0; i < robots.size(); i++)
		{
			System.out.println((i + 1) + ".)" + robots.get(i));
		}
	}
	
	private Robot selectRobot() {
		System.out.println("Please select a Robot: ");
		int selection = s.nextInt();
		while (selection < 1 || selection > robots.size())
		{
			System.out.println("Invalid selection, please try again: ");
			selection = s.nextInt();
		}
		return robots.get(selection - 1);
	}
	
	private void createRobot()
	{
		System.out.println("Please enter a name for the Robot: ");
		String name = s.next();
		System.out.println("Please enter an x_coordinate for the Robot: ");
		int x_coord = s.nextInt();
		System.out.println("Please enter a y_coordinate for the Robot: ");
		int y_coord = s.nextInt();
		System.out.println("Please enter a speed for the Robot: ");
		int speed = s.nextInt();
		System.out.println("Please enter an orientation for the Robot, in degrees: ");
		int orient = s.nextInt();
		while (orient != 0 && orient != 90 && orient != 180 && orient != 270)
		{
			System.out.println("Invalid orientation. Please enter 0, 90, 180, or 270.");
			orient = s.nextInt();
		}
		robots.add(new Robot(name, x_coord, y_coord, speed, orient));
	}
}
