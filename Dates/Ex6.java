import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.print("Podaj pierwszą datę i czas (dd-MM-yyyy HH:mm): ");
        String firstInput = scanner.nextLine();
        LocalDateTime firstDateTime = LocalDateTime.parse(firstInput, formatter);

        System.out.print("Podaj drugą datę i czas (dd-MM-yyyy HH:mm): ");
        String secondInput = scanner.nextLine();
        LocalDateTime secondDateTime = LocalDateTime.parse(secondInput, formatter);

        LocalDateTime start = firstDateTime;
        LocalDateTime end = secondDateTime;
        if (secondDateTime.isBefore(firstDateTime)) {
            start = secondDateTime;
            end = firstDateTime;
        }

        Duration diff = Duration.between(start, end);

        long days = diff.toDays();
        long hours = diff.minusDays(days).toHours();
        long minutes = diff.minusDays(days).minusHours(hours).toMinutes();

        System.out.println("Różnica: ");
        System.out.println("  Dni:    " + days);
        System.out.println("  Godzin: " + hours);
        System.out.println("  Minut:  " + minutes);

        scanner.close();
    }
}