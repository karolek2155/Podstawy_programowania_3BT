import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {

        System.out.println("Podaj tekst do zaszyfrowania: ");
        String phrase = getReducedPhrase();

        System.out.println("Podaj klucz: ");
        String keyword = getReducedKeyword();

        System.out.println("Zaszyfrowany tekst: ");
        String encryptedPhrase = encryptPhrase(phrase, keyword);
        System.out.println(encryptedPhrase);
    }

    public static String getReducedPhrase(){
        String text = scanner.nextLine().toUpperCase();
        String reducedText = "";
        for(int i = 0; i<text.length(); i++){
            if(alphabet.contains(String.valueOf(text.charAt(i)))){
                reducedText = reducedText.concat(String.valueOf(text.charAt(i)));
            }
        }
        return reducedText;
    }

    public static String getReducedKeyword(){
        String keyword = scanner.nextLine().toUpperCase();
        String reducedKeyword = "";
        for(int i = 0; i<keyword.length(); i++){
            if(!reducedKeyword.contains(String.valueOf(keyword.charAt(i)))&&
                    alphabet.contains(String.valueOf(keyword.charAt(i)))){
                reducedKeyword = reducedKeyword.concat(String.valueOf(keyword.charAt(i)));
            }
        }
        return reducedKeyword;
    }

    public static String encryptPhrase(String phrase, String key){
        int alfLen = alphabet.length();
        int phraseLen = phrase.length();
        int keyLen = key.length();
        String encryptedPhrase = "";
        int nrKey = 0;
        char encryptChar;
        for(int i = 0; i<phraseLen; i++){
            nrKey = alphabet.indexOf(key.charAt(i % keyLen));
            encryptChar = alphabet.charAt((alphabet.indexOf(phrase.charAt(i)) + nrKey) % alfLen);
            encryptedPhrase = encryptedPhrase.concat(String.valueOf(encryptChar));
        }
        return encryptedPhrase;
    }
}