import java.util.ArrayList;

public class Product {
    private String id;
    private String name;
    // association with Supplier
    private Supplier supplier;
    // association with lineItem
    private ArrayList<LineItem> lineItems;
    // association with premiumAccount
    private PremiumAccount premiumAccount;
    private int price;
    private int quantity;

    //constructors
    public Product(String id, String name, Supplier supplier) {
        this.id = id;
        this.name = name;
        assert supplier!=null;
        this.supplier = supplier;
        lineItems=new ArrayList<>();
        price=0;
        quantity=0;
    }

    @Override
    public String toString() {
        String lineItemList = "";
        for (LineItem item : lineItems) { //print all products in the supplier's product list
            lineItemList += "produduct name: " + item.getProduct().getName() + "price: " + item.getPrice() + "quantity: " + item.getQuantity() + "), ";
        }
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", supplier=" + supplier.getName() +
                ", lineItems=" + lineItemList +
                ", premiumAccount=" + premiumAccount +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    //functions
    public boolean AddLineItem(LineItem lineItem){
        assert lineItem!=null;
        lineItem.setProduct(this);
        return lineItems.add(lineItem);
    }
    public void RemoveFromSupplier(){
        supplier.DeleteProduct(this);
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<LineItem> getLineItems() { return lineItems; }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean AddPremiumAccount(PremiumAccount premiumAccount1){
        if (premiumAccount!=null) return false;
        premiumAccount=premiumAccount1;
        return true;
    }

    public PremiumAccount getPremiumAccount() {
        return premiumAccount;
    }

    public boolean HasPremiumAccount(){
        return premiumAccount!=null;
    }

    public boolean HasSupplier(){
        return supplier!=null;
    }


    public void RemoveLineItem(LineItem lineItem) {
        if (lineItem!=null && lineItems.contains(lineItem)){
            lineItems.remove(lineItem);
            lineItem.RemoveFromWorld();
        }
    }

    public void RemoveProduct(){
        //delete supplier
        if (HasSupplier()){
            this.supplier.DeleteProduct(this);
        }
        this.supplier=null;

        //delete premium account
        if (HasPremiumAccount()){
            this.premiumAccount.RemoveProduct(this);
        }
        this.premiumAccount=null;

//        for (LineItem item: lineItems) { //TODO: check if lineItem deled from main: if not- add!
//            RemoveLineItem(item);
//        }

    }
}
