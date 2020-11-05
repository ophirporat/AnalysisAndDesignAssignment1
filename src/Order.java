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


    public Order(String ship_to, Account account) {
        this.number = getNum();
        this.ordered = new Date();
        this.shipped = new Date(); //TODO: date
        this.ship_to = ship_to;
        this.status = OrderStatus.New;
        this.total = 0;
        this.account=account;
        lineItems=new ArrayList<>();
        payments=new ArrayList<>();
    }

    public static String getNum() {
        counter++;
        return String.valueOf(counter);
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
        assert lineItem!=null;
        lineItems.add(lineItem);
        total+=(lineItem.getPrice()*lineItem.getQuantity());
    }


}
