
public class Student {
	
	private String first_name;
	private String last_name;
	private int stu_ID;
	private int credits;
	private double GPA;
	
	public Student(String first_name, String last_name, int stu_ID) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.stu_ID = stu_ID;
		this.credits = 0;
		this.GPA = 0.0;
	}
	
	public String getName() {
		return this.first_name + " " + this.last_name;
	}
	
	public int getStudentID() {
		return this.stu_ID;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public double getGPA() {
		return this.GPA;
	}
	
	public void set_first_name(String new_first_name) {
		this.first_name = new_first_name;
	}
	
	public void set_last_name(String new_last_name) {
		this.last_name = new_last_name;
	}
	
	public void set_ID(int new_ID) {
		this.stu_ID = new_ID;
	}
	
	public void set_credits(int new_credits) {
		this.credits = new_credits;
	}
	
	public void set_GPA(double new_GPA) {
		this.GPA = new_GPA;
	}
	
	public String getClassStanding() {
		int credits = this.getCredits();
		if (credits < 30) {
			return "Freshman";
		} else if (credits < 60) {
			return "Sophomore";
		} else if (credits < 90) {
			return "Junior";
		} else return "Senior";
	}
	
	public void submitGrade(double grade, int credits) {
		double quality = credits * grade;
		this.GPA = ((this.GPA * this.credits) + quality) / (this.credits + credits);
		
		this.GPA = Math.round(this.GPA * 1000d) / 1000d;
		this.credits += credits;
	}
	
	public double computeTuition() {
		int credits = this.credits;
		double tuition = 20000;
		while (credits > 15) {
			tuition += 20000;
			credits -= 15;
		}
		return tuition;
	}
	
	public Student createLegacy(Student parent_one, Student parent_two) {
		Student legacy = new Student(parent_one.getName(), parent_two.getName(), 
				parent_one.getStudentID() + parent_two.getStudentID());
		legacy.set_GPA((parent_one.getGPA() + parent_two.getGPA()) / 2);
		if (parent_one.getCredits() > parent_two.getCredits()) {
			legacy.set_credits(parent_one.getCredits());
		} else legacy.set_credits(parent_two.getCredits());
		return legacy;
	}
	
	public String toString() {
		return this.first_name + " " + this.last_name + ", ID:" + this.stu_ID;
	}

}
