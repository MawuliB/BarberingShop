public class Utility {

    private Utility() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}