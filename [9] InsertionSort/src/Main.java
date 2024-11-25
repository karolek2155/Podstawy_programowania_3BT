import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę elementów do posortowania");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Czy chcesz wylosować liczby (1), czy wypisać je z klawiatury (2)");
        int option = scanner.nextInt();
        while (!(option == 1 || option == 2)) {
            System.out.println("Podaj 1 lub 2");
            option = scanner.nextInt();
        }
        if (option == 1) {
            for (int i = 0; i < size; i++) {
                numbers[i] = (int) (Math.random() * 100);
            }
        }
        else {
            System.out.printf("Podaj koleno %d liczb calkowitych", size);
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }
        }

        System.out.println("Nieposortowane liczby");
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d", numbers[i]);
        }
        System.out.println("\nPosortowane liczby");
        insertionSort(numbers);
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d", numbers[i]);
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
}
