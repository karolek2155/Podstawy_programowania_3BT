import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rozwiązywanie równania kwadratowego");
        System.out.println("Wpisz odpowiednio współczynniki a, b, c równania kwadratowego");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        calculateX(a, b, c);
    }

    public static void calculateX (double a, double b, double c) {
        double x1, x2;
        if (a != 0) {
            double delta = Math.pow(b, 2) - 4 * a * c;
            if (delta == 0) {
                x1 = -b / (2 * a);
                System.out.printf("Rozwiązaniem tego równania jest %.3f\n", x1);
            } else if (delta > 0) {
                if (b >= 0)
                    x1 = (-b - Math.sqrt(delta)) / (2 * a);
                else
                    x1 = (-b + Math.sqrt(delta)) / (2 * a);
                x2 = c / (a * x1);
                System.out.printf("Rozwiązaniami tego równania są %.3f i %.3f\n", x1, x2);
            } else
                System.out.println("To równanie nie ma rozwiązań");

        }
        else {
            System.out.printf("Jest to równanie liniowe");
            if (a == 0 && b == 0 && c == 0)
                System.out.println(", ma nieskończenie wiele rozwiązań");
            else if (b != 0) {
                x1 = -c / b;
                System.out.printf(", ma jedno rozwiązanie  %.3f\n", x1);
            }
            else
                System.out.println(" i jest sprzeczne");
        }
    }
}