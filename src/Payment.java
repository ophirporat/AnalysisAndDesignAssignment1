import java.util.Date;

public abstract class Payment {
    private String id;
    protected Date paid;
    private float total;
    private String details;
    private Account account;
    private Order order;
    private static int orderId=0;

    public static int getOrderId(){
        orderId++;
        return orderId;
    }
    public Payment(float total, Account account,Order order) {
        this.id = String.valueOf(getOrderId());
        this.total = total;
        this.details = "hey";
        this.account = account;
        account.addPayment(this);
        this.order = order;
        order.addPayment(this);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", total=" + total +
                ", account=" + account.getId() +
                '}';
    }
}
