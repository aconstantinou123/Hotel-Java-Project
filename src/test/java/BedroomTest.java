import Rooms.Bedroom;
import Rooms.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom1;

    @Before
    public void before() {
        bedroom1 = new Bedroom(RoomType.SINGLE, 80.0, 2);
    }

    @Test
    public void canGetType() {
        assertEquals(RoomType.SINGLE, bedroom1.getType());
    }

    @Test
    public void canSetType() {
        bedroom1.setType(RoomType.PENTHOUSE);
        assertEquals(RoomType.PENTHOUSE, bedroom1.getType());
    }

    @Test
    public void canGetPrice() {
        assertEquals(80.0, bedroom1.getPrice(), 0.01);
    }

    @Test
    public void canSetPrice() {
        bedroom1.setPrice(100.0);
        assertEquals(100.0, bedroom1.getPrice(),0.01);
    }

}
