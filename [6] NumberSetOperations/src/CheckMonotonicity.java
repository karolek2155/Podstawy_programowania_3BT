public class CheckMonotonicity {

    public static int index;

    public static void main(String[] args) {

        System.out.println("Sprawdzanie monotoniczności ciągu");

        int[] numbers = new int[] {67, 65, 45, 23, 5, 2, 1, -98};
        boolean isDecrasing = checkIsDecreasing(numbers);
        if (isDecrasing) System.out.println("Ciąg jest malejący");
        else System.out.println("Ciąg nie jest monotoniczny");
    }

    public static  boolean checkIsDecreasing(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] <= numbers[i + 1]) return false;
        }
        return true;
    }
}
