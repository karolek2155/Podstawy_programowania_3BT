import java.util.Scanner;

public class Main {
    static char[] lowerCaseAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static char[] upperCaseAlphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '*'};
    static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Generowanie hasła");
        System.out.println("Z ilu cyfr ma się składać hasło? 5-12 znaków");
        int length = scanner.nextInt();
        scanner.nextLine();
        boolean hasCapitalLetters = false;
        boolean hasSpecialCharacters = false;
        boolean hasDigits = false;

        System.out.println("Czy chcesz duże litery w haśle? tak/nie");
        if (scanner.nextLine().equalsIgnoreCase("tak")) hasCapitalLetters = true;
        System.out.println("Czy chcesz znaki specjalne w haśle? tak/nie");
        if (scanner.nextLine().equalsIgnoreCase("tak")) hasSpecialCharacters = true;
        System.out.println("Czy chcesz cyfry w haśle? tak/nie");
        if (scanner.nextLine().equalsIgnoreCase("tak")) hasDigits = true;

        String password = generatePassword(length, hasCapitalLetters, hasSpecialCharacters, hasDigits);
        System.out.println("Wygenerowane hasło: " + password);
    }


    public static String generatePassword(int length, boolean hasCapitalLetters, boolean hasSpecialCharacters, boolean hasDigits) {
        String password = "";
        String chars = "";
        int index;

        for (char c : lowerCaseAlphabet) chars += c;
        if (hasCapitalLetters) for (char c : upperCaseAlphabet) chars += c;
        if (hasSpecialCharacters) for (char c : specialCharacters) chars += c;
        if (hasDigits) for (char c : digits) chars += c;

        for (int i = 0; i < length; i++) {
            index = (int) (Math.random() * chars.length());
            password += String.valueOf(chars.charAt(index));
        }
        if (hasCapitalLetters) {
            index = (int) (Math.random() * upperCaseAlphabet.length);
            password.replace(password.charAt(1), upperCaseAlphabet[index]);
        }
        if (hasSpecialCharacters) {
            index = (int) (Math.random() * specialCharacters.length);
            password.replace(password.charAt(4), specialCharacters[index]);
        }
        if (hasDigits) {
            index = (int) (Math.random() * digits.length);
            password.replace(password.charAt(0), digits[index]);
        }

        return password;
    }
}
