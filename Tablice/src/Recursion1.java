import java.util.Scanner;

public class Recursion1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe wyrazow ciagu: ");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.print(calculateElement(i + 1) + ", ");
        }

        System.out.printf("\nSuma %d tego ciagu wynosi: %d", number, calculateSum(number));

    }

    public static double calculateElement(int n) {
        if (n == 1) return 2;
        return 2 * calculateElement(n - 1) - 0.5;
    }

    public static double calculateSum(int n) {
        if (n == 1) return 2;
        if (n == 2) return 5.5;
        return calculateSum(n - 1) + calculateElement(n);
    }
}
