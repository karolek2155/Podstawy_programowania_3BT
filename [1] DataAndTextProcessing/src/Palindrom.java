import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Napisz tekst do sprawdzenia");
        String text = scanner.nextLine();

//        I sposób
//        String reservedText = "";
//        for (int i = text.length() - 1; i >=0; i--) {
//            reservedText = reservedText.concat(String.valueOf(text.charAt(i)));
//        }
//
//        if (text.equals(reservedText)) System.out.println("Ten tekst jest palindromem");
//        else System.out.println("Ten tekst nie jest palindromem");


//        II sposób
        boolean isPalindom = true;
        for (int i = 0; i < text.length()/2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                isPalindom = false;
                break;
            }
        }
        if (isPalindom) System.out.println("Ten tekst jest palindromem");
        else System.out.println("Ten tekst nie jest palindromem");
    }
}
