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

    @Override
    public String toString() {
        String lineItemList = "";
        for (LineItem item : lineItems) { //print all products in the supplier's product list
            lineItemList += "produduct name: " + item.getProduct().getName() + "price: " + item.getPrice() + "quantity: " + item.getQuantity() + "), ";
        }
        String paymentList = "";
        for (Payment payment : payments) { //print all products in the supplier's product list
            paymentList += "(order id: " + payment.getId() + "toatl: " + payment.getTotal() + "), ";
        }
        return "Order{" +
                "number='" + number + '\'' +
                ", ship_to='" + ship_to + '\'' +
                ", total=" + total +
                ", lineItems=" + lineItemList +
                ", payments=" + paymentList +
                ", account=" + account +
                '}';
    }

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

}
