public class Iteration1 {
    public static void main(String[] args) {

        int[] array = new int[10];

        int sum = 0;
        int index = 0;

        System.out.println("Wartości tablicy: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
            System.out.print(array[i] + ", ");
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
             if (array[i] < min) {
                min = array[i];
                index = i;
            }

        }

        System.out.println("\nSuma liczb z tej tablicy wynosi: " + sum);
        System.out.println("Srednia liczb z tej tablicy wynosi: " + (double) sum/ array.length);
        System.out.println("Najmniejsza wartosc tej tablicy wynosi " + min + " na pozycji " + index);


    }
}