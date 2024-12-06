import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sortowanie szybkie 'Quick Sort");

        System.out.println("Podaj kolejno rozmiar tablicy, potem najmniejszy i największy element tablicy");
        int size = scanner.nextInt();
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        System.out.println("\nTablica nieposortowana");
        int[] numbers = randomArray(size, min, max);
        for (int no : numbers) System.out.printf("%3d", no);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\nTablica posortowana");
        for (int no : numbers) System.out.printf("%3d", no);
    }

    public static int[] randomArray(int amount, int min, int max) {
        int[] numbers = new int[amount];
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        for (int i = 0; i < amount; i++) {
            numbers[i] = (int) (Math.random() * (max - min)) + min;
        }
        return numbers;
    }

    public static void quickSort(int[] numbers, int left, int right) {
        int i = left;
        int j = right;
        int middle = numbers[(i + j) / 2];
        int temp;

        do {
            while (numbers[i] < middle) i++;
            while (numbers[j] > middle) j--;
            if (i <= j) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j) quickSort(numbers, left, j);
        if (right > i) quickSort(numbers, i, right);
    }
}