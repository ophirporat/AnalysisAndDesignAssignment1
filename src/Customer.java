public class Customer {
    private String id;
    //check which Address type
    private String address;
    private String phone;
    private String email;
    private WebUser webUser;
    private Account account;

    public Customer(String id, String address, Account account) {
        this.id = id;
        this.address = address;
        this.phone = "555";
        this.email = ".com";
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                '}';
    }

    public Account getAccount() {
        return account;
    }

    public boolean AddWebUser(WebUser webUser){
        if (this.webUser==null && webUser.AddCustomer(this)){
            this.webUser=webUser;
            return true;
        }
        return false;
    }


    public void RemoveWebUser() {
        webUser=null;
    }
}
