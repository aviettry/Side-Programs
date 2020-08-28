package backend;

import java.util.ArrayList;

public class Schedule {
	private ArrayList<Interval> schedule = new ArrayList<>();
	
	public Schedule() {
		
	}
	
	public int last() {
		return schedule.size()-1;
	}
}
