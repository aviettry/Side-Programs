package backend;

public class Player {

	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String name() {
		return name;
	}
	
	public boolean equals(Player player) {
		return player.name().equalsIgnoreCase(name);
	}
}
