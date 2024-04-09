public class Utility {

    private Utility() {
        throw new IllegalStateException("Utility class");
    }

    public static void welcomeMessage() {
        System.out.println("\nWelcome to Executive Barbering Shop\n");
        System.out.println("Press Space Key And Enter To Move To The Next Event\n\n");
        System.out.println("     X         Events                          State Of The Shop                  ");
        System.out.print("+----------+---------------+------------------------------------------------------+");
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}