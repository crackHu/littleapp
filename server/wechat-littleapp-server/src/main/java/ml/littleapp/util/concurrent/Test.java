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
package ml.littleapp.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ml.littleapp.pojo.SysOffice;

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

	// 1. 懒汉，线程安全, 效率低下
	private static class LazyLoad {

		public LazyLoad() {
			System.out.println("LazyLoad create");
		}

		private static LazyLoad lazy = null;

		public synchronized static LazyLoad getInstance() {
			if (lazy == null) {
				System.out.println(1111);
				lazy = new LazyLoad();
			}
			return lazy;

		}
	}

	// （双重校验锁）
	private static class DoubleCheck {

		private DoubleCheck() {
			System.out.println("doubleCheck create");
		}

		private static DoubleCheck doubleCheck = null;

		public static DoubleCheck getInstance() {
			if (doubleCheck == null) {
				synchronized (DoubleCheck.class) {
					if (doubleCheck == null) {
						System.out.println(2222);
						doubleCheck = new DoubleCheck();
					}
				}
			}
			return doubleCheck;
		}
	}
	
	// Volatile （双重校验锁）
	private static class VolatileInstance {
		private VolatileInstance() {
			System.out.println("VolatileInstance create");
		}

		private volatile static  VolatileInstance instance = null;

		public static VolatileInstance getInstance() {
			if (instance == null) {
				synchronized (DoubleCheck.class) {
					if (instance == null) {
						System.out.println(3333);
						instance = new VolatileInstance();
					}
				}
			}
			return instance;
		}
	}
	
	// 利用 classloader（静态内部类）
	private static class LazyInnerClass {
		private LazyInnerClass() {
			System.out.println("LazyInnerClass create");
		}
		
		private static class SingletonHolder {
			public SingletonHolder() {
				System.out.println(4444);
			}
			static {
				System.out.println(4445);
			}
			public static LazyInnerClass instance = new LazyInnerClass();
		}
		
		public static LazyInnerClass getInstance() {
			return SingletonHolder.instance;
		}
	}

	public static void main(String[] args) {
		
		LazyInnerClass.getInstance();
		LazyInnerClass.getInstance();
		LazyInnerClass.getInstance();

		// 100000 singleton: 6 | lazySingleton: 11
		// 20000 * 5 singleton: 1 1 1 2 3 | lazySingleton: 9 11 15 15 16 | double: 4 5 4 5 6 | volatile: 5 6 4 4 4 | lazyclass: 5 6 5 4 4

//		Runnable singleton = () -> {
//			long begin = System.currentTimeMillis();
//			for (int i = 0; i < 20000; i++) {
//				Test instance = Test.getInstance();
//			}
//			System.err.println("singleton:" + (System.currentTimeMillis() - begin) + Thread.currentThread().getName());
//		};
//
//		Runnable lazySingleton = () -> {
//			long begin = System.currentTimeMillis();
//			for (int i = 0; i < 20000; i++) {
//				LazyLoad instance = LazyLoad.getInstance();
//			}
//			System.err.println(
//					"lazySingleton:" + (System.currentTimeMillis() - begin) + Thread.currentThread().getName());
//		};
//
//		Runnable doubleCheck = () -> {
//			long begin = System.currentTimeMillis();
//			for (int i = 0; i < 20000; i++) {
//				DoubleCheck instance = DoubleCheck.getInstance();
//			}
//			System.err
//					.println("doubleCheck:" + (System.currentTimeMillis() - begin) + Thread.currentThread().getName());
//		};
//
//		Runnable volatileInstance = () -> {
//			long begin = System.currentTimeMillis();
//			for (int i = 0; i < 20000; i++) {
//				VolatileInstance instance = VolatileInstance.getInstance();
//			}
//			System.err.println(
//					"VolatileInstance:" + (System.currentTimeMillis() - begin) + Thread.currentThread().getName());
//		};
//		
//		Runnable lazyInner = () -> {
//			long begin = System.currentTimeMillis();
//			for (int i = 0; i < 20000; i++) {
//				LazyInnerClass instance = LazyInnerClass.getInstance();
//			}
//			System.err.println(
//					"LazyInnerClass:" + (System.currentTimeMillis() - begin) + Thread.currentThread().getName());
//		};
//
//		ExecutorService service = Executors.newCachedThreadPool();
//		try {
//			for (int i = 0; i < 5; i++) {
//				Future<?> submit = service.submit(singleton);
//				service.submit(lazySingleton);
//				service.submit(doubleCheck);
//				service.submit(volatileInstance);
//				service.submit(lazyInner);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			service.shutdown();
//		}

	}
}
