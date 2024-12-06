import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static int MAX;
    public static int SIZE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sortowanie kubełkowe (bucket sort");

        System.out.println("Podaj rozmiar tablicy do posrtowania");
        SIZE = scanner.nextInt();
        System.out.println("Podaj maksymalną wartość liczbową tablicy");
        MAX = scanner.nextInt();

        int digit = String.valueOf(MAX).length();
        int[] numbers = new int[SIZE];

        System.out.println("\nNieposortowana tablica");
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = (int) (Math.random() * MAX) + 1;
            System.out.printf("%4d", numbers[i]);
        }

        for (int i = 0; i < digit; i++) {
            bucketSort(numbers, i);
        }
        System.out.println("\n\nPosortowana tablica");
        for (int number : numbers) System.out.printf("%4d", number);
    }

    public static void bucketSort(int[] numbers, int degree) {
        int[][] buckets = new int[10][SIZE];
        int[] amountNumbers = new int[SIZE];

        int digit;
        for (int i = 0; i < numbers.length; i++) {
            digit = (numbers[i] / (int) Math.pow(10, degree)) % 10;
            buckets[digit][amountNumbers[digit]] = numbers[i];
            amountNumbers[digit]++;
        }

        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buckets[i][j] != 0) {
                    numbers[k] = buckets[i][j];
                    k++;
                }
            }

        }
    }
}
