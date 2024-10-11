import java.util.Scanner;

public class Decryption {

    static Scanner scanner = new Scanner(System.in);
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {

        System.out.println("Podaj tekst do odszyfrowania: ");
        String phrase = getReducedPhrase();

        System.out.println("Podaj klucz: ");
        String keyword = getReducedKeyword();

        System.out.println("Odszyfrowany tekst: ");
        String decryptedPhrase = decryptPhrase(phrase, keyword);
        System.out.println(decryptedPhrase);
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

    public static String decryptPhrase(String phrase, String key){
        int alfLen = alphabet.length();
        int phraseLen = phrase.length();
        int keyLen = key.length();
        String decryptedPhrase = "";
        int nrKey = 0;
        char decryptChar;
        for(int i = 0; i < phraseLen; i++){
            nrKey = alphabet.indexOf(key.charAt(i % keyLen));
            decryptChar = alphabet.charAt((alphabet.indexOf(phrase.charAt(i)) - nrKey + alfLen) % alfLen);
            decryptedPhrase = decryptedPhrase.concat(String.valueOf(decryptChar));
        }
        return decryptedPhrase;
    }
}