import java.util.Random;

public class LineItem {
    private int quantity;
    private int price;
    private Product product; // association with Product
    private Order order;     // association with Order
    private ShoppingCart shoppingCart;    // association with ShoppingCart
    private static Random random= new Random();

    //constructor
    public LineItem(int quantity, Product product) {
        this.quantity = quantity;
        this.price = product.getPrice();
        this.product=product;
    }

    public void SetOrder(Order order){
        this.order=order;
        order.AddLineItem(this);
    }

    public void SetShoppingCart(ShoppingCart shoppingCart){
        this.shoppingCart=shoppingCart;
        shoppingCart.AddLineItem(this);
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

    @Override
    public String toString() {
        return "LineItem{" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
