import java.util.Map;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) {
        Map<String, String> addresses = new TreeMap<>();
        addresses.put("12345", "Kwiatowa 5");
        addresses.put("23760", "Łąkowa 12");
        addresses.put("23498", "Brzozowa 23");
        addresses.put("19065", "Jarzębionowa 1");
        addresses.put("87021", "Konwaliowa 14");
        addresses.put("89416", "Jabłoniowa 7");

        for (Map.Entry<String, String> address : addresses.entrySet())
            System.out.println(address.getKey() + " - " + address.getValue());

        removeAdress(addresses, "Jabłoniowa 7");
    }

    public static void removeAdress(Map<String, String> addresses, String addressToFind) {
        String key = null;
        for (Map.Entry<String, String> address : addresses.entrySet()) {
            if (address.getValue().equalsIgnoreCase(addressToFind)) {
                System.out.println("Znaleziono adres " + addressToFind + " dla peselu " + address.getKey());
                key = address.getKey();
            }
        }
        addresses.remove(key);
        if (key != null){
            System.out.println("Usnunieto adres " + addressToFind + " dla peselu " + key);
            return;
        }
        System.out.println("Nie znaleziono adresu " + addressToFind);
    }
}
