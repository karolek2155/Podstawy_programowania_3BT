package pl.gornik.Encryption;

import java.util.Scanner;

public class Main1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Podaj tekst do zaszyfrowania:");
        String phrase = getReducedPhrase(alphabet);
        System.out.println("Tekst do zaszyfrowania: " + phrase);
        System.out.println("Podaj klucz szyfrowy:");
        String key = getKey(alphabet);
        String changedAlphabet = createChangedAlphabet(alphabet, key);
        System.out.println("Zmodyfikowany alfabet: " + changedAlphabet);

        String encryptedText = encryptText(phrase, alphabet, changedAlphabet);
        System.out.println("Zakodowany tekst to:\n" + encryptedText);
    }

    public static String getReducedPhrase(String alphabet) {
        String phrase = scanner.nextLine().toUpperCase();
        StringBuilder reducedPhrase = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (alphabet.contains(String.valueOf(phrase.charAt(i)))) {
                reducedPhrase.append(phrase.charAt(i));
            }
        }
        return reducedPhrase.toString();
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

    public static String encryptText(String phrase, String alphabet, String changedAlphabet) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            int placeChar = alphabet.indexOf(phrase.charAt(i));
            if (placeChar != -1) {
                encryptedText.append(changedAlphabet.charAt(placeChar));
            }
        }
        return encryptedText.toString();
    }
}
