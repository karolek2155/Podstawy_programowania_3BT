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
        System.out.println(changedAlphabet);

        String decryptedText = decryptText(phrase, alphabet, changedAlphabet);
        System.out.println("Odkodowany tekst to:\n" + decryptedText);

    }


    public static String getPhrase() {
        return scanner.nextLine();
    }

    public static int getKey() {
        return scanner.nextInt();
    }

    public static String createChangedAlphabet(String alphabet, int key) {
        String changedAlphabet = "";
        for (int i = 0; i < alphabet.length(); i++) {
            changedAlphabet = changedAlphabet.concat(String.valueOf(alphabet.charAt((i + key) % alphabet.length())));
        }
        return changedAlphabet;
    }

    public static String decryptText(String phrase, String changedAlphabet, String alphabet) {
        String decryptedText = "";
        for (int i = 0; i < phrase.length(); i++) {
            int placeChar = changedAlphabet.indexOf(phrase.charAt(i));
            decryptedText = decryptedText.concat(String.valueOf(alphabet.charAt(placeChar)));
        }
        return decryptedText;

    }
}
