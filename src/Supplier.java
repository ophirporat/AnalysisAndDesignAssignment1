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

    public String getName() { return name; }

    @Override
    public String toString() {
        String pro = "";
        for (Product product : products) { //print all products in the supplier's product list
            pro += product.getName() + ", ";
        }
        return "Supplier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", products=" + pro +
                '}';
    }
}
