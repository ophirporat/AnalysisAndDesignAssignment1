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

    //constructors
    public Product(String id, String name, Supplier supplier) {
        this.id = id;
        this.name = name;
        assert supplier!=null;
        this.supplier = supplier;
        lineItems=new ArrayList<>();
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

    public boolean AddPremiumAccount(PremiumAccount premiumAccount1){
        if (premiumAccount!=null) return false;
        premiumAccount=premiumAccount1;
        return true;
    }

    public boolean HasPremiumAccount(){
        return premiumAccount!=null;
    }

    public boolean HasSupplier(){
        return supplier!=null;
    }





}
