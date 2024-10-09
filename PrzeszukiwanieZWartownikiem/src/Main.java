import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Przeszukiwanie zbioru liczbowego z wartownikiem");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rozmiar zbioru");
        int size = scanner.nextInt();
        System.out.println("Podaj liczby zbioru");
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println("Tablica liczb");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("\nWpisz szukaną liczbę");
        int lookedForNumber = scanner.nextInt();

        int index = findNumber(numbers, lookedForNumber);
        if (index < numbers.length) System.out.println("Szukana liczba znajduje się w zbiorze na pozycji " + index);
        else System.out.println("Szukanej liczby nie ma w zbiorze");
    }

    public static int findNumber(int[] numbers, int lookedForNumber) {

        int[] numbersWithSentry = new int[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbersWithSentry[i] = numbers[i];
        }
        numbersWithSentry[numbers.length] = lookedForNumber;

        int index = 0;
        while (numbersWithSentry[index] != lookedForNumber) index++;

        return index;
    }
}
