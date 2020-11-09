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
        lineItems=new ArrayList<>();
    }

    public boolean AddLineItem(LineItem lineItem){
        assert lineItem!=null;
        if (lineItems.isEmpty()) this.created=new Date();
        return lineItems.add(lineItem);
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public Account getAccount() {
        return account;
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

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "webUser=" + webUser +
                '}';
    }
}
