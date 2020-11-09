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

    public void AddProduct(Product product){
        if (product!=null && !products.contains(product))
            products.add(product);
    }

    public void DeleteProduct(Product product){
        if (products.contains(product))
            products.remove(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                '}';
    }
}
