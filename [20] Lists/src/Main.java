import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        int size = 10000;

        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add((int) (Math.random() * size));
        }
        long end = System.nanoTime();
        System.out.println("ArrayList - add(): " + (end - start));
        System.out.println("------------------------------------");

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add((int) (Math.random() * size));
        }
        end = System.nanoTime();
        System.out.println("LinkedList - add(): " + (end - start));
        System.out.println("------------------------------------");

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.get((int) (Math.random() * size));
        }
        end = System.nanoTime();
        System.out.println("ArrayList - get(): " + (end - start));
        System.out.println("------------------------------------");

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.get((int) (Math.random() * size));
        }
        end = System.nanoTime();
        System.out.println("LinkedList - get(): " + (end - start));
        System.out.println("------------------------------------");
    }
}
