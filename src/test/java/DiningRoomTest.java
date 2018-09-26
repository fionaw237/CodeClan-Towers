import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;

    @Before
    public void before() {
        diningRoom = new DiningRoom(100);
    }

    @Test
    public void hasCapacity() {
        assertEquals(100, diningRoom.getCapacity());
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, diningRoom.guestCount());
    }

}
