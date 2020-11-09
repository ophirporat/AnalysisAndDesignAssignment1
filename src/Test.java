import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        String testRemoveProduct ="2\n Dani\n Dani123\n 1\n Dana\n Bamba\n 1\n n\n beerSheva\n 1\n 9\n" +
                "2\n Dana\n Dana123\n 6\n 2\n Bamba\n 6\n 9\n 9\n";
        String testRemovePremiumUser = "3\n Dana\n 9\n";
        String testRemoveUser = "3\n Dani\n 9\n";
        String testRemoveNewUser = "1\n ophir\n ophir123\n y\n 1000\n 9\n 3\n ophir\n 9\n";
        InputStream inputStream1 = new ByteArrayInputStream(testRemoveNewUser.getBytes());
        Main.scanner =new Scanner(inputStream1);
        Main.main(args);



    }
}
