import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj datę urodzenia (dd-MM-yyyy): ");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(input, formatter);
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthDate, today);
        long daysSinceBirth = ChronoUnit.DAYS.between(birthDate, today);
        System.out.println("Masz: " + age.getYears() + " lat, " 
                           + age.getMonths() + " miesięcy i " 
                           + age.getDays() + " dni.");
        System.out.println("Łącznie dni od urodzin: " + daysSinceBirth);
        scanner.close();
    }
}