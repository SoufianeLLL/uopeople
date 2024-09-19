import com.ecommerce.Product;
import com.ecommerce.Customer;
import com.ecommerce.orders.Order;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create products
        Product product1 = new Product(1, "MacBook Pro M2 - 2024", 2869);
        Product product2 = new Product(2, "Swiss Tech Jacket", 249);
        Product product3 = new Product(3, "Iphone 16 Mini", 999.99);
        Product product4 = new Product(4, "Iphone 16 Pro Max", 1999.99);

        // Create a customer
        Customer customer = new Customer(75, "Alex");

        // Customer browsing and adding products to the cart
        customer.addProductToCart(product1);
        customer.addProductToCart(product2);
        customer.addProductToCart(product3);
        
        // Calculate total for the shopping cart
        System.out.println("Total cost: $" + customer.calculateTotal() + " USD");

        // Customer places an order
        Order order = new Order(1001, customer, customer.getShoppingCart());
        order.orderSummary();
    }
}
