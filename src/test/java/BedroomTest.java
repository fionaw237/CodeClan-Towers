import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest1;

    @Before
    public void before() {
        bedroom = new Bedroom(2, "101", "double", 40.20);
        guest1 = new Guest("John Mike");
    }

    @Test
    public void hasCapacity() {
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void hasRoomNumber() {
        assertEquals("101", bedroom.getRoomNumber());
    }

    @Test
    public void hasRoomType() {
        assertEquals("double", bedroom.getType());
    }

    @Test
    public void hasNightlyRate() {
        assertEquals(40.20, bedroom.getNightlyRate(), 0.01);
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void canCheckInGuest() {
        bedroom.checkIn(guest1);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void canCheckInGuestShowsRoomNumber() {
        bedroom.checkIn(guest1);
        assertEquals("101", guest1.getRoomNumber());
    }

    @Test
    public void canCheckInGuestRemovesRoomNumber() {
        bedroom.checkIn(guest1);
        bedroom.checkOut(guest1);
        assertEquals(null, guest1.getRoomNumber());
    }

    @Test
    public void canCheckOutGuest() {
        bedroom.checkIn(guest1);
        bedroom.checkOut(guest1);
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void isFull() {
        bedroom.checkIn(guest1);
        bedroom.checkIn(guest1);
        assertEquals(true, bedroom.isFull());
    }
}
