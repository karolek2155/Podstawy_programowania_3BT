package pl.gornik.Encryption;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNPQRSTUVWXYZ";
        System.out.println("Podaj tekst do zaszyfrowania:");
        String phrase = getReducedPhrase(alphabet);
        System.out.println(phrase);
        System.out.println("Podaj klucz szyfrowy:");
        int key = getKey();
        String changedAlphabet = createChangedAlphabet(alphabet, key);
        System.out.println(changedAlphabet);

        String encryptedText = encryptText(phrase, alphabet, changedAlphabet);
        System.out.println("Zakodowany tekst to:\n" + encryptedText);

    }

    public static String getReducedPhrase(String alphabet) {
        String phrase = scanner.nextLine().toUpperCase();
        String reducedPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (alphabet.contains(String.valueOf(phrase.charAt(i))))
                reducedPhrase = reducedPhrase.concat(String.valueOf(phrase.charAt(i)));
        }
        return reducedPhrase;
    }

    public static int getKey() {
        while (!scanner.hasNextInt()) {
            System.out.println("Podaj poprawny numer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String createChangedAlphabet(String alphabet, int key) {
        String changedAlphabet = "";
        for (int i = 0; i < alphabet.length(); i++) {
            changedAlphabet = changedAlphabet.concat(String.valueOf(alphabet.charAt((i + key) % alphabet.length())));
        }
        return changedAlphabet;
    }

    public static String encryptText(String phrase, String alphabet, String changedAlphabet) {
        String encryptedText = "";
        for (int i = 0; i < phrase.length(); i++) {
            int placeChar = alphabet.indexOf(phrase.charAt(i));
            encryptedText = encryptedText.concat(String.valueOf(changedAlphabet.charAt(placeChar)));
        }
        return encryptedText;
    }
}