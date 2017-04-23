/**
 * @Company Copyright © 2017 油兔不二. All rights reserved.
 *
 * @Title: Test.java
 * @Prject: wechat-littleapp-server
 * @Package: ml.littleapp.util
 * @Description: TODO
 * @author: crack
 * @date: 2017年4月23日 下午6:49:52
 * @version: V1.0
 */
package ml.littleapp.util;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.tomcat.util.collections.ConcurrentCache;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: crack
 * @date: 2017年4月23日 下午6:49:52
 */
@SuppressWarnings("unused")
public class Test {

	private Test() {
		System.out.println("Test create");
	}

	private static Test test = new Test();

	public static Test getInstance() {
		return test;
	}

	public static void createString() {

	}

	private static class LazyLoad {

		public LazyLoad() {
			System.out.println("LazyLoad create");
		}

		private static LazyLoad lazy = null;

		public synchronized static LazyLoad getInstance() {
			if (lazy == null) {
				return new LazyLoad();
			}
			return lazy;

		}

		public static class La {
			public La() {
				System.out.println("La is create");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		 ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
		
		Runnable hello = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i + " hello " + Thread.currentThread());
			}
		};
		Runnable bye = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i + " bye " + Thread.currentThread());
			}
		};

		Callable<String> hello1 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i + " hello " + Thread.currentThread());
			}
			return "hello1";
		};

		Callable<String> bye1 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i + " bye " + Thread.currentThread());
			}
			return "bye1";
		};
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);

		FutureTask<String> submit = new FutureTask<>(hello1);
		FutureTask<String> submit2 = new FutureTask<>(bye1);
		
		service.execute(submit);
		service.execute(submit2);

		// Future<String> submit = service.submit(hello1);
		// Future<String> submit2 = service.submit(bye1);

		String string1 = submit.get(10, TimeUnit.SECONDS);
		String string2 = submit2.get(10, TimeUnit.SECONDS);

		System.err.println(string1);
		System.err.println(string2);

		service.shutdown();
	}
}
