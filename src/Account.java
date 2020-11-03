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

}
