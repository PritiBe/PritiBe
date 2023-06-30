

import java.util.Hashtable;

class StopWatch {
	private static final Hashtable<String, Long> tasks = new Hashtable<String, Long>();

	public static void start(String taskId) {
		tasks.put(taskId, new Long(System.currentTimeMillis()));
	}
	public static long stop(String taskId) {
		return System.currentTimeMillis()
				- ((Long) tasks.remove(taskId)).longValue();
	}
	public static void executeTask1() {
		System.out.println("Task 1 done");
	}
	public static void executeTask2() {
		System.out.println("Task 2 done");
	}
	public static void main(String[] args) {
		// Start a global stopwatch
		StopWatch.start("GLOBAL");

		// evaluate time used by task 1
		StopWatch.start("TASK1");
		executeTask1();
		System.out.println("Time elapsed for task 1 : "
				+ StopWatch.stop("TASK1") + "ms");

		// evaluate time used by task 2
		StopWatch.start("TASK2");
		executeTask2();
		System.out.println("Time elapsed for task 2 : "
				+ StopWatch.stop("TASK2") + "ms");

		// Display time elapsed for full processing
		System.out.println("Total processing time : "
				+ StopWatch.stop("GLOBAL") + "ms");
	}
}