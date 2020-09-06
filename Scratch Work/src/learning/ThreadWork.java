package learning;

import java.util.*;


public class ThreadWork {
	final static int OOB = Integer.MAX_VALUE;
	final static int size = 9999999;
	static long start, stop, duration;
	static List<Long> durations;

	public static void main(String[] args) {
		durations = new ArrayList<Long>();

		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 9999999; i++) {
			list.add(i);
		}

		for (int i = 0; i < 100; i++) { 
			start = System.currentTimeMillis();
			list.stream().parallel().forEach((num)->found(num));
			//			System.out.println("Milliseconds: " + (stop-start));
			durations.add(stop-start);
		}

		durations.remove(0);
		average(durations);

		durations = new ArrayList<Long>();
		for (int k = 0; k < 100; k++) { 
			start = System.currentTimeMillis();
			for( int i = 0; i < list.size(); i++) {
				if(list.get(i) == size-1) {
					stop = System.currentTimeMillis();
					durations.add(stop-start);
					break;
				}
			}
		}

		durations.remove(0);
		average(durations);


		//		System.out.println("Average 1 Thread: " + (stop-start));
	}

	public static void found(int n) {
		if(n == size-1) stop = System.currentTimeMillis();
	}

	private static void average(List<Long> durations) {
		Long sum = (long) 0;
		for (Long duration : durations) {
			System.out.println("Run: " + duration);
			sum += duration;
		}
		System.out.println("Total time (ms): " + sum);
		System.out.println("Milliseconds: " + ((double)sum/(double)durations.size()));
	}

}
