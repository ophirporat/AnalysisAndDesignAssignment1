import java.util.HashMap;
import java.util.Scanner;

public class Main {


    private static HashMap<String, WebUser> webUsers = new HashMap<>();
    private static HashMap<String, Supplier> suppliers = new HashMap<>();
    private static HashMap<String, Product> product = new HashMap<>();
    private static int counter;

    public static void main(String[] args) {
        counter = 0;
        AddToSystem();
        System.out.println("Welcome to THE STORE!");
        int pointer = 1;
        while (pointer != 6) {
            System.out.println("press 1 for SIGN IN");
            System.out.println("press 2 for LOG IN");
            System.out.println("press 3 to ADD PRODUCT");
            System.out.println("press 4 to REMOVE PRODUCT");
            System.out.println("press 5 to REMOVE USER");
            System.out.println("press 9 to EXIT");
            Scanner in = new Scanner(System.in);
            pointer = in.nextInt();
            switch (pointer) {
                case 1:
                    addWebUser();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    removeProduct(); //TODO
                    break;
                case 5:
                    removeUser();//TODO
                    break;
                case 9:
                    System.out.println("Thank you, Good Bye!");
                    break;
            }
        }
    }

    public static String getId() {
        counter++;
        return String.valueOf(counter);
    }

    private static void addWebUser() {
        System.out.println("Enter user name: ");
        Scanner in = new Scanner(System.in);
        String userName = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        System.out.println("Do you want to have a premium account? \nFor yes, press y \nFor no, press anything else ");
        String ans = in.next(); // premium account?
        ShoppingCart tempShoppingCart = new ShoppingCart();
        String tempId = getId();
        Account tempAccount;
        Address tempAddress = new Address();

        if (ans.equals("y")) { // PremiumAccount
            tempAccount = new PremiumAccount(tempId, tempAddress.getAddress(), tempShoppingCart);
        } else { // Account
            tempAccount = new Account(tempId, tempAddress.getAddress(), tempShoppingCart);
        }
        Customer tempCustomer = new Customer(tempId, tempAddress.getAddress(), tempAccount);
        WebUser newUser = new WebUser(userName, password, tempCustomer);
        webUsers.put(userName, newUser);
        mainMenu(userName);
    }

    private static void logIn() {
        while (true) {
            System.out.println("Enter user name: ");
            Scanner sc = new Scanner(System.in);
            String userName = sc.next();
            System.out.println("Enter password: ");
            String userPassword = sc.next();
            if (webUsers.containsKey(userName)) {
                if (userPassword.equals(webUsers.get(userName).getPassword())) {
                    mainMenu(userName);
                    break;
                }
            }
            System.out.println("Wrong user name or password!");
        }
    }

    private static void addProduct() {
        System.out.println("Enter product Id: ");
        Scanner pr = new Scanner(System.in);
        String productId = pr.next();
        System.out.println("Enter product name: ");
        String productName = pr.next();
        System.out.println("Enter supplier Id: ");
        String SupplierId = pr.next();
        System.out.println("Enter supplier name: ");
        String SupplierName = pr.next();
        Supplier newSup = new Supplier(SupplierId, SupplierName);
        Product newPr = new Product(productId, productName, newSup);
        product.put(productName, newPr);
        suppliers.put(SupplierName, newSup);
        newSup.AddProduct(newPr);
    }

    private static void removeProduct() {

    }

    private static void removeUser() {

    }

    public static void AddToSystem() {

        String Id = "123";
        String Name = "Moshe";
        Supplier Moshe = new Supplier(Id, Name);

        suppliers.put("Moshe", Moshe);

        String Id1 = "Bamba";
        String Name1 = "Bamba";
        Product Bamba = new Product(Id1, Name1, Moshe);

        String Id2 = "Ramen";
        String Name2 = "Ramen";
        Product Ramen = new Product(Id2, Name2, Moshe);

        Moshe.AddProduct(Bamba);
        Moshe.AddProduct(Ramen);
        product.put("Bamba", Bamba);
        product.put("Ramen", Ramen);

        ShoppingCart daniShop = new ShoppingCart();
        String daniId = getId();
        Address daniAddress = new Address();
        Account daniA = new Account(daniId, daniAddress.getAddress(), daniShop);
        Customer daniC = new Customer(daniId, daniAddress.getAddress(), daniA);
        WebUser dani = new WebUser("Dani", "Dani123", daniC);
        dani.AddShopphingCart(daniShop);

        ShoppingCart danaShop = new ShoppingCart();
        String danaId = getId();
        Address danaAddress = new Address();
        PremiumAccount danaA = new PremiumAccount(danaId, danaAddress.getAddress(), danaShop);
        Customer danaC = new Customer(danaId, daniAddress.getAddress(), danaA);
        WebUser dana = new WebUser("Dana", "Dana123", danaC);
        dana.AddShopphingCart(danaShop);
        danaA.AddProduct(Bamba);

        webUsers.put("Dani", dani);
        webUsers.put("Dana", dana);

    }

    public static void mainMenu(String user) {
        WebUser temp = webUsers.get(user);
        Account tempA = temp.getCustomer().getAccount();
        if (tempA instanceof PremiumAccount) {
            int pointer = 1;
            while (pointer != 9) {
                System.out.println("Welcome " + user + " to THE STORE!");
                System.out.println("What would you like to do next?");
                System.out.println("press 1 to LINK PRODUCT");
                System.out.println("press 2 for MAKE ORDER");
                System.out.println("press 3 to DISPLAY ORDER");
                System.out.println("press 4 to SHOW ALL OBJECTS");
                System.out.println("press 5 to SHOW OBJECT ID");
                System.out.println("press 9 to LOGOUT");

                Scanner in = new Scanner(System.in);
                pointer = in.nextInt();
                switch (pointer) {
                    case 1:
                        Scanner pr = new Scanner(System.in);
                        System.out.println("Enter product name: ");
                        String productName = pr.next();
                        if (product.containsKey(productName)) {
                            ((PremiumAccount) tempA).AddProduct(product.get(productName));
                            break;
                            case 2:
                                makeOrder();
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 9:
                                System.out.println("Thank you, Good Bye!");
                                break;
                        }
                }
            }
        }else{
                int pointer = 1;
                while (pointer != 9) {
                    System.out.println("Welcome " + user + "to THE STORE!");
                    System.out.println("What would you like to do next?");
                    System.out.println("press 1 for MAKE ORDER");
                    System.out.println("press 2 to DISPLAY ORDER");
                    System.out.println("press 3 to SHOW ALL OBJECTS");
                    System.out.println("press 4 to SHOW OBJECT ID");
                    System.out.println("press 9 to LOGOUT");

                    Scanner in = new Scanner(System.in);
                    pointer = in.nextInt();

                    switch (pointer) {
                        case 1:
                            makeOrder();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 9:
                            System.out.println("Thank you, Good Bye!");
                            break;

                    }
                }
            }
        }

    private static void makeOrder() {
        System.out.println("Enter WebUser name to buy from: ");
        Scanner su = new Scanner(System.in);
        String SupplierName = su.next();
        if (suppliers.containsKey(SupplierName)) {
            Supplier newSup = suppliers.get(SupplierName);

            //newSup loop product

            System.out.println("Enter product name from the list: ");
            String productName = su.next();
            System.out.println("Enter num of product: ");
            String productNum = su.next();
            //another loop
        }
    }
}
