import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop();
        for (int i = 0; i < 20; i++) {
            String line = input.nextLine();
            if(!line.equals(" ")){
                System.out.println("Invalid input... Exiting...");
                break;
            }
            shop.shopEvent();
        }
        input.close();
    }
}
