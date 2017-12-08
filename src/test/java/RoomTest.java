import Rooms.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room1;

    @Before
    public void before() {
        room1 = new Room(2);
    }

    @Test
    public void canGetCapacity(){
        assertEquals(2,room1.getCapacity());
    }

//    @Test
//    public void getGuestsInRoom() {
//        assertEquals(room1.guestsInRoom, room1.getGuestsInRoom());
//    }

    @Test
    public void canGetGuestsNumber(){
        assertEquals(0, room1.numberOfGuestsInRoom());
    }

}
