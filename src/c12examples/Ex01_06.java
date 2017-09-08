package c12examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Ex01_06 {

	public static void main(String[] args) {
		System.out.println("Programmers' day " + getDateFromDayOfYear(2017, 256, "EEEE dd MMMM"));
		addYearTo();
		System.out.println(getDaysOfYourLife(1991, 04, 24));
		getFridays13(LocalDate.of(1900, 1, 13), LocalDate.of(1999, 12, 30)).forEach(System.out::println);
	}

	private static String getDateFromDayOfYear(int year, int dayOfYear, String pattern) {
		LocalDate date = LocalDate.ofYearDay(year, dayOfYear);
		String dateFormat = date.format(DateTimeFormatter.ofPattern(pattern, Locale.getDefault()));
		return dateFormat;
	}

	private static void addYearTo() {
		LocalDate date = LocalDate.of(2000, 2, 29).plusYears(1);
		System.out.println(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		// display last day of month in next year (28-02-2001)
	}

	private static long getDaysOfYourLife(int year, int month, int day) {
		LocalDate now = LocalDate.now();
		LocalDate daytOfBirth = LocalDate.of(year, month, day);
		return daytOfBirth.until(now, ChronoUnit.DAYS);
	}

	private static List<String> getFridays13(LocalDate start, LocalDate end) {
		List<String> fridays = new ArrayList<>();
		LocalDate startDate = start;
		int months = startDate.until(end).getYears() * 12;
		for (int i = 0; i < months; i++) {
			LocalDate friday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
			String fridayFormat = friday.format(DateTimeFormatter.ofPattern("E dd MMMM yyyy", Locale.getDefault()));
			if (friday.getDayOfMonth() == 13) {
				fridays.add(fridayFormat);
			}
			startDate = startDate.plusMonths(1);
		}
		return fridays;
	}

}
