public class WebUser {
    private String login_id;
    private String password;
    private UserStatus state;
    private Customer customer;

    public WebUser(String login_id, String password, UserStatus state, Customer customer) {
        this.login_id = login_id;
        this.password = password;
        this.state = state;
        this.customer = customer;
    }

    public boolean HasCustomer(){
        return customer!=null;
    }
    public boolean AddCustomer(Customer customer){
        if (HasCustomer())return false;
        this.customer=customer;
        return true;
    }
}
