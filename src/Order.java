import java.util.ArrayList;
import java.util.Date;

public class Order {

    private static int counter=0;

    enum OrderStatus{
        New, Hold, Shipped, Delivered, Closed
    }

    private String number;
    private Date ordered;
    private Date shipped;
    private String ship_to;  //Address
    private OrderStatus status;
    private float total;
    private ArrayList<LineItem> lineItems;  // association with LineItem
    private ArrayList<Payment> payments;    // association with Payment
    private Account account;   // composition with Account

    public Order(Account account) {
        this.number = getNum();
        this.ordered = new Date();
        this.shipped = new Date();
        this.ship_to = account.getBilling_address();
        this.status = OrderStatus.New;
        this.total = 0;
        this.account=account;
        lineItems=new ArrayList<>();
        payments=new ArrayList<>();
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public void addPayment(Payment payment){
        payments.add(payment);
    }

    public String getNumber() {
        return number;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static String getNum() {
        counter++;
        return String.valueOf(counter);
    }

    public void setShip_to(String ship_to) {
        this.ship_to = ship_to;
    }

    public boolean RemoveLineItem(LineItem lineItem) {
        if (lineItems.contains(lineItem)){
            lineItems.remove(lineItem);
            total-=lineItem.getPrice()*lineItem.getQuantity();
            lineItem.RemoveFromWorld();
            return true;
        }
        return false;
    }

    public void AddLineItem(LineItem lineItem){
        lineItems.add(lineItem);
        total+=(lineItem.getPrice()*lineItem.getQuantity());
    }

    @Override
    public String toString() {
        return "Order{" +
                " OrderNumber=" + number +
                ",\n ship to=" + ship_to +
                ",\n status=" + status +
                ",\n total=" + total +
                ",\n account=" + account.getId() +
                " }";
    }
}
