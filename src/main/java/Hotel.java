import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private DiningRoom diningRoom;
    private ConferenceRoom conferenceRoom;

    public Hotel(String name, ArrayList<Bedroom> bedrooms, DiningRoom diningRoom, ConferenceRoom conferenceRoom) {
        this.name = name;
        this.bedrooms = bedrooms;
        this.diningRoom = diningRoom;
        this.conferenceRoom = conferenceRoom;
    }

    public String getName() {
        return name;
    }

    public DiningRoom getDiningRoom() {
        return diningRoom;
    }

    public ConferenceRoom getConferenceRoom() {
        return conferenceRoom;
    }

    public int bedroomCount() {
        return this.bedrooms.size();
    }

    public void checkIntoBedroom(Guest guest, Bedroom bedroom) {
        bedroom.checkIn(guest);
    }

    public void checkIntoConferenceRoom(Guest guest) {
        this.conferenceRoom.checkIn(guest);
    }

    public void checkIntoDiningRoom(Guest guest) {
        this.diningRoom.checkIn(guest);
    }
}
