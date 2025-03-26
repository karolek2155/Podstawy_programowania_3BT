package paz.zad1;

public class Main {


    public static void main(String[] args) {

        int[] numberArray = new int[30];

        System.out.println("Tablica liczb");
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = (int) (Math.random() * (80 - 31) + 31);
            System.out.printf(numberArray[i] + ", ");
        }

        int[] numbersDeviceBy7 = findNumbersDeviceBy7(numberArray);
        System.out.println();
        if (numbersDeviceBy7.length > 0) {
            int sum = 0;
            int count = 0;
            System.out.println("Liczby podzielne przez 7:");
            for (int i = 0; i < numbersDeviceBy7.length; i++) {
                System.out.printf(numbersDeviceBy7[i] + ", ");
                sum += numbersDeviceBy7[i];
                count++;
            }
            System.out.println("\nTakich liczb jest " + count + ", a suma ich wynosi " + sum);
        }
        else System.out.println("Tablica nie zawiera liczb podzielnych przez 7");

    }

    public static int[] findNumbersDeviceBy7(int[] array) {
        int size = 0;
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 7 == 0) {
                size++;
            }
        }
        int[] numberArray = new int[size];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 7 == 0) {
                numberArray[idx] = array[i];
                idx++;
            }
        }
        return numberArray;
    }
}
