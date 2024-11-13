package pl.gornik;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sortowanie 'Selection Sort'");
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

        System.out.println("Wylosowane liczby");
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d", numbers[i]);
        }
        System.out.println("\nPosortowane liczby");
        selectionSort(numbers);
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d", numbers[i]);
        }

    }

    public static void selectionSort(int[] numbers) {
        int k;
        int temp;
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            k = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[k]) k = j;
            }
            temp = numbers[k];
            numbers[k] = numbers[i];
            numbers[i] = temp;
        }
    }
}
