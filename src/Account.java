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

    public Account(String id, String billing_address , ShoppingCart shoppingCart, int balance) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = false;
        this.open = new Date();
        this.close = null;
        this.balance = balance;
        this.orders = new ArrayList<>();
        this.shoppingCart = shoppingCart;
        shoppingCart.setAccount(this);
        this.payments = new ArrayList<>();
    }

    @Override
    public String toString() {
        String orderList = "";
        for (Order order : orders) { //print all products in the supplier's product list
            orderList += order.getNumber() + ", ";
        }
        String paymentList = "";
        for (Payment payment : payments) { //print all products in the supplier's product list
            paymentList += "(order id: " + payment.getId() + "toatl: " + payment.getTotal() + "), ";
        }
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", orders=" + orderList +
                ", shoppingCart=" + shoppingCart +
                ", payments=" + paymentList +
                ", customer=" + customer.getId() +
                '}';
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrSubBalance(int balance) {
        this.balance = this.balance+balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public Order getLastOrder()
    {
        if (orders.isEmpty()) return null;
        return orders.get(orders.size()-1);
    }

    public String getBilling_address() {
        return billing_address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }


    public boolean AddPayment(Payment payment){return payments.add(payment);}

    public boolean AddPayments(ArrayList<Payment> payments){return payments.addAll(payments);}

    public void AddOrder(Order order){
        orders.add(order);
        order.setAccount(this);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
}
