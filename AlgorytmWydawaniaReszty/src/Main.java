import java.util.Scanner;

public class Main {
    static int[] money = {50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algorytm wydawania reszty");
        System.out.println("Podaj kwotę za zakupy");
        double amountToPaid = scanner.nextDouble();
        System.out.println("Podaj ile zapłacisz");
        double amountPaid = scanner.nextDouble();
        int rest = (int) ((amountPaid - amountToPaid) * 100);

        int[] amountOfRest = spentTheRest(rest);

        System.out.println("Wydana reszta");
        for (int i = 0; i < money.length; i++) {
            if (amountOfRest[i] != 0) {
                if (money[i] % 100 == 0)
                    System.out.printf("%d szt o nominale %d zł \n", amountOfRest[i], money[i]/100);
                else
                    System.out.printf("%d szt o nominale %d gr \n", amountOfRest[i], money[i]);
            }
        }

    }

    public static int[] spentTheRest(int theRest) {
        int[] amountOfMoney = new int[money.length];
        for (int i = 0; i < money.length; i++) {
            amountOfMoney[i] = theRest / money[i];
            theRest -= amountOfMoney[i] * money[i];
        }
        return amountOfMoney;
    }
}