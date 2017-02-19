package ml.littleapp;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class JoinThread extends Thread {
	public static volatile int n = 0;

	static void inc() {
		n++;
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				inc();
				sleep(100); // 为了使运行结果更随机，延迟3毫秒
				System.out.println("test");
			} catch (Exception e) {
			}
	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		Thread threads[] = new Thread[10];
		for (int i = 0; i < threads.length; i++) // 建立100个线程
			threads[i] = new JoinThread();
		for (int i = 0; i < threads.length; i++) {// 运行刚才建立的100个线程
			threads[i].start();
		}
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] dumpAllThreads = threadMXBean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : dumpAllThreads) {
			System.out.println(String.format("[%s] %s %s", threadInfo.getThreadId(), threadInfo.getThreadName(),
					threadInfo.getThreadState()));
		}
//	 for (int i = 0; i < threads.length; i++) { // 100个线程都执行完后继续
//		 threads[i].join();
//		 System.out.println("n=" + JoinThread.n);
//	 }
		// System.out.println(Thread.MIN_PRIORITY);
		// System.out.println(Thread.MAX_PRIORITY);
		Thread.interrupted();
		// TimeUnit.SECONDS.sleep(10);
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end - start) + " " + n);
	}
}