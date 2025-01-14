import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algorytm plecakowy ogólny");
        System.out.println("Podaj rozmiar zbiorów");
        int size = scanner.nextInt();
        int[] values = new int[size];
        int[] weights = new int[size];
        int[] usedProducts = new int[size];

        System.out.println("Wpisz kolejno elementy zbioru, najpierw wartość, potem ich wagę");
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        sortArray(values, weights);
        System.out.println("Wartości i wagi po sortowaniem");
        for (int i = 0; i < size; i++) {
            System.out.print(values[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(weights[i] + ", ");
        }


        System.out.println("\nPodaj maksymalną wagę plecaka");
        int weight = scanner.nextInt();

        int valueBackpack = packBackpack(values, weights, weight, usedProducts);
        System.out.println("Wartość plecaka " + valueBackpack);
        System.out.println("Zapakowano: ");
        for (int i = 0; i < size; i++) {
            if (usedProducts[i] != 0) {
                System.out.println(usedProducts[i] + " o wadze " + weights[i]);
            }
        }
    }

    public static void sortArray(int[] values, int[] weights) {
        int valueTemp;
        int weightTemp;
        for (int i = 1; i < values.length; i++) {
            valueTemp = values[i];
            weightTemp = weights[i];
            for (int j = i - 1; j >= 0; j--) {
                if ((double) values[j] / weights[j] < (double) valueTemp / weightTemp) {
                    values[j + 1] = values[j];
                    weights[j + 1] = weights[j];
                    values[j] = valueTemp;
                    weights[j] = weightTemp;
                }
            }
        }
    }

    public static int packBackpack(int[] values, int[] weights, int weight, int[] usedProducts) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            usedProducts[i] = weight / weights[i];
            weight -= weights[i] * usedProducts[i];
            result += values[i] * usedProducts[i];
        }
        return result;
    }
}