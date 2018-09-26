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

    public void checkIntoBedroom(Guest guest, String roomType) {
        for (Bedroom bedroom: this.bedrooms) {
            if (bedroom.getType() == roomType && !bedroom.isFull()) {
                bedroom.checkIn(guest);
                break;
            }
        }
    }

    public void checkIntoConferenceRoom(Guest guest) {
        this.conferenceRoom.checkIn(guest);
    }

    public void checkIntoDiningRoom(Guest guest) {
        this.diningRoom.checkIn(guest);
    }

    public void checkOutOfBedroom(Guest guest) {
        Bedroom bedroom = findBedroomByNumber(guest.getRoomNumber());
        bedroom.checkOut(guest);
    }



    public Bedroom findBedroomByNumber(String roomNumber) {
        for (Bedroom bedroom: this.bedrooms) {
            if (bedroom.getRoomNumber() == roomNumber) {
                return bedroom;
            }
        }
        return null;
    }

    public void checkOutOfConferenceRoom(Guest guest) {
        this.conferenceRoom.checkOut(guest);
    }

    public void checkOutOfDiningRoom(Guest guest) {
        this.diningRoom.checkOut(guest);
    }

    public ArrayList<Guest> showGuestsByBedroom(Bedroom bedroom) {
        if (bedroom.guestCount() > 0) {
            return bedroom.getGuests();
        }
        return null;
    }

    public ArrayList<Guest> showGuestsInDiningRoom() {
        if (this.diningRoom.guestCount() > 0) {
            return diningRoom.getGuests();
        }
        return null;
    }

    public ArrayList<Guest> showGuestsInConfefenceRoom() {
        if (this.conferenceRoom.guestCount() > 0) {
            return conferenceRoom.getGuests();
        }
        return null;
    }

    public ArrayList<Bedroom> getVacantRooms() {
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        for (Bedroom bedroom: this.bedrooms) {
            if (bedroom.guestCount() == 0) {
                vacantRooms.add(bedroom);
            }
        }
        return vacantRooms;
    }
}
