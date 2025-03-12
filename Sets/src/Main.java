import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(0, 2, 1, 6, 1, 5));
        Set<Integer> linkedSet = new LinkedHashSet<>(Arrays.asList(0, 2, 1, 6, 1, 5));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(0, 2, 1, 6, 1, 5));

        System.out.println("\nHashSet");
        for(int number : hashSet) System.out.print(number + ", ");
        System.out.println("\nLinkedSet");
        for(int number : linkedSet) System.out.print(number + ", ");
        System.out.println("\nTreeSet");
        for(int number : treeSet) System.out.print(number + ", ");
        System.out.println("\nUsuwanie obiektu z setu");

        Iterator<Integer> iterator = linkedSet.iterator();
        while (iterator.hasNext()){
            Integer number = iterator.next();
            if(number==5) iterator.remove();
        }
        System.out.println("\nLinkedHashSet");
        for(int number : linkedSet) System.out.print(number + ", ");

        System.out.println("\n------------------------");
        Set<String> words = new TreeSet<>();
        words.add("laptop");
        words.add("mysz");
        words.add("klawiatura");
        words.add("monitor");
        words.add("pendrive");
        words.add("telewizor");
        words.add("komputer");
        for (String word : words) System.out.println(word + ", ");

        System.out.println("\n------------------------");
        Set<Integer> setA = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        Set<Integer> sumAB = new HashSet<>(setA);
        sumAB.addAll(setB);

        Set<Integer> commonAB = new HashSet<>(setA);
        commonAB.retainAll(setB);

        Set<Integer> differenceAB = new HashSet<>(setA);
        differenceAB.removeAll(setB);

        Set<Integer> differenceBA = new HashSet<>(setB);
        differenceBA.removeAll(setA);

        System.out.println("Zbiór A " + setA);
        System.out.println("Zbiór B " + setB);
        System.out.println();

        System.out.println("Suma zbiorów A i B " + sumAB);
        System.out.println("Iloczyn zbiorów A i B " + commonAB);
        System.out.println("Rożnica zbiorów A i B " + differenceAB);
        System.out.println("Rożnica zbiorów B i A " + differenceBA);

        System.out.println("------------------------");
        List<Character> letters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'b', 'e', 'd');

    }
}