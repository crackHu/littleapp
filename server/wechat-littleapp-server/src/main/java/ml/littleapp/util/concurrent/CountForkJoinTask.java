package ml.littleapp.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

// 工作窃取算法 fork/join
@SuppressWarnings("serial")
public class CountForkJoinTask extends RecursiveTask<Integer> {

	private final static int THRESHOLD = 2;

	private int start;

	private int end;

	public CountForkJoinTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {

		int sum = 0;

		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (end + start) / 2;
			CountForkJoinTask leftTask = new CountForkJoinTask(start, middle);
			CountForkJoinTask rightTask = new CountForkJoinTask(middle + 1, end);
			leftTask.fork();
			rightTask.fork();
			
			Integer leftResult = leftTask.join();
			Integer rightResult = rightTask.join();
			
			sum = leftResult + rightResult;
		}
		// System.out.println(Thread.currentThread().getName());
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountForkJoinTask task = new CountForkJoinTask(1, 11111114);
		ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
		Integer integer = null;
		try {
			integer = submit.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(integer + " cost:" + (end - start) + "ms");
		
	}

}
