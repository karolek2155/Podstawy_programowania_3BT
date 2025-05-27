import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Podaj pierwszą datę (dd-MM-yyyy): ");
        String firstInput = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstInput, formatter);

        System.out.print("Podaj drugą datę (dd-MM-yyyy): ");
        String secondInput = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondInput, formatter);

        if (firstDate.isBefore(secondDate)) {
            System.out.println("Pierwsza data (" + firstDate.format(formatter) + ") jest wcześniejsza niż druga (" + secondDate.format(formatter) + ").");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("Druga data (" + secondDate.format(formatter) + ") jest wcześniejsza niż pierwsza (" + firstDate.format(formatter) + ").");
        } else {
            System.out.println("Obie daty są takie same: " + firstDate.format(formatter));
        }

        scanner.close();
    }
}