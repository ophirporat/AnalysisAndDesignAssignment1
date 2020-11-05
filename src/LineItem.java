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

    public LineItem(int quantity,Product product) {
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
}
