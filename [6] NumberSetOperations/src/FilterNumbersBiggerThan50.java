import java.util.Scanner;

public class FilterNumbersBiggerThan50 {

    public static int counter;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz rozmiar tablicy do przeszukania");
        int n = scanner.nextInt();
        int[] numberArray = new int[n];
        System.out.println("\nWszystkie liczby");
        for (int i = 0; i < n; i++){
            if (i % 10 == 0) System.out.println();
            numberArray[i] = (int)(Math.random() * 100) + 1;
            System.out.printf("%4d", numberArray[i]);
        }


        int[] foundedArray = findNumbersBiggerThan50(numberArray);
        System.out.println("\nLiczby większe od 50");
        for (int i = 0; i < counter; i++){
            if (i % 10 == 0) System.out.println();
            System.out.printf("%4d", foundedArray[i]);
        }

    }

    public static int[] findNumbersBiggerThan50(int[] numberArray) {
        int size = numberArray.length;
        int[] numberLargerThan50 = new int[size];
        counter = 0;
        for (int i = 0; i < size; i++) {
            if (numberArray[i] > 50) {
                numberLargerThan50[counter] = numberArray[i];
                counter++;
            }
        }
        return numberLargerThan50;

    }
}
