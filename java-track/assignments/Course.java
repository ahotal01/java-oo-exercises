
public class Course {

	private String name;
	private int credits;
	private int remaining_seats;
	private Student[] roster;
	
	public Course(String name, int credits, int remaining_seats) {
		this.name = name;
		this.credits = credits;
		this.remaining_seats = remaining_seats;
		this.roster = new Student[remaining_seats];
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getRemainingSeats() {
		return this.remaining_seats;
	}
	
	public Student[] getRoster() {
		return this.roster;
	}
	
	public void setName(String new_name) {
		this.name = new_name;
	}
	
	public void setCredits(int new_credits) {
		this.credits = new_credits;
	}
	
	public void setRemainingSeats(int new_rem_seats) {
		this.remaining_seats = new_rem_seats;
	}
	
	public void setRoster(Student[] new_roster) {
		this.roster = new_roster;
	}
	
	public boolean addStudent(Student new_stu) {
		// TODO fill in Student adder
		return false;
	}
	
	public String generateRoster() {
		String fullRoster = "";
		for (int i = 0; i < this.roster.length - this.remaining_seats; i++) {
			fullRoster += "/n" + this.roster[i];
		}
		return fullRoster;
	}
	
	public double averageGPA() {
		double GPA_sum = 0.0;
		int num_students = this.roster.length - this.remaining_seats;
		for (int i = 0; i < num_students; i++) {
			GPA_sum += this.roster[i].getGPA();
		}
		double average = GPA_sum / num_students;
		return average;
	}
	
	public String toString() {
		return "Course number " + this.name + ", worth " + this.credits + " credits.";
	}

}
