package pl.gornik;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bubble sort");
        System.out.println("Podaj rozmiar zbioru liczbowego");
        int size = scanner.nextInt();
        double[] numbers = new double[size];

        System.out.println("Czy chcesz samemu wpisać elementy zbioru? Y / N");
        String info = scanner.next().toUpperCase();

        if (info.equals("Y")) {
            System.out.printf("Podaj koleno %d liczb\n", size);
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextDouble();
            }
        }
        else {
            for (int i = 0; i < size; i++) {
//                numbers[i] = Math.random() * 400 + 310;
                numbers[i] = (double) ((int) (Math.random() * 4000) + 3100) / 100;
            }
        }

        System.out.println("\nZbior liczbowy");
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && i % 10 == 0) System.out.println();
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nPosortowany zbior");
        double[] sortedNumbers = bubbleSort(numbers);
        for (int i = 0; i < sortedNumbers.length; i++) {
            if (i != 0 && i % 10 == 0) System.out.println();
            System.out.print(sortedNumbers[i] + " ");
        }
    }

    public static double[] bubbleSort(double[] numbers) {
        double temp;
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
        return numbers;
    }
}
