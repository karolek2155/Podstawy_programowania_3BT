package ex1;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Tarnobrzeg");
        cities.add("Sandomierz");
        cities.add("Stalowa Wola");
        cities.add("Warszawa");
        cities.add("Gdańsk");
        cities.add("Kraków");

        for (String city : cities) System.out.println(city);
        System.out.println("----------------------");

        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
        System.out.println("----------------------");

//        for (String city : cities) {
//            if (city.equalsIgnoreCase("Kraków")) cities.remove(city); // nie zadziała
//        }

        Iterator<String> stringIterator = cities.iterator();
        while (stringIterator.hasNext()) {
            String city = stringIterator.next();
            if (city.equalsIgnoreCase("Kraków")) stringIterator.remove();
        }
        for (String city : cities) System.out.println(city);
        System.out.println("----------------------");

        cities.sort(Comparator.naturalOrder());
        for (String city : cities) System.out.println(city);
        System.out.println("----------------------");

//        Collections.sort(cities); // 2 sposób bez użycia comparatora

        cities.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String city : cities) System.out.println(city);
        System.out.println("----------------------");

    }
}
