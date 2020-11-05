import java.util.ArrayList;
import java.util.Date;

public class PremiumAccount extends Account {

    private ArrayList<Product> products;

    public PremiumAccount(String id, String billing_address, boolean is_closed, Date open, Date close, int balance, ArrayList<Order> orders, ShoppingCart shoppingCart, ArrayList<Payment> payments, Customer customer) {
        super(id, billing_address, is_closed, open, close, balance, orders, shoppingCart, payments, customer);
        products =new ArrayList<>();
    }

    public boolean AddProduct(Product product){return products.add(product);}

    public boolean AddProducts(ArrayList<Product> products){return this.products.addAll(products);}


}
