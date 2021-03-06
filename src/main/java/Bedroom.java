import java.util.ArrayList;

public class Bedroom {

    private int capacity;
    private ArrayList<Guest> guests;
    private String roomNumber;
    private String type;
    private double nightlyRate;

    public Bedroom(int capacity, String roomNumber, String type, double nightlyRate) {
        this.capacity = capacity;
        this.roomNumber = roomNumber;
        this.type = type;
        this.nightlyRate = nightlyRate;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getNightlyRate() {
        return nightlyRate;
    }

    public ArrayList<Guest> getGuests() {
        return new ArrayList<>(guests);
    }

    public int guestCount() {
        return this.guests.size();
    }

    public void checkIn(Guest guest, int numberOfNights) {
        if (!isFull()) {
            this.guests.add(guest);
            guest.setRoomNumber(this.roomNumber);
            guest.setNumberOfNights(numberOfNights);
        }

    }

    public void checkOut(Guest guest) {
        this.guests.remove(guest);
        guest.setRoomNumber(null);
        guest.setNumberOfNights(0);
    }

    public boolean isFull() {
        return this.capacity == guestCount();
    }
}
