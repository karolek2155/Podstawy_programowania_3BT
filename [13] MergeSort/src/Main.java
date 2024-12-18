import java.util.Scanner;

public class Main {
    private static int SIZE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sortowanie przez scalanie 'Merge Sort");

        System.out.println("Podaj kolejno rozmiar tablicy, potem najmniejszy i największy element tablicy");
        SIZE = scanner.nextInt();
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        System.out.println("\nTablica nieposortowana");
        int[] numbers = randomArray(SIZE, min, max);
        for (int no : numbers) System.out.printf("%3d, ", no);

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("\nTablica posortowana");
        for (int no : numbers) System.out.printf("%3d, ", no);
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

    public static void mergeArray(int[] numbers, int left, int right) {
        int[] temp = new int[SIZE];
        for (int i = 0; i < SIZE; i++) temp[i] = numbers[i];
        int middle, iLeft, iRight, i;
        middle = (left + right) / 2;
        i = left;
        iLeft = left;
        iRight = middle + 1;
        while (iLeft <= middle && iRight <= right) {
            if (temp[iLeft] < temp[iRight]) {
                numbers[i] = temp[iLeft];
                iLeft++;
            } else {
                numbers[i] = temp[iRight];
                iRight++;
            }
            i++;
        }
        if (iLeft > middle) {
            while (iRight <= right) {
                numbers[i] = temp[iRight];
                iRight++;
                i++;
            }
        } else {
            while (iLeft <= middle) {
                numbers[i] = temp[iLeft];
                iLeft++;
                i++;
            }
        }
    }

    public static int[] mergeSort(int[] numbers, int left, int right) {
        int middle = (left + right) / 2;
        if (left < middle) mergeSort(numbers, left, middle);
        if (middle + 1 < right) mergeSort(numbers, middle + 1, right);
        mergeArray(numbers, left, right);
        return numbers;
    }
}