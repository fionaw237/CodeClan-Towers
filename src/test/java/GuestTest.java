import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before() {
        guest = new Guest("John Mike");
    }

    @Test
    public void hasName() {
        assertEquals("John Mike", guest.getName());
    }

    @Test
    public void roomNumberIsNullInitially() {
        assertEquals(null, guest.getRoomNumber());
    }

}
