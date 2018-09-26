import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    ConferenceRoom conferenceRoom1;
    DiningRoom diningRoom1;
    Guest guest1;
    Guest guest2;

    @Before
    public void before() {


        guest1 = new Guest("John Mike");
        guest2 = new Guest("Laura Mike");
        bedroom1 = new Bedroom(2, "101", "double", 40.20);
        bedroom2 = new Bedroom(1, "102", "single", 22.00);
        ArrayList<Bedroom> bedrooms = new ArrayList<Bedroom>();
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        conferenceRoom1 = new ConferenceRoom(10, "Meeting Room 1", 100);
        diningRoom1 = new DiningRoom(100);

        hotel = new Hotel("Citizen M", bedrooms, diningRoom1, conferenceRoom1);
    }

    @Test
    public void hasName() {
        assertEquals("Citizen M", hotel.getName());
    }

    @Test
    public void hasBedrooms() {
        assertEquals(2, hotel.bedroomCount());
    }

    @Test
    public void hasDiningRoom() {
        assertEquals(diningRoom1, hotel.getDiningRoom());
    }

    @Test
    public void hasConferenceRoom() {
        assertEquals(conferenceRoom1, hotel.getConferenceRoom());
    }

    @Test
    public void canCheckGuestIntoSingleBedroom() {
        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType);
        assertEquals(1, bedroom2.guestCount());
        assertEquals(0, bedroom1.guestCount());
    }

    @Test
    public void canCheckGuestIntoConferenceRoom() {
        hotel.checkIntoConferenceRoom(guest1);
        hotel.checkIntoConferenceRoom(guest2);
        assertEquals(2, hotel.getConferenceRoom().guestCount());
    }

    @Test
    public void canCheckGuestIntoDiningRoom() {
        hotel.checkIntoDiningRoom(guest1);
        hotel.checkIntoDiningRoom(guest2);
        assertEquals(2, hotel.getDiningRoom().guestCount());
    }

    @Test
    public void canFindBedroomByNumber() {
        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType);
        Bedroom foundBedroom = hotel.findBedroomByNumber(guest1.getRoomNumber());
        assertEquals(bedroom2, foundBedroom);
    }

    @Test
    public void canCheckGuestOutOfSingleBedroom() {
        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType);
        assertEquals(1, bedroom2.guestCount());
        assertEquals(0, bedroom1.guestCount());
        hotel.checkOutOfBedroom(guest1);
        assertEquals(0, bedroom2.guestCount());
        assertEquals(null, guest1.getRoomNumber());
    }

    @Test
    public void canCheckGuestOutOfConferenceRoom() {
        hotel.checkIntoConferenceRoom(guest1);
        hotel.checkIntoConferenceRoom(guest2);
        hotel.checkOutOfConferenceRoom(guest1);
        assertEquals(1, hotel.getConferenceRoom().guestCount());
    }

    @Test
    public void canCheckGuestOutOfDiningRoom() {
        hotel.checkIntoDiningRoom(guest1);
        hotel.checkIntoDiningRoom(guest2);
        hotel.checkOutOfDiningRoom(guest1);
        assertEquals(1, hotel.getDiningRoom().guestCount());
    }

    @Test
    public void canGetGuestListOfRoom() {
        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        assertEquals(guests, hotel.showGuestsByBedroom(bedroom2));
    }

}
