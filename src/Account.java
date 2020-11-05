import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String id;
    private String billing_address;
    private boolean is_closed;
    private Date open;
    private Date close;
    private int balance;
    private ArrayList<Order> orders;
    private ShoppingCart shoppingCart;
    private ArrayList<Payment> payments;
    private Customer customer;

    public Account(String id, String billing_address , ShoppingCart shoppingCart) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = false;
        this.open = new Date();
        this.close = null;
        this.balance = 0;
        this.orders = new ArrayList<>();
        this.shoppingCart = shoppingCart;
        this.payments = new ArrayList<>();

    }

    public String getBilling_address() {
        return billing_address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }


    public boolean AddPayment(Payment payment){return payments.add(payment);}

    public boolean AddPayments(ArrayList<Payment> payments){return payments.addAll(payments);}

    public boolean AddOrder(Order order){return orders.add(order);}

}
