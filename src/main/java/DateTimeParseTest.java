import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.temporal.ChronoField.MILLI_OF_DAY;

public class DateTimeParseTest {
    public static void main(String[] args) {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
//        String datetimeString = "2020-01-08 15:17:39.414217";
//        dtf = dtf.withZone(ZoneId.of("+07:00"));
//        LocalDateTime ldt = LocalDateTime.parse(datetimeString, dtf);
//        System.out.println(ldt.toInstant(ZoneOffset.of("+07:00")).toEpochMilli());

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSX");
//        String datetimeString = "2020-01-08 15:17:39.414217+07";
//        LocalDateTime ldt = LocalDateTime.parse(datetimeString, dtf);
//        System.out.println(ldt.toInstant(ZoneOffset.of("+07:00")).toEpochMilli());

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");
//        String datetimeString = "1970-01-01 07:00:00+07";
//        LocalDateTime ldt = LocalDateTime.parse(datetimeString, dtf);
//        System.out.println(ldt.toInstant(ZoneOffset.of("+07:00")).toEpochMilli());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ssX");
        String datetimeString = "13:34:25+07";
        LocalTime lt = LocalTime.parse(datetimeString, dtf);
        System.out.println(lt.getLong(MILLI_OF_DAY));

//        LocalDateTime dateTime = LocalDateTime.of(2020, 1, 8, 15, 17, 39, 414217);
//        ZoneOffset offset = ZoneOffset.of("+05:00");
//        OffsetDateTime odt = OffsetDateTime.of(dateTime, offset);
//        System.out.println(odt.format(dtf));

//        ZonedDateTime zdt = dateTime.atZone(ZoneId.of("Asia/Shanghai"));
//        System.out.println(zdt.format(dtf));
    }
}
