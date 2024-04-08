import java.util.Scanner;

public class App {

    private  static void startSimulation(Shop shop, Scanner input, int simulationCount){
        for (int event = 0; event < simulationCount; event++) {
            String line = input.nextLine();
            if(!line.equals(" ")){
                System.out.println("Invalid input... Exiting...");
                break;
            }
            shop.startShopEvent();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shop shop = new Shop();
        // Simulation count
        int simulationCount = 20;
        // Start simulation
        startSimulation(shop, input, simulationCount);

        input.close();

        System.out.println("\n\n\nSimulation ended");
    }
}
