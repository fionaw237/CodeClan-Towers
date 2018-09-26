import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest1;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(10, "Meeting Room 1", 100);
        guest1 = new Guest("John Mike");
    }

    @Test
    public void hasCapacity() {
        assertEquals(10, conferenceRoom.getCapacity());
    }

    @Test
    public void hasName() {
        assertEquals("Meeting Room 1", conferenceRoom.getName());
    }

    @Test
    public void hasDailyRate() {
        assertEquals(100, conferenceRoom.getDailyRate(), 0.01);
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, conferenceRoom.guestCount());
    }

    @Test
    public void canCheckInGuest() {
        conferenceRoom.checkIn(guest1);
        assertEquals(1, conferenceRoom.guestCount());
    }

    @Test
    public void canCheckOutGuest() {
        conferenceRoom.checkIn(guest1);
        conferenceRoom.checkOut(guest1);
        assertEquals(0, conferenceRoom.guestCount());
    }

}
