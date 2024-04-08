public class App {
    public static void main(String[] args) throws Exception {
        Shop shop = new Shop();
        for (int i = 0; i < 20; i++) {
            shop.shopEvent();
        }
    }
}
