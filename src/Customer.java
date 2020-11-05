public class Customer {
    private String id;
    //check which Address type
    private String address;
    private String phone;
    private String email;
    private WebUser webUser;
    private Account account;

    public Customer(String id, String address, String phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;

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
