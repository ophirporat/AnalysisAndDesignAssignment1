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

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public Product(String id, String name, Supplier supplier, PremiumAccount premiumAccount) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.premiumAccount = premiumAccount;
    }

    //functions
    public boolean AddLineItem(LineItem lineItem){
        assert lineItem!=null;
        return lineItems.add(lineItem);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", supplier=" + supplier +
                ", lineItems=" + lineItems +
                ", premiumAccount=" + premiumAccount +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
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

    }

    public void RemovePremiumAccount() {
        premiumAccount=null;
        for (LineItem item: lineItems) {
            RemoveLineItem(item);

        }
    }
}
