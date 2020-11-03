import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    private Date created;
    // association with WebUser
    private WebUser webUser;
    // association with LineItem
    private ArrayList<LineItem> lineItems;
    // conmposition with Account
    private Account account;

    public ShoppingCart(Date created, WebUser webUser,Account account) {
        this.created = created;
        this.webUser = webUser;
        this.account =account;
        lineItems=new ArrayList<>();
    }

    public boolean AddLineItem(LineItem lineItem){
        assert lineItem!=null;
        return lineItems.add(lineItem);
    }

    public boolean RemoveLineItem(LineItem lineItem){
        assert lineItem!=null;
        return lineItems.remove(lineItem);
    }


}
