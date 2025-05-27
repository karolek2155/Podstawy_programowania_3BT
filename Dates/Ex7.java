import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Podaj datę wystawienia faktury (dd-MM-yyyy): ");
        String invoiceDateInput = scanner.nextLine();
        LocalDate invoiceDate = LocalDate.parse(invoiceDateInput, formatter);

        System.out.print("Podaj termin płatności w dniach: ");
        int paymentPeriodDays = Integer.parseInt(scanner.nextLine());

        LocalDate paymentDate = invoiceDate.plusDays(paymentPeriodDays);

        System.out.println("Data płatności: " + paymentDate.format(formatter));

        scanner.close();
    }
}