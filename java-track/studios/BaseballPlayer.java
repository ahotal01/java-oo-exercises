
public class BaseballPlayer {
	
	//Attributes:
	private String name;
	private int number;
	private String batting_type;
	private int total_runs;
	private int total_rbis;
	private int total_games;
	
	//Methods:
	public BaseballPlayer(String name, int number, String batting_type) {
		this.name = name;
		this.number = number;
		this.batting_type = batting_type;
		this.total_runs = 0;
		this.total_rbis = 0;
		this.total_games = 0;
	}
	
	public void add_game(int runs, int rbis) {
		this.total_runs += runs;
		this.total_rbis += rbis;
		this.total_games++;
	}
	
	public String toString() {
		return this.name + ", number " + this.number + ", who bats " + this.batting_type + ", has " 
				+ this.total_runs + " runs and " + this.total_rbis + " RBIs over the course of " 
				+ this.total_games + " games.";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
