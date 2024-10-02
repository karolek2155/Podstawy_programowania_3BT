import java.util.Scanner;

public class Iteration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe wyrazow ciagu 2, 5, 8, 11,...");
        int number = scanner.nextInt();
        int value = 2;
        int sum = 0;

        System.out.println("Ciąg:");
        for (int i = 0; i < number; i++){
            System.out.print(value + ", ");
            sum += value;
            value += 3;
        }
        System.out.println("\nSuma liczb tego ciągu wynosi: " + sum);
    }
}
