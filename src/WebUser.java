public class WebUser {

    enum UserState{
        New, Active, Blocked, Banned
    }
    private String login_id;
    private String password;
    private UserState state;
    private Customer customer;
    private ShoppingCart shoppingCart;

    public WebUser(String login_id, String password, Customer customer) {
        this.login_id = login_id;
        this.password = password;
        this.state = UserState.New ;
        this.customer = customer;

    }

    public boolean AddCustomer(Customer customer){
        if (this.customer==null)return false;
        this.customer=customer;
        return true;
    }


    private boolean HasShoppingcart(){
        return shoppingCart!=null;
    }
    public boolean AddShopphingCart(ShoppingCart shoppingCart){
        if (!HasShoppingcart()){
            this.shoppingCart=shoppingCart;
            return true;
        }
        return false;
    }

    public boolean DeleteWebUser(){
        customer.RemoveWebUser();
        return RemoveShoppingCart();
    }
    public boolean RemoveShoppingCart(){
        if (HasShoppingcart()){
            shoppingCart.RemoveWebUser();
            shoppingCart=null;
            return true;
        }
        return false;
    }
}
