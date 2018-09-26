import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;
    Guest guest1;

    @Before
    public void before() {
        diningRoom = new DiningRoom(100);
        guest1 = new Guest("John Mike");
    }

    @Test
    public void hasCapacity() {
        assertEquals(100, diningRoom.getCapacity());
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, diningRoom.guestCount());
    }

    @Test
    public void canCheckInGuest() {
        diningRoom.checkIn(guest1);
        assertEquals(1, diningRoom.guestCount());
    }

    @Test
    public void canCheckOutGuest() {
        diningRoom.checkIn(guest1);
        diningRoom.checkOut(guest1);
        assertEquals(0, diningRoom.guestCount());
    }

    @Test
    public void isFull() {
        DiningRoom smallRoom = new DiningRoom(2);
        smallRoom.checkIn(guest1);
        smallRoom.checkIn(guest1);
        assertEquals(true, smallRoom.isFull());
    }

    @Test
    public void cannotAddMoreGuestsIfRoomFull() {
        DiningRoom smallRoom = new DiningRoom(2);
        smallRoom.checkIn(guest1);
        smallRoom.checkIn(guest1);
        smallRoom.checkIn(guest1);
        assertEquals(2, smallRoom.guestCount());
    }
}

