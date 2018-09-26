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
    public void canCheckGuestIntoBedroom() {
        hotel.checkIntoBedroom(guest1, bedroom1);
        assertEquals(1, bedroom1.guestCount());
    }

    @Test
    public void canCheckGuestIntoConferenceRoom() {
        hotel.checkIntoConferenceRoom(guest1, conferenceRoom1);
        hotel.checkIntoConferenceRoom(guest2, conferenceRoom1);
        assertEquals(2, conferenceRoom1.guestCount());
    }

    @Test
    public void canCheckGuestIntoDiningRoom() {
        hotel.checkIntoDiningRoom(guest1, diningRoom1);
        hotel.checkIntoDiningRoom(guest2, diningRoom1);
        assertEquals(2, diningRoom1.guestCount());
    }
}
