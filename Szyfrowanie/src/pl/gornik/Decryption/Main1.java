package pl.gornik.Decryption;

import java.util.Scanner;

public class Main1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Podaj tekst do odszyfrowania:");
        String encryptedText = getPhrase();
        System.out.println("Podaj klucz szyfrowy:");
        String key = getKey(alphabet);
        String changedAlphabet = createChangedAlphabet(alphabet, key);
        System.out.println("Zmodyfikowany alfabet: " + changedAlphabet);

        String decryptedText = decryptText(encryptedText, alphabet, changedAlphabet);
        System.out.println("Odszyfrowany tekst to:\n" + decryptedText);
    }

    public static String getPhrase() {
        return scanner.nextLine().toUpperCase();
    }

    public static String getKey(String alphabet) {
        String key = scanner.nextLine().toUpperCase();
        key = key.replaceAll("[^" + alphabet + "]", "");
        StringBuilder uniqueKey = new StringBuilder();

        for (char c : key.toCharArray()) {
            if (uniqueKey.indexOf(String.valueOf(c)) == -1) {
                uniqueKey.append(c);
            }
        }
        return uniqueKey.toString();
    }

    public static String createChangedAlphabet(String alphabet, String key) {
        StringBuilder changedAlphabet = new StringBuilder(key);

        for (int i = 0; i < alphabet.length(); i++) {
            if (changedAlphabet.indexOf(String.valueOf(alphabet.charAt(i))) == -1) {
                changedAlphabet.append(alphabet.charAt(i));
            }
        }
        return changedAlphabet.toString();
    }

    public static String decryptText(String encryptedText, String alphabet, String changedAlphabet) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            int placeChar = changedAlphabet.indexOf(encryptedText.charAt(i));
            if (placeChar != -1) {
                decryptedText.append(alphabet.charAt(placeChar));
            }
        }
        return decryptedText.toString();
    }
}
