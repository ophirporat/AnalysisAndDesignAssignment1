import java.util.ArrayList;
import java.util.Date;

public class PremiumAccount extends Account {

    private ArrayList<Product> products;

    public PremiumAccount(String id, String billing_address, ShoppingCart shoppingCart) {
        super(id, billing_address, shoppingCart);
        products =new ArrayList<>();
    }

    public boolean AddProduct(Product product){return products.add(product);}

    public boolean AddProducts(ArrayList<Product> products){return this.products.addAll(products);}


}
