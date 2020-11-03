public class LineItem {
    private int quantity;
    private int price;
    // association with Product
    private Product product;
    // association with Order
    private Order order;
    // association with ShoppingCart
    private ShoppingCart shoppingCart;

    //constructor

    public LineItem(int quantity, int price, Product product, Order order, ShoppingCart shoppingCart) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.order = order;
        this.shoppingCart = shoppingCart;
    }


}
