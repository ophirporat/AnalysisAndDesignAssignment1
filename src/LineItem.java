import java.util.Random;

public class LineItem {
    private int quantity;
    private int price;
    // association with Product
    private Product product;
    // association with Order
    private Order order;
    // association with ShoppingCart
    private ShoppingCart shoppingCart;
    private static Random random= new Random();

    //constructor

    public LineItem(int quantity, Product product, Order order, ShoppingCart shoppingCart) {

        this.quantity = quantity;
        this.price = random.nextInt(50);
        this.product = product;
        this.order = order;
        this.shoppingCart = shoppingCart;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void RemoveFromWorld() {
        if (shoppingCart!=null) {
            shoppingCart.RemoveLineItem(this);
            shoppingCart = null;
        }
        if (order!=null) {
            order.RemoveLineItem(this);
            order=null;
        }
        if (product!=null) {
            product.RemoveLineItem(this);
            product = null;
        }
    }
}
