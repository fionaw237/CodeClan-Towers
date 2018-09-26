import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    ConferenceRoom conferenceRoom1;
    DiningRoom diningRoom1;
    Guest guest1;
    Guest guest2;
    ArrayList<Bedroom> bedrooms = new ArrayList<Bedroom>();

    @Before
    public void before() {


        guest1 = new Guest("John Mike");
        guest2 = new Guest("Laura Mike");
        bedroom1 = new Bedroom(2, "101", "double", 40.20);
        bedroom2 = new Bedroom(1, "102", "single", 22.00);
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
        hotel.checkIntoBedroom(guest1, roomType, 2);
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
        hotel.checkIntoBedroom(guest1, roomType, 2);
        Bedroom foundBedroom = hotel.findBedroomByNumber(guest1.getRoomNumber());
        assertEquals(bedroom2, foundBedroom);
    }

    @Test
    public void canCheckGuestOutOfSingleBedroom() {
        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType, 2);
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
    public void canGetGuestListOfBedroom() {
        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType, 2);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        assertEquals(guests, hotel.showGuestsByBedroom(bedroom2));
    }

    @Test
    public void canGetGuestListOfDiningRoom() {
        hotel.checkIntoDiningRoom(guest1);
        hotel.checkIntoDiningRoom(guest2);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        assertEquals(guests, hotel.showGuestsInDiningRoom());
    }

    @Test
    public void canGetGuestListOfConferenceRoom() {
        hotel.checkIntoConferenceRoom(guest1);
        hotel.checkIntoConferenceRoom(guest2);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        assertEquals(guests, hotel.showGuestsInConfefenceRoom());
    }

    @Test
    public void canCheckInGuestsToMultipleSingleBedroom() {
        Bedroom bedroom3 = new Bedroom(2, "B103", "single", 20);
        bedrooms.add(bedroom3);

        Guest guest3 = new Guest("Fiona Wilson");

        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType, 2);
        hotel.checkIntoBedroom(guest2, roomType, 2);
        hotel.checkIntoBedroom(guest3, roomType, 2);


        assertEquals(1, bedroom2.guestCount());
        assertEquals(2, bedroom3.guestCount());
    }

    @Test
    public void canGetVacantBedrooms() {
        Bedroom bedroom3 = new Bedroom(2, "B103", "single", 20);
        bedrooms.add(bedroom3);

        Guest guest3 = new Guest("Fiona Wilson");

        String roomType = "single";
        hotel.checkIntoBedroom(guest1, roomType, 2);
        hotel.checkIntoBedroom(guest2, roomType, 2);
        hotel.checkIntoBedroom(guest3, roomType, 2);


        assertEquals(1, bedroom2.guestCount());
        assertEquals(2, bedroom3.guestCount());

        ArrayList<Bedroom> vacantRooms = new ArrayList<Bedroom>();
        vacantRooms.add(bedroom1);

        assertEquals(vacantRooms, hotel.getVacantRooms());
    }

    @Test
    public void canCheckGuestInFor2Nights() {
        hotel.checkIntoBedroom(guest1, "single", 2);
        assertEquals(2, guest1.getNumberOfNights());
    }
}
