package c10examples;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

public class Ex09 {

	public static void main(String[] args) {

		LongAccumulator accuMax = new LongAccumulator(Math::max, Long.MIN_VALUE);
		LongAccumulator accuMin = new LongAccumulator(Math::min, Long.MAX_VALUE);
		Random r = new Random();
		Long[] l = new Long[10];
		for (int i = 0; i < 10; i++) {
			long nextLong = r.nextLong();
			l[i] = nextLong;
			accuMax.accumulate(nextLong);
			accuMin.accumulate(nextLong);
		}
		System.out.println(Arrays.toString(l));
		System.out.println("Max value = " + accuMax.get());
		System.out.println("Min value = " + accuMin.get());
	}

}
