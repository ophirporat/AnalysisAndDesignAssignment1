import java.util.ArrayList;

public class Supplier {
    private String id;
    private String name;
    // association with Product
    private ArrayList<Product> products;

    public Supplier(String id, String name) {
        this.id = id;
        this.name = name;
        products = new ArrayList<>();
    }

    public boolean AddProduct(Product product){
        assert (product!=null);
        if (product.HasSupplier() || products.contains(product)) return false;
        return products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
