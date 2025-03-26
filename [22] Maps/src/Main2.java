import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Map<Product, Boolean> products = new HashMap<>();
        products.put(new Product("laptop", 3500), true);
        products.put(new Product("monitor", 200), false);
        products.put(new Product("klawiatura", 140), false);
        products.put(new Product("mysz", 70), true);
        products.put(new Product("monitor", 800), true);
        products.put(new Product("drukarka", 350), false);

        System.out.println("Produkty sprawne");
        for (Map.Entry<Product, Boolean> product : products.entrySet()) {
            if (product.getValue()) System.out.println(product.getKey());
        }
    }
}
