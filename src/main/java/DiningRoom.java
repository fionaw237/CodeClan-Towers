import java.util.ArrayList;

public class DiningRoom {

    private int capacity;
    private ArrayList<Guest> guests;

    public DiningRoom(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int guestCount() {
        return this.guests.size();
    }

    public void checkIn(Guest guest) {
        if (!isFull()){
            this.guests.add(guest);
        }
    }

    public void checkOut(Guest guest) {
        this.guests.remove(guest);
    }

    public ArrayList<Guest> getGuests() {
        return new ArrayList<Guest>(guests);
    }

    public boolean isFull() {
        return this.capacity == guestCount();
    }

}
