import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class Shop {
    private final Random random;
    private int x;
    private final Deque<String> seats;
    private final Deque<String> tempSeats;
    private String mainSeat;
    private String event;
    private int vipIndex = 0;
    private int ordIndex = 0;
    private final String VIP_ABBREV = "VIP";
    private final String ORD_ABBREV = "ORD";

    Shop() {
        this.random = new Random();
        this.seats = new ArrayDeque<>();
        this.tempSeats = new ArrayDeque<>();
        Utility.welcomeMessage();
    }

    public void startShopEvent() {
        int min = 0;
        int max = 3;
        this.x = random.nextInt((max - min) + 1) + min;
        int size = this.seats.size();
        if (size < 5 && this.mainSeat != null) {
            this.handleFreeSeatAndOccupiedMainSeat();
        } else if (size < 5) {
            this.handleFreeSeatAndFreeMainSeat();
        } else {
            this.handleOccupiedSeatAndOccupiedMainSeat();
        }
    }

    private void handleFreeSeatAndFreeMainSeat (){
        if (this.x == 0) {
            this.event = "-- " + "None";
            callPrint();
        } else if (this.x == 1) {
            this.event = STR."++ \{this.VIP_ABBREV}\{++this.vipIndex}";
            this.mainSeat = STR."\{this.VIP_ABBREV}\{this.vipIndex}";
            callPrint();
        } else {
            this.event = STR."++ \{this.ORD_ABBREV}\{++this.ordIndex}";
            this.mainSeat = STR."\{this.ORD_ABBREV}\{this.ordIndex}";
            callPrint();
        }
    }

    private void handleFreeSeatAndOccupiedMainSeat (){
        if (this.x == 0) {
            this.event = STR."-- \{mainSeat}";
            this.mainSeat = seats.pollFirst();

            callPrint();
        } else if (this.x == 1) {
            this.event = STR."++ \{this.VIP_ABBREV}\{++this.vipIndex}";

            int count = 0;
            for (int i = 0; i < seats.size(); i++) {
                if (seats.toArray()[i].toString().startsWith("O")) {
                    count++;
                }
            }
            for (int i = 0; i < count; i++) {
                this.tempSeats.addLast(seats.pollLast());
            }
            this.seats.addLast(STR."\{this.VIP_ABBREV}\{this.vipIndex}");
            this.seats.addAll(this.tempSeats);
            this.tempSeats.clear();

            callPrint();

        } else {
            this.event = STR."++ \{this.ORD_ABBREV}\{++this.ordIndex}";
            this.seats.addLast(STR."\{this.ORD_ABBREV}\{this.ordIndex}");
            callPrint();

        }
    }

    private void handleOccupiedSeatAndOccupiedMainSeat(){
        if (x == 0) {
            this.event = STR."-- \{mainSeat}";
            this.mainSeat = seats.pollFirst();
            callPrint();
        } else if (x == 1) {
            this.event = STR."+- \{this.VIP_ABBREV}\{++this.vipIndex}";
            callPrint();
        } else {
            this.event = STR."+- \{this.ORD_ABBREV}\{++this.ordIndex}";
            callPrint();
        }
    }


    private void printState(int x, String event, String mainSeat, Deque<String> seats) {
        String[] seatArray = new String[5];
        Arrays.fill(seatArray, null);
        seats.toArray(seatArray);
        StringBuilder seatString = new StringBuilder();
        String space = (Utility.isNumeric(event.substring(6)) && Integer.parseInt(event.substring(6)) >= 10) ? "" : " ";
        for (int i = 0; i < 5; i++) {
            if (seatArray[i] == null) {
                seatString.append(" : ---- ");
            } else {
                seatString.append(" : ").append(seatArray[i]).append(" ");
            }
        }
        String mainSeatString = mainSeat == null ? "----" : mainSeat;
        System.out.print(STR." \{x} ---->    ( \{event} ) \{space}       [  \{mainSeatString}\{seatString.toString()}]");
    }

    private void callPrint(){
        this.printState(x, event, mainSeat, seats);
    }
}
