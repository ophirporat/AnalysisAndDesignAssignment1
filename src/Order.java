import java.util.ArrayList;
import java.util.Date;

public class Order {
    enum OrderStatus{
        New, Hold, Shipped, Delivered, Closed
    }
    private String number;
    private Date ordered;
    private Date shipped;
    //Address
    private String ship_to;
    private OrderStatus status;
    private float total;

    // association with LineItem
    private ArrayList<LineItem> lineItems;
    // association with Payment
    private ArrayList<Payment> payments;
    // compositin with Account
    private Account account;


    public Order(String number, Date ordered, Date shipped, String ship_to, OrderStatus status, float total , Account account) {
        this.number = number;
        this.ordered = ordered;
        this.shipped = shipped;
        this.ship_to = ship_to;
        this.status = status;
        this.total = total;
        this.account=account;
        lineItems=new ArrayList<>();
        payments=new ArrayList<>();
    }

    public boolean AddLineItem(LineItem lineItem){
        assert lineItem!=null;
        return lineItems.add(lineItem);
    }


}
