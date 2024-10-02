public class Main1 {

    public static void main(String[] args) {

        int[][] numbers = new int[4][];
        numbers[0] = new int[]{2, 5, 3};
        numbers[1] = new int[]{};
        numbers[2] = new int[]{3, 2};
        numbers[3] = new int[]{2, 4, 3, 6};

        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length; j++){
                System.out.print(numbers[i][j] + ", ");
            }
            System.out.println("\n");
        }
    }
}
