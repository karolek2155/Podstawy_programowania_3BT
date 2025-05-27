import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

public class Ex5 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Month month = Month.MAY;

        LocalDate firstOfMay = LocalDate.of(year, month, 1);

        LocalDate firstSunday = firstOfMay;
        while (firstSunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            firstSunday = firstSunday.plusDays(1);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Wszystkie niedziele w maju " + year + ":");

        LocalDate current = firstSunday;
        while (current.getMonth() == month) {
            System.out.println(current.format(formatter));
            current = current.plusWeeks(1);
        }
    }
}