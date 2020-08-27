package backend;

import java.util.ArrayList;

public class Entry extends ArrayList<Player> {
	private static final long	serialVersionUID	= -6452204396597141474L;
	private ArrayList<Player>	entry							= new ArrayList<>();

	public Entry(Player player) {
		entry.add(player);
	}

	public Entry(Player partner1, Player partner2) {
		entry.add(partner1);
		entry.add(partner2);
	}

	public ArrayList<Player> players() {
		return this.entry;
	}

	public boolean contains(Entry entry) {
		for (Player player : this.entry) {
			for (Player player2 : entry.players()) {
				if (player.equals(player2))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Entry entry = new Entry(new Player("Ali"), new Player("Jamie"));
		Entry entry2 = new Entry(new Player("Jim"));
		System.out.println(entry.contains(entry2));
	}
}
