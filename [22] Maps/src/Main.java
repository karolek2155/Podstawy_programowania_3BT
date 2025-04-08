import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> cities = new HashMap<>();
        cities.put(2, "Kraków");
        cities.put(1, "Warszawa");
        cities.put(5, "Wrocław");
        cities.put(7, "Szczecin");
        cities.put(9, "Gdańsk");
        cities.put(5, "Sandomierz");

        Set<Integer> keys = cities.keySet();
        for (int key : keys)
            System.out.println(key + " - " + cities.get(key));

        Collection<String> cityList = cities.values();
//        List<String> listCity = (List<String>) cities.values();
        for (String city : cityList) System.out.println(city);

        for (Map.Entry<Integer, String> city : cities.entrySet())
            System.out.println(city.getKey() + ": " + city.getValue());

        System.out.println("--------------------------------------");
        if (cities.containsKey(7)) {
            cities.put(7, "Tarnobrezg");
        }
    }
}
