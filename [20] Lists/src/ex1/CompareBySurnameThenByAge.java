package ex1;

import java.util.Comparator;

public class CompareBySurnameThenByAge implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getSurname().compareTo(p2.getSurname());
        if (result == 0) return p1.getAge() - p2.getAge();
        return result;
    }
}
