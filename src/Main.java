import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static HashMap<String, WebUser> webUsers = new HashMap<>();
    private static HashMap<String, Supplier> suppliers = new HashMap<>();
    private static HashMap<String, Product> product = new HashMap<>();
    private static HashMap<Integer,Object> allObjects=new HashMap<>();
    private static int counter;
    private static int uniqueId=0;

    public static int getUniqueId() {
        uniqueId++;
        return uniqueId;
    }

    public static void main(String[] args) {
        counter = 0;
        AddToSystem();
        System.out.println("Welcome to THE STORE!");
        int pointer = 1;
        while (pointer != 9) {
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
                    removeProduct();
                    break;
                case 5:
                    removeUser();
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
        System.out.println("Are you a premium account? \nFor yes, press y \nFor no, press anything else ");
        String ans = in.next(); // premium account?
        ShoppingCart tempShoppingCart = new ShoppingCart();
        allObjects.put(getUniqueId(),tempShoppingCart);
        String tempId = getId();
        Account tempAccount;
        Address tempAddress = new Address();

        if (ans.equals("y")) { // PremiumAccount
            tempAccount = new PremiumAccount(tempId, tempAddress.getAddress(), tempShoppingCart);
        } else { // Account
            tempAccount = new Account(tempId, tempAddress.getAddress(), tempShoppingCart);
        }
        allObjects.put(getUniqueId(),tempAccount);
        Customer tempCustomer = new Customer(tempId, tempAddress.getAddress(), tempAccount);
        allObjects.put(getUniqueId(),tempCustomer);
        WebUser newUser = new WebUser(userName, password, tempCustomer);
        allObjects.put(getUniqueId(),newUser);
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
        Supplier newSup;
        if (suppliers.containsKey(SupplierName)) //supplier already exists
            newSup = suppliers.get(SupplierName);
        else { //supplier doesn't exist
            newSup = new Supplier(SupplierId, SupplierName);
            suppliers.put(SupplierName, newSup);
        }
        allObjects.put(getUniqueId(),newSup);
        Product newPr = new Product(productId, productName, newSup);
        allObjects.put(getUniqueId(),newPr);
        product.put(productName, newPr);
        newSup.AddProduct(newPr);
    }
    private static int getObjectUniqueId(Object object){
        for (HashMap.Entry<Integer, Object> entry: allObjects.entrySet()) {
            if (entry.getValue() ==object)return entry.getKey();
        }
        return -1;
    }
    private static void removeProduct() {
        System.out.println("Enter product name to remove: ");
        Scanner re = new Scanner(System.in);
        String proName = re.next();
        if (product.containsKey(proName)) {
            Product proToRemove = product.get(proName);
            product.remove(proName);
            int productId =getObjectUniqueId(proToRemove);
            int lineItemId;
            for (LineItem lineItem:proToRemove.getLineItems()) {
                lineItemId=getObjectUniqueId(lineItem);
                if (lineItemId!=-1)allObjects.remove(lineItemId);
            }
            if (productId!=-1)allObjects.remove(productId);
            proToRemove.RemoveProduct();
        }
    }

    private static void removeUser() {
        System.out.println("Enter user name to remove: ");
        Scanner re1 = new Scanner(System.in);
        String userName1 = re1.next();
        if (webUsers.containsKey(userName1)) {
            WebUser userToRemove = webUsers.get(userName1);
            allObjects.remove(getObjectUniqueId(userToRemove));
            userToRemove.DeleteWebUser();
            webUsers.remove(userName1);

        }
    }

    public static void AddToSystem() {

        String Id = "123";
        String Name = "Moshe";
        Supplier Moshe = new Supplier(Id, Name);
        allObjects.put(getUniqueId(),Moshe);

        suppliers.put("Moshe", Moshe);

        String Id1 = "Bamba";
        String Name1 = "Bamba";
        Product Bamba = new Product(Id1, Name1, Moshe);
        allObjects.put(getUniqueId(),Bamba);

        String Id2 = "Ramen";
        String Name2 = "Ramen";
        Product Ramen = new Product(Id2, Name2, Moshe);
        allObjects.put(getUniqueId(),Ramen);

        Moshe.AddProduct(Bamba);
        Moshe.AddProduct(Ramen);

        product.put("Bamba", Bamba);
        product.put("Ramen", Ramen);

        ShoppingCart daniShop = new ShoppingCart();
        allObjects.put(getUniqueId(), daniShop);
        String daniId = getId();
        Address daniAddress = new Address();
        Account daniA = new Account(daniId, daniAddress.getAddress(), daniShop);
        allObjects.put(getUniqueId(),daniA);
        Customer daniC = new Customer(daniId, daniAddress.getAddress(), daniA);
        allObjects.put(getUniqueId(),daniC);
        WebUser dani = new WebUser("Dani", "Dani123", daniC);
        allObjects.put(getUniqueId(),dani);
        dani.AddShopphingCart(daniShop);

        ShoppingCart danaShop = new ShoppingCart();
        allObjects.put(getUniqueId(),danaShop);
        String danaId = getId();
        Address danaAddress = new Address();
        PremiumAccount danaA = new PremiumAccount(danaId, danaAddress.getAddress(), danaShop);
        allObjects.put(getUniqueId(),danaA);
        Customer danaC = new Customer(danaId, daniAddress.getAddress(), danaA);
        allObjects.put(getUniqueId(),danaC);
        WebUser dana = new WebUser("Dana", "Dana123", danaC);
        allObjects.put(getUniqueId(),dana);
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
                System.out.println("Welcome to THE STORE, " + user +"!");
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
                    case 1: //LINK PRODUCT
                        Scanner pr = new Scanner(System.in);
                        System.out.println("Enter product name: ");
                        String productName = pr.next();
                        if (product.containsKey(productName)){
                            ((PremiumAccount) tempA).AddProduct(product.get(productName));
                            System.out.println("Enter product price: ");
                            String productPrice = pr.next();
                            int i = Integer.parseInt(productPrice);
                            System.out.println("Enter product quantity: ");
                            String productQuantity = pr.next();
                            int i2 = Integer.parseInt(productQuantity);
                            product.get(productName).setPrice(i);
                            product.get(productName).setQuantity(i2);
                        }
                        break;
                    case 2:
                        makeOrder(tempA);
                        break;
                    case 3:
                        if (tempA.getLastOrder() ==null) System.out.println("Acount has no orders");
                        else System.out.println(tempA.getLastOrder().toString());
                        break;
                    case 4:
                        showAllObjects();
                        break;
                    case 5:
                        System.out.println("Enter Object Id:");
                        in = new Scanner(System.in);
                        String objectId = in.next();
                        if (allObjects.containsKey(Integer.parseInt(objectId))){
                            System.out.println(objectId +"  :  " + allObjects.get(Integer.parseInt(objectId)));
                        }
                        else {
                            System.out.println("invalid Id");
                        }
                        break;
                    case 9:
                        System.out.println("Thank you, Good Bye!");
                        return;
                }
            }
        }else{
                int pointer = 1;
                while (pointer != 9) {
                    System.out.println("Welcome to THE STORE, " + user +"!");
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
                            makeOrder(tempA);
                            break;
                        case 2:
                            if (tempA.getLastOrder() ==null) System.out.println("Acount has no orders");
                            else System.out.println(tempA.getLastOrder().toString());
                            break;
                        case 3:
                            showAllObjects();
                            break;
                        case 4:
                            System.out.println("Enter Object Id:");
                            in = new Scanner(System.in);
                            String objectId = in.next();
                            if (allObjects.containsKey(Integer.parseInt(objectId))){
                                System.out.println(objectId +"  :  " + allObjects.get(Integer.parseInt(objectId)));
                            }
                            else {
                                System.out.println("invalid Id");
                            }
                            break;
                        case 9:
                            System.out.println("Thank you, Good Bye!");
                            return;

                    }
                }
            }
    }
    private static void showAllObjects(){
        for (Map.Entry<Integer,Object> entry:allObjects.entrySet()) {
            System.out.println(entry.getKey() + "  :  " + entry.getValue());

        }
    }
    private static void makeOrder(Account tempA) {
        System.out.println("Enter WebUser name to buy from: ");
        Scanner su = new Scanner(System.in);
        String SupplierName = su.next();
        Order newOrd = new Order(tempA);
        allObjects.put(getUniqueId(),newOrd);
        if (suppliers.containsKey(SupplierName)) {
            Supplier newSup = suppliers.get(SupplierName);
            ArrayList <Product> productsList = newSup.getProducts();
            for (Product product: productsList) { //print all products in the supplier's product list
                System.out.println(product.getName());
            }
            String done = "y";
            while (done.equals("y")) {
                Product pro = null;
                boolean stopLoop = true;
                while (stopLoop) {
                    System.out.println("Enter product name from the list: ");
                    String productName = su.next();
                    for (Product product : productsList) { //checks whether the requested product is on the list
                        if (productName.equals(product.getName())) {
                            pro = product;
                            stopLoop = false;
                        }
                    }
                    if (stopLoop)
                        System.out.println("The product isn't on the list, Try again");
                }
                System.out.println("Enter num of product: ");
                String productNum = su.next();
                int i3 = Integer.parseInt(productNum);
                LineItem newLineItem = new LineItem(i3, pro);
                allObjects.put(getUniqueId(),newLineItem);
                newLineItem.SetOrder(newOrd); //setOrder links between lineItem and Order both ways
                tempA.getShoppingCart().AddLineItem(newLineItem);
                System.out.println("Would you like to buy more products? \nFor yes, press y \nFor no, press anything else");
                Scanner in = new Scanner(System.in);
                done = in.next();
            }
            tempA.AddOrder(newOrd);
        }
        System.out.println("Enter shipping address: ");
        String shippingAddress = su.next();
        newOrd.setShip_to(shippingAddress);
        System.out.println("Your order has been completed!");
    }
}
