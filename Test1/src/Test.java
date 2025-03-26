package Test.src;

import java.util.Scanner;

public class Test {

    public static Scanner scanner = new Scanner(System.in);
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static void main(String[] args) {

//        System.out.println("- OPERACJE NA TEKSCIE -");
//
//        System.out.println("Wpisz tekst");
//        String text = scanner.nextLine();
//
//        if (checkIsPalindrome(text)) System.out.println(text + " jest palindromem");
//        else System.out.println(text + " nie jest palindromem");
//
//        System.out.print("Odwrócony tekst to ");
//        System.out.print(reserveText(text));

        System.out.println("\n- SZYFROWANIE -");

        System.out.println("Podaj frazę do zaszyfrowania ");
        String phrase = getReducedPhrase();
        System.out.println("Zredukowana fraza " + phrase);

        System.out.println("\nSzyfr Cezara\n");

        System.out.println("Podaj klucz szyfrowy [liczba] ");
        int key = getIntKey();
        String caesarAlphabet = createCaesarAlphabet(key);
        System.out.println("Zmieniony alfabet " + caesarAlphabet);
        String encryptedCaesarPhrase = encryptPhrase(phrase, caesarAlphabet);
        System.out.println("Zakodowana fraza " + encryptedCaesarPhrase);
        String decryptedCaesarPhrase = decryptPhrase(encryptedCaesarPhrase, caesarAlphabet);
        System.out.println("Odkodowana fraza " + decryptedCaesarPhrase);

        System.out.println("\nSzyfr kluczowy\n");

        System.out.println("Podaj klucz szyfrowy [tekst] ");
        String keyWord = getStringKey();
        System.out.println(keyWord);
        String keywordAlphabet = createKeywordAlphabet(keyWord);
        System.out.println("Zmieniony alfabet " + keywordAlphabet);
        String encryptedKeywordPhrase = encryptPhrase(phrase, keywordAlphabet);
        System.out.println("Zakodowana fraza " + encryptedKeywordPhrase);
        String decryptedKeywordPhrase = decryptPhrase(encryptedKeywordPhrase, keywordAlphabet);
        System.out.println("Odkodowana fraza " + decryptedKeywordPhrase);

        System.out.println("\nSzyfr Vigenere\n");

        String encryptedVigenerePhrase = encryptPhraseUsingVigenere(phrase, keyWord);
        System.out.println("Zakodowana fraza " + encryptedVigenerePhrase);
        String decryptedVigenerePhrase = decryptPhraseUsingVigenere(encryptedVigenerePhrase, keyWord);
        System.out.println("Odkodowana fraza " + decryptedVigenerePhrase);
    }

//    OperacjeNaTekscie

    public static boolean checkIsPalindrome(String text) {
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String reserveText(String text) {
        String reservedText = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reservedText = reservedText.concat(String.valueOf(text.charAt(i)));
        }
        return reservedText;
    }


    public static String getReducedPhrase() {
        String phrase = scanner.nextLine().toUpperCase();
        phrase = phrase.replaceAll("[^" + alphabet +"]", "");
        return phrase;
    }

    //      SzyfrowanieJednoalfabetyczne

    public static int getIntKey() {
        while (! scanner.hasNextInt()) {
            System.out.println("Podaj poprawny numer");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String createCaesarAlphabet(int key) {
        String changedAlphabet = "";
        for (int i = 0; i < alphabet.length(); i++) {
            changedAlphabet = changedAlphabet.concat((String.valueOf(alphabet.charAt((i + key) % alphabet.length()))));
        }
        return changedAlphabet;
    }

    public static String getStringKey() {
        scanner.nextLine();
        String key = scanner.nextLine().toUpperCase();
        key = key.replaceAll("[^" + alphabet + "]", "");
        return key;
    }

    public static String createKeywordAlphabet(String key) {
        String changedAlphabet = key;
        for (int i = 0; i < alphabet.length(); i++) {
            if (!key.contains(String.valueOf(alphabet.charAt(i)))) {
                changedAlphabet = changedAlphabet.concat(String.valueOf(alphabet.charAt(i)));
            }
        }
        return changedAlphabet;
    }

    public static String encryptPhrase(String phrase, String changedAlphabet) {
        String encryptedPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            int placeChar = alphabet.indexOf(phrase.charAt(i));
            encryptedPhrase = encryptedPhrase.concat(String.valueOf(changedAlphabet.charAt(placeChar)));
        }
        return encryptedPhrase;
    }

    public static String decryptPhrase(String phrase, String changedAlphabet) {
        String decryptedPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            int placeChar = changedAlphabet.indexOf(phrase.charAt(i));
            decryptedPhrase = decryptedPhrase.concat(String.valueOf(alphabet.charAt(placeChar)));
        }
        return decryptedPhrase;
    }

    //      SzyfrowanieWieloalfabetyczne

    public static String encryptPhraseUsingVigenere(String phrase, String key) {
        int alphabetLen = alphabet.length();
        int phraseLen = phrase.length();
        int keyLen = key.length();
        int nrKey = 0;
        char enryptChar;
        String encryptedText = "";
        for (int i = 0; i < phraseLen; i++) {
            nrKey = alphabet.indexOf(key.charAt(i % keyLen));
            enryptChar = alphabet.charAt((alphabet.indexOf(phrase.charAt(i)) + nrKey) % alphabetLen);
            encryptedText = encryptedText.concat(String.valueOf(enryptChar));
        }
        return encryptedText;
    }

    public static String decryptPhraseUsingVigenere(String phrase, String key) {
        int alphabetLen = alphabet.length();
        int phraseLen = phrase.length();
        int keyLen = key.length();
        int nrKey = 0;
        char deryptChar;
        String decryptedText = "";
        for (int i = 0; i < phraseLen; i++) {
            nrKey = alphabet.indexOf(key.charAt(i % keyLen));
            deryptChar = alphabet.charAt((alphabet.indexOf(phrase.charAt(i)) - nrKey + alphabetLen) % alphabetLen);
            decryptedText = decryptedText.concat(String.valueOf(deryptChar));
        }
        return decryptedText;
    }
}
