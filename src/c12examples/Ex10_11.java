package c12examples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ex10_11 {

	public static void main(String[] args) {
		String timeFromLAToFrankfurt = timeInDestinationCountry(3, 5, 650, "America/Los_Angeles", "Europe/Berlin");
		System.out.println("Arrival time " + timeFromLAToFrankfurt);

		long flyingTime = flyingTime(LocalTime.of(14, 5), LocalTime.of(16, 40), "Europe/Berlin", "America/Los_Angeles");
		System.out.println("Flying times in minutes = " + flyingTime);
	}

	private static String timeInDestinationCountry(int hour, int minute, int flyingTimeInMinutes, String localZoneId,
			String destinationZoneId) {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute));
		ZonedDateTime localZonedTime = localDateTime
												.atZone(ZoneId.of(localZoneId));
		ZonedDateTime destinationLocalDate = localZonedTime
													.plusMinutes(flyingTimeInMinutes)
													.withZoneSameInstant(ZoneId.of(destinationZoneId));
		return destinationLocalDate.format(DateTimeFormatter.ofPattern("HH:mm:ss dd MMMM yyyy"));
	}

	private static long flyingTime(LocalTime localTime, LocalTime destinationTime, String localZoneId, String destinationZoneId) {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
		LocalDateTime destDateTime = LocalDateTime.of(LocalDate.now(), destinationTime);
		ZonedDateTime localZonedTime = ZonedDateTime.of(localDateTime,  ZoneId.of(localZoneId));
		ZonedDateTime destZoneTime = ZonedDateTime.of(destDateTime, ZoneId.of(destinationZoneId));
		return Duration.between(localZonedTime, destZoneTime).toMinutes();
	}
}
