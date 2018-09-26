import java.util.ArrayList;

public class ConferenceRoom {

    private int capacity;
    private ArrayList<Guest> guests;
    private String name;
    private double dailyRate;

    public ConferenceRoom(int capacity, String name, double dailyRate) {
        this.capacity = capacity;
        this.name = name;
        this.dailyRate = dailyRate;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public int guestCount() {
        return this.guests.size();
    }

    public void checkIn(Guest guest) {
        this.guests.add(guest);
    }

    public void checkOut(Guest guest) {
        this.guests.remove(guest);
    }
}
