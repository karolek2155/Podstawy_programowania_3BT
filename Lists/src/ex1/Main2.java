package ex1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<Person> people = new LinkedList<>();

        people.add(new Person("Jan", "Nowak", 21));
        people.add(new Person("Kazimiera", "Sowa", 27));
        people.add(new Person("Marian", "Kowalski", 12));
        people.add(new Person("Zbigniew", "Chwałek", 24));
        people.add(new Person("Zuzanna", "Ciejka", 26));
        people.add(new Person("Maja", "Kurzastopa", 44));
        people.add(new Person("Anna", "Sowa", 27));

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.getSurname().compareTo(o2.getSurname());
                if (result == 0) return o1.getName().compareTo(o2.getName());
                return result;
            }
        });

        for (Person person : people) System.out.println(person);
        System.out.println("----------------------");

        CompareBySurnameThenByAge compareBySurnameThenByAge = new CompareBySurnameThenByAge();
        people.sort(compareBySurnameThenByAge);

        for (Person person : people) System.out.println(person);
        System.out.println("----------------------");

        CompareByAgeThenBySurnameThenByName compareByAgeThenBySurnameThenByName = new CompareByAgeThenBySurnameThenByName();
        people.sort(compareByAgeThenBySurnameThenByName);

        for (Person person : people) System.out.println(person);
        System.out.println("----------------------");
    }
}
