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

    public ShoppingCart() {
        this.created = new Date();
        this.webUser = webUser;
        this.account =account;
        lineItems=new ArrayList<>();
    }

    public boolean AddLineItem(LineItem lineItem){
        assert lineItem!=null;
        if (lineItems.isEmpty()) this.created=new Date();
        return lineItems.add(lineItem);
    }


    public boolean RemoveWebUser() {
        webUser=null;
        for (LineItem item: lineItems) {
            lineItems.remove(item);
            item.RemoveFromWorld();
        }
        return true;
    }

    public void RemoveLineItem(LineItem lineItem) {
        lineItems.remove(lineItem);
    }
}
