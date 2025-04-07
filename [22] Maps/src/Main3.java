import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    static Map<String, List<Integer>> subjects = new HashMap<>();

    public static void main(String[] args) {
        addSubject("matematyka", 5);
        addSubject("fizyka", 4);
        addSubject("polski", 5);
        addSubject("matematyka", 5);
        addSubject("polski", 5);
        addSubject("matematyka", 6);
        addSubject("matematyka", 2);
        addSubject("matematyka", 3);

        for (Map.Entry<String, List<Integer>> subject : subjects.entrySet())
            System.out.println(subject.getKey() + ": " + subject.getValue());
    }

    private static void addSubject(String subject, int grade) {
        List<Integer> grades;
        if (subjects.containsKey(subject)) {
            grades = subjects.get(subject);
        } else {
            grades = new ArrayList<>();
        }
        grades.add(grade);
        subjects.put(subject, grades);
    }
}