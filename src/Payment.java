import java.util.Date;

public abstract class Payment {
    private String id;
    private Date paid;
    private float total;
    private String details;
    private Account account;
    private Order order;

    public Payment(String id, Date paid, float total, String details, Account account,Order order) {
        this.id = id;
        this.paid = paid;
        this.total = total;
        this.details = details;
        this.account = account;
        this.order = order;
    }
}
