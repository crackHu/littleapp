package ml.littleapp.util.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author amber2012
 * 
 *         Exchanger: 用于实现两个人之间的数据交换，每个人在完成一定的事务后想与对方交换数据，第一个先拿出数据的人将一直等待第二
 *         个人拿着数据到来时，才能彼此交换数据。
 */
public class ExchangerTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger exchanger = new Exchanger();

		service.execute(new Runnable() {
			public void run() {
				try {
					String data1 = "zxx";
					System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
					Thread.sleep(1000L);

					@SuppressWarnings("unchecked")
					String data2 = (String) exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
				} catch (Exception e) {
				}
			}
		});

		service.execute(new Runnable() {
			public void run() {
				try {
					String data1 = "lhm";
					System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
					Thread.sleep(2000L);

					@SuppressWarnings("unchecked")
					String data2 = (String) exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
				} catch (Exception e) {
				}
			}
		});
	}
}