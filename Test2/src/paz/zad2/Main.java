package paz.zad2;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNOPUQRSTWXYZ1234567890";
        String phrase = getReducedPhrase(alphabet);
        System.out.println("Zredukowana fraza: " + phrase);
        int key = 11;
        String changedAlphabet = createChangedAlphabet(alphabet, key);
        System.out.println("Początkowy alfabet: " + alphabet);
        System.out.println("Zmieniony alfabet:  " + changedAlphabet);
        String encryptedPhrase = encryptPrase(phrase, changedAlphabet, alphabet);
        System.out.println("Zakodowana fraza:  " + encryptedPhrase);

    }

    public static String getReducedPhrase(String alphabet) {
        System.out.println("Podaj frazę do zakodowania");
        String phrase = scanner.nextLine().toUpperCase();
        phrase = phrase.replaceAll("[^" + alphabet + "]", "");
        return phrase;
    }

    public static int getKey() {
        System.out.println("Podaj klucz");
        while (!scanner.hasNext()) {
            System.out.println("Podaj poprawny numer");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String createChangedAlphabet(String alphabet, int key) {
        String chanegedAlphabet = "";
        for (int i = 0; i < alphabet.length(); i++) {
            chanegedAlphabet = chanegedAlphabet.concat(String.valueOf(alphabet.charAt((i + key) % alphabet.length())));
        }
        return chanegedAlphabet;
    }

    public static String encryptPrase(String phrase, String changedAlphabet, String alphabet) {
        String encryptedPrase = "";
        int placeChar;
        for (int i = 0; i < phrase.length(); i++) {
            placeChar = alphabet.indexOf(phrase.charAt(i));
            encryptedPrase = encryptedPrase.concat(String.valueOf(changedAlphabet.charAt(placeChar)));
        }
        return encryptedPrase;
    }


}
