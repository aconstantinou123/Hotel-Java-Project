import Guest.Group;
import Guest.Guest;
import Rooms.Bedroom;
import Rooms.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom1;
    Group group1;
    Guest guest1;
    Guest guest2;

    @Before
    public void before() {
        bedroom1 = new Bedroom(RoomType.SINGLE, 80.0, 2);
        guest1 = new Guest("Lacey", 300.0);
        guest2 = new Guest("Alex", 20.0);
        group1 = new Group();
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

    @Test
    public void canGetIsOccupued() {
        assertEquals(false, bedroom1.getIsOccupied());
    }

    @Test
    public void canSetIsOccupied() {
        bedroom1.setIsOccupied(true);
        assertEquals(true, bedroom1.getIsOccupied());
    }

    @Test
    public void canAddGroupToRoom() {
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        bedroom1.addGroup(group1);
        assertEquals(2, bedroom1.numberOfGuestsInRoom());
    }

    @Test
    public void canRemoveGroupToRoom() {
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        bedroom1.addGroup(group1);
        bedroom1.removeGuests();
        assertEquals(0, bedroom1.numberOfGuestsInRoom());

    }

}
