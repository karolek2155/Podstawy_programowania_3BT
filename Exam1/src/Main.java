import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pesel");
        String pesel = scanner.nextLine();

        if (isCorrect(pesel)) {
            if (checkControlSum(pesel)) {
                System.out.println("Suma kontrolna peselu zgadza się");
                char sex = checkSex(pesel);
                if (sex == 'K') System.out.println("Kobieta");
                else System.out.println("Mężczyzna");
            } else System.out.println("Suma kontrolna peselu nie zgadza się");
        } else System.out.println("Pesel jest nie poprawny, zawiera litery bądź nie ma 11 znaków");

    }

    public static char checkSex(String pesel) {
//        if (Integer.parseInt(String.valueOf(pesel.charAt(9))) % 2 == 0) return 'K';
        if (((int) pesel.charAt(9) - 48) % 2 == 0) return 'K';
        else return 'M';
    }

    /*
    ***************************************************************************************************
    nazwa funkcji: checkControlSum
    opis funkcji: funkcja sprawdza czy suma kontrolna peselu jest zgodna z 11 znakiem peselu
    parametry: pesel typu łańcuchowego przechowujący nr pesel
    zwracany typ i opis: funkcja zwraca true/false (typ boolean) oblicz na podstawie algorytmu wartość sumy kontrolnej
    autor: 55030101193
    ***************************************************************************************************
     */
    public static boolean checkControlSum(String pesel) {
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int S = 0;
        for (int i = 0; i < weights.length; i++) {
            S += Integer.parseInt(String.valueOf(pesel.charAt(i))) * weights[i];
        }
        int M = S % 10;
        int R = 0;
        if (M != 0) R = 10 - M;
        if (Integer.parseInt(String.valueOf(pesel.charAt(10))) == R) return true;
        else return false;
    }

    private static boolean isCorrect(String pesel) {
        if (pesel.length() == 11) {
            for (int i = 0; i < pesel.length(); i++) {
                if (!Character.isDigit(pesel.charAt(i))) return false;
            }
            return true;
        }
        return false;
    }
}