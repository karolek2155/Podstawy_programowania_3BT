import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wszystkie algorytmy sortowania");

        System.out.println("Podaj liczbę elementow do posortowania");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Wylosować liczby (1), czy wypiszesz z klawiatury (2)");
        int option = scanner.nextInt();
        while (!(option == 1 || option == 2)) {
            System.out.println("Podaj 1 lub 2");
            option = scanner.nextInt();
        }
        if (option == 1) {
            System.out.println("Podaj kolejno najmniejszy i największy element tablicy");
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            numbers = randomArray(size, min, max);
        }
        else {
            System.out.printf("Podaj koleno %d liczb calkowitych", size);
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }
        }

        System.out.println("\nTablica nieposortowana");
        for (int no : numbers) System.out.printf("%3d, ", no);

//        int maxAt = numbers[0];
//
//        for (int i = 0; i < numbers.length-1; i++) {
//            if (maxAt < numbers[i]) maxAt = numbers[i];
//        }
//
//        int digit = String.valueOf(maxAt).length();


        quickSort(numbers, 0, numbers.length-1);

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

    public static void bubbleSort(int[] numbers) {
        int temp;
        int size = numbers.length;
        for (int j = size - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] numbers) {
        int k;
        int temp;
        int size = numbers.length;

        for (int i = 0; i < size - 1; i++) {
            k = i;
            for (int j = i + 1; j < size; j++) {
                if (numbers[j] < numbers[k]) k = j;
            }
            temp = numbers[k];
            numbers[k] = numbers[i];
            numbers[i] = temp;
        }
    }

    public static void insertionSort(int[] numbers) {
        int size = numbers.length;
        int temp;
        int k;
        for (int i = 1; i < size; i++) {
            temp = numbers[i];
            k = i - 1;
            while (k >= 0 && numbers[k] > temp) {
                numbers[k + 1] = numbers[k];
                k--;
            }
            numbers[k + 1] = temp;
        }
    }

    public static void countingSort(int[] numbers, int max) {
        max += 1;
        int[] counters = new int[max];
        for (int i = 0; i < numbers.length; i++) {
            counters[numbers[i]]++;
        }
        int k = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < counters[i]; j++) {
                numbers[k] = i;
                k++;
            }
        }
    }


    public static void bucketSort1(int[] numbers, int degree) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }

        int digit;
        for (int i = 0; i < numbers.length; i++) {
            digit = numbers[i] / (int) Math.pow(10, degree) % 10;
            buckets[digit].add(numbers[i]);
        }

        int i = 0;
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < buckets[j].size(); k++) {
                numbers[i] = buckets[j].get(k);
                i++;
            }

        }
    }

    public static void bucketSort(int[] numbers, int degree) {
        int size = numbers.length;
        int[][] buckets = new int[10][size];
        int[] amountNumbers = new int[size];

        int digit;
        for (int i = 0; i < numbers.length; i++) {
            digit = (numbers[i] / (int) Math.pow(10, degree)) % 10;
            buckets[digit][amountNumbers[digit]] = numbers[i];
            amountNumbers[digit]++;
        }

        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < size; j++) {
                if (buckets[i][j] != 0) {
                    numbers[k] = buckets[i][j];
                    k++;
                }
            }

        }
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
