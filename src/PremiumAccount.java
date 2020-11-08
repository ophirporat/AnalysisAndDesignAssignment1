import java.util.ArrayList;
import java.util.Date;

public class PremiumAccount extends Account {

    private ArrayList<Product> products;

    public PremiumAccount(String id, String billing_address, ShoppingCart shoppingCart,int balance) {
        super(id, billing_address, shoppingCart,balance);
        products =new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean AddProduct(Product product){
        product.AddPremiumAccount(this);
        return products.add(product);}



    public boolean RemoveProduct(Product product){
        if (products.contains(product)){
            products.remove(product);
//            product.RemovePremiumAccount(); //TODO: check: if only premium can delete- not good! if everyone can- good!
            return true;
        }
        return false;
    }


}
