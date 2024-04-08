import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class Shop {
    private Random random;
    private int x;
    private Deque<String> seats;
    private Deque<String> tempSeats;
    private boolean isMainEmpty = true;
    private String client;
    private String mainSeat;
    private String event;
    private String outGoingClient = "";
    private int vipIndex = 0;
    private int ordIndex = 0;
    private boolean isThereOrd = false;

    Shop() {
        this.random = new Random();
        this.seats = new ArrayDeque<>();
        this.tempSeats = new ArrayDeque<>();
        System.out.println("     X         Events                              State Of The Shop                  ");
        System.out.println("+----------+--------------+-------------------------------------------------------------+");
    }

    public void shopEvent() {
        int min = 0;
        int max = 3;
        this.x = random.nextInt((max - min) + 1) + min;
        int size = this.seats.size();
        if (size < 5 && (this.mainSeat != null)) {
            if (this.x == 0) {
                this.event = "-- " + mainSeat;
                this.outGoingClient = this.mainSeat;
                this.mainSeat = seats.isEmpty() ? null : seats.pollFirst();
                this.print(x, event, outGoingClient, seats);
            } else if (this.x == 1) {
                this.event = "++ VIP" + ++vipIndex;

                int count = 0;
                for (int i = 0; i < seats.size(); i++) {
                    if (seats.toArray()[i].toString().startsWith("O")) {
                        count++;
                    }
                }
                for (int i = 0; i < count; i++) {
                    this.tempSeats.addLast(seats.pollLast());
                }
                this.seats.addLast("VIP" + vipIndex);
                this.seats.addAll(tempSeats);
                tempSeats.clear();

                this.print(x, event, mainSeat, seats);

            } else {
                this.event = "++ ORD" + ++ordIndex;
                this.seats.addLast("ORD" + ordIndex);
                this.print(x, event, mainSeat, seats);

            }
        } else if (size < 5 && this.mainSeat == null) {
            if (this.x == 0) {
                this.event = "-- " + " None";
            } else if (this.x == 1) {
                this.event = "++ VIP" + ++vipIndex;
                this.mainSeat = "VIP" + vipIndex;
                print(x, event, mainSeat, seats);
            } else {
                this.event = "++ ORD" + ++ordIndex;
                this.mainSeat = "ORD" + ordIndex;
                print(x, event, mainSeat, seats);
            }
        } else {
            if (x == 0) {
                this.event = "-- " + mainSeat;
                this.outGoingClient = this.mainSeat;
                this.mainSeat = seats.isEmpty() ? null : seats.pollFirst();
                this.print(x, event, outGoingClient, seats);
            } else if (x == 1) {
                this.event = "+- VIP" + ++vipIndex;
                print(x, event, mainSeat, seats);
            } else {
                this.event = "+- ORD" + ++ordIndex;
                print(x, event, mainSeat, seats);
            }
        }
    }

    public void print(int x, String event, String mainSeat, Deque<String> seats) {
        String[] seatArray = new String[5];
        Arrays.fill(seatArray, null);
        seats.toArray(seatArray);
        StringBuilder seatString = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            if (seatArray[i] == null) {
                seatString.append(" : ----");
            } else {
                seatString.append(" " + seatArray[i] + " ");
            }
        }
        System.out.println(" " + x + " ---->    ( " + event + "  )       [  " + mainSeat + "" + seatString + "]");
    }
}
