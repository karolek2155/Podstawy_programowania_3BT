package ex1;

import java.util.Comparator;

public class CompareByAgeThenBySurnameThenByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getAge() - p2.getAge();
        if (result == 0) result = p1.getSurname().compareTo(p2.getSurname());
        if (result == 0) result = p1.getName().compareTo(p2.getName());
        return result;
    }
}
