package c10examples;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Ex08 {

	public static void main(String[] args) {
		//long start = System.currentTimeMillis();
		atomicLong();
		//long stop = System.currentTimeMillis();
		//System.out.println("AtomicLong time = " + (stop - start));
		
//		long start_2 = System.currentTimeMillis();
//		longAdder();
//		long stop_2 = System.currentTimeMillis();
//		System.out.println("LongAdder time = " + (stop_2 - start_2));

	}

	private static void atomicLong() {
		final AtomicLong count = new AtomicLong();
		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println(Thread.currentThread().getName() + " - count = " + count.incrementAndGet());
			}
		};
		for (int i = 0; i < 1000; i++) {
			new Thread(task).start();
		}
	}

	private static void longAdder() {
		final LongAdder count = new LongAdder();
		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				count.increment();
				System.out.println(Thread.currentThread().getName() + " - count = " + count.longValue());
			}
		};
		for (int i = 0; i < 1000; i++) {
			new Thread(task).start();
		}
	}

}
