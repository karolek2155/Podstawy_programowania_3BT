package pl.gornik.Decryption;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNPQRSTUVWXYZ";
        System.out.println("Podaj tekst do odszyfrowania:");
        String phrase = getPhrase();
        System.out.println("Podaj klucz szyfrowy:");
        int key = getKey();
        String changedAlphabet = createChangedAlphabet(alphabet, key);
        System.out.println("Zmieniony alfabet: " + changedAlphabet);

        String decryptedText = decryptText(phrase, alphabet, changedAlphabet);
        System.out.println("Odkodowany tekst to:\n" + decryptedText);

    }

    public static String getPhrase() {
        return scanner.nextLine().toUpperCase();
    }

    public static int getKey() {
        while (!scanner.hasNextInt()) {
            System.out.println("Podaj poprawny numer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String createChangedAlphabet(String alphabet, int key) {
        StringBuilder changedAlphabet = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            changedAlphabet.append(alphabet.charAt((i + key) % alphabet.length()));
        }
        return changedAlphabet.toString();
    }

    public static String decryptText(String phrase, String alphabet, String changedAlphabet) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            int placeChar = changedAlphabet.indexOf(phrase.charAt(i));
            if (placeChar != -1) {
                decryptedText.append(alphabet.charAt(placeChar));
            }
        }
        return decryptedText.toString();
    }
}
