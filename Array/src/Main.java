public class Main {
    public static void main(String[] args) {

        int[] array = new int[10];

        int sum = 0;
        int min = array[0];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
//            System.out.println(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
             if (array[i] < min) {
                min = array[i];
                index = i;
            }

        }

        System.out.println("Srednia liczb z tej tablicy wynosi: " + sum/ array.length);
        System.out.println("najmniejsza wartosc tej tablicy wynosi " + min + " na pozycji " + index);


    }
}