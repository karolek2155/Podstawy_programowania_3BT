import java.util.Scanner;

public class ReservedText {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Napisz tekst do odwrocenia");
        String text = scanner.nextLine();
        String reservedText = "";
        for (int i = text.length() - 1; i >=0; i--) {
            reservedText = reservedText.concat(String.valueOf(text.charAt(i)));
        }
        System.out.println("Owrocony tekst to " + reservedText);


    }
}
