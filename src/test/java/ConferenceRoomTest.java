import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(10, "Meeting Room 1", 100);
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
}
