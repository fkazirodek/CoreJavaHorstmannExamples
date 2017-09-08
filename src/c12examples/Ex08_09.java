package c12examples;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class Ex08_09 {

	public static void main(String[] args) {
		//timeZones();
		halfHourTimeOffsetZones();

	}

	//Time zones offset by less than one hour
	private static void halfHourTimeOffsetZones() {
		ZoneId.getAvailableZoneIds()
								.stream()
									.filter(zoneId -> {
											if (TimeZone.getTimeZone(zoneId).getRawOffset() % 3600000 == 0) {
												return false;
											} else {
												return true;
											}
										})
									.map(ZoneId::of)
									.map(ZonedDateTime::now)
									.forEach(zonedTime -> {
											System.out.println(zonedTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss OOOO zzzz ")));
										});
	}

	private static void timeZones() {
		ZoneId.getAvailableZoneIds()
								.stream()
									.map(ZoneId::of)
									.map(ZonedDateTime::now)
									.forEach(zonedTime -> {
											System.out.println(zonedTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss OOOO zzzz ")));
										});
	}
}
