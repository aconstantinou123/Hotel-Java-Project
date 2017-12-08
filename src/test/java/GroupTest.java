import Guest.Group;
import Guest.Guest;
import Rooms.Bedroom;
import Rooms.Room;
import Rooms.RoomType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {

    Group group1;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Bedroom bedroom1;

    @Before
    public void before(){
        group1 = new Group();
        guest1 = new Guest("Alex", 200.0);
        guest2 = new Guest("Tim", 150.0);
        guest3 = new Guest("Bill", 20.0);
        bedroom1 = new Bedroom(RoomType.PENTHOUSE, 100.0, 101, 2);
    }

    @Test
    public void canGetNumberOfGuests(){
        assertEquals(0, group1.getGuestsNumber());
    }

    @Test
    public void canAddGuestsToGroup(){
        group1.addGuest(guest1);
        assertEquals(1, group1.getGuestsNumber());
    }

    @Test
    public void canRemoveGuests(){
        group1.addGuest(guest1);
        group1.removeAll();
        assertEquals(0, group1.getGuestsNumber());
    }

    @Test
    public void canCheckRoomCapacity__True(){
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        assertEquals(true, group1.checkCapacity(bedroom1));

    }

    @Test
    public void canCheckRoomCapacity__False(){
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        group1.addGuest(guest3);
        assertEquals(false, group1.checkCapacity(bedroom1));

    }

    @Test
    public void canGetTotalGuestMoney(){
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        group1.addGuest(guest3);
        assertEquals(370.0, group1.totalGuestMoney(), 0.1);
    }

    @Test
    public void canCheckGuestMoneyVsRoomPrice_True(){
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        group1.addGuest(guest3);
        assertEquals(true, group1.enoughMoneyForRoom(bedroom1, 2));
    }

    @Test
    public void canCheckGuestMoneyVsRoomPrice_False(){
        group1.addGuest(guest3);
        assertEquals(false, group1.enoughMoneyForRoom(bedroom1, 2));
    }

    @Test
    public void canDeductMoney(){
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        group1.deductMoney(bedroom1, 2);
        assertEquals(100.0, guest1.getWallet(), 0.1);
        assertEquals(50.0, guest2.getWallet(), 0.1);
    }

    @Test
    public void allGuestsCheckedIn(){
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        group1.checkInAllGuests();
        assertEquals(true, guest1.getCheckedInStatus());
        assertEquals(true, guest2.getCheckedInStatus());
    }


}
