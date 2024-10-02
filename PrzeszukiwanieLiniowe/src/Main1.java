import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz rozmiar tablicy do przeszukania");
        int n = scanner.nextInt();
        int[] numberArray = new int[n];
        for (int i = 0; i < n; i++){
            if (i % 10 == 0) System.out.println();
            numberArray[i] = (int)(Math.random() * 100) + 1;
            System.out.printf("%4d", numberArray[i]);
        }
        System.out.println("\nJaka jest szukana liczba?");
        int lockedForNumber = scanner.nextInt();
        int index = findIndex(numberArray, lockedForNumber);
        if (index >= 0)
            System.out.printf("W tablicy znaleziono szukaną liczbę %d na pozycji %d\n", lockedForNumber, index);
        else System.out.printf("W tablicy nie znaleziono szukanej liczby %d\n", lockedForNumber);


    }

    public static int findIndex(int[] numberArray, int number) {
        int increment = 0;
        int size = numberArray.length;
        while (increment < size && numberArray[increment] != number)
            increment++;
        if (increment == size) return -1;
        return increment;
    }
}
