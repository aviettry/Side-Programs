package backend;

import java.util.ArrayList;

public class Schedule {
	private ArrayList<Interval> schedule = new ArrayList<>();
	private final int NUMBER_OF_COURTS;
	
	public Schedule(int numCourts) {
		NUMBER_OF_COURTS = numCourts;
	}
	
	public int last() {
		return schedule.size()-1;
	}
}
