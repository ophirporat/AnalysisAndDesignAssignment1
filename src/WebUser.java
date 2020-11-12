public class WebUser {

    enum UserState{
        New, Active, Blocked, Banned
    }

    private String login_id;
    private String password;
    private UserState state;
    private Customer customer;

    @Override
    public String toString() {
        return "WebUser{" +
                "login_id='" + login_id + '\'' +
                ", customer=" + customer.getId() +
                ", shoppingCart=" + shoppingCart +
                '}';
    }

    private ShoppingCart shoppingCart;

    public WebUser(String login_id, String password, Customer customer) {
        this.login_id = login_id;
        this.password = password;
        this.state = UserState.New ;
        this.customer = customer;
        customer.AddWebUser(this);

    }

    public boolean AddCustomer(Customer customer){
        if (this.customer==null)return false;
        this.customer=customer;
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getLogin_id() {
        return login_id;
    }

    private boolean HasShoppingcart(){
        return shoppingCart!=null;
    }
    public boolean AddShopphingCart(ShoppingCart shoppingCart){
        if (!HasShoppingcart()){
            this.shoppingCart=shoppingCart;
            shoppingCart.setWebUser(this);
            return true;
        }
        return false;
    }

    public void DeleteWebUser(){
        customer.RemoveWebUser();
        RemoveShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getPassword() {
        return password;
    }

    public boolean RemoveShoppingCart(){
        if (HasShoppingcart()){
            //shoppingCart.RemoveWebUser();
            shoppingCart=null;
            return true;
        }
        return false;
    }

}
