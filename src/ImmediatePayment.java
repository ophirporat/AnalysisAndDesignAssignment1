import java.util.Date;

public class ImmediatePayment extends Payment {
    private Boolean phoneConfirmation;

    public ImmediatePayment(String id, Date paid, float total, String details, Account account, Order order) {
        super(id, paid, total, details, account, order);
    }


}
