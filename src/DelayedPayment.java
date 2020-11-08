import java.util.Date;

public class DelayedPayment extends Payment {
    private Date paymentDate;

    public DelayedPayment(float total, Account account, Order order) {
        super( total, account, order);
        this.paymentDate=null;
        this.paid=null;
    }
}
