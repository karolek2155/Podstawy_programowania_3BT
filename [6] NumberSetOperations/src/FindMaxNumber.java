import java.util.Scanner;

public class FindMaxNumber {

    public static int index;

    public static void main(String[] args) {

        System.out.println("Przeszukiwanie zbioru liczbowego (najwikeszy element)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rozmiar zbioru");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        System.out.println("Tablica liczb");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + ", ");
        }

        System.out.printf("\nNajwiększa liczba w tym zbiorze to %d na pozycji %d", findMaxNumber(numbers), index);

    }

    public static int findMaxNumber(int[] numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > max) {
                index = i;
                max = numbers[i];
            }
        }
        return max;
    }
}
