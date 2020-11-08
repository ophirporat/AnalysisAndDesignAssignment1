import java.util.Date;

public class ImmediatePayment extends Payment {
    private Boolean phoneConfirmation;

    public ImmediatePayment(float total, Account account, Order order) {
        super(total, account, order);
        this.paid=new Date();
    }


}
