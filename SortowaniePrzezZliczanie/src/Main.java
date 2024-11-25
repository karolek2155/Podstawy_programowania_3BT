import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        podaj max wart liczbowa w tablicy
//        podaj rozmiar tablicy
//        wygeneruj tablice

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj max wartość w tablicy");
        int max = scanner.nextInt();
        System.out.println("Podaj rozmiar tablicy");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * max);
        }

        System.out.println("Nieposortowana tablica");
        for (int i = 0; i < size; i++) {
            System.out.printf(numbers[i] + ", ");
        }

        countingSort(numbers, max);

        System.out.println("\nPosortowana tablica");
        for (int i = 0; i < size; i++) {
            System.out.printf(numbers[i] + ", ");
        }

    }

    public static void countingSort(int[] numbers, int max) {
        int[] counters = new int[max];
        for (int i = 0; i < numbers.length; i++) {
            counters[numbers[i]]++;
        }
        int k = 0;
        for (int i = 0; i < max; i++) {
            for (int j = counters[i]; j > 0; j--) {
                numbers[k] = i;
                k++;
            }
        }
    }
}