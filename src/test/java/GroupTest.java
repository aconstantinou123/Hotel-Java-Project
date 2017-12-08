import Guest.Group;
import Guest.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {

    Group group1;
    Guest guest1;

    @Before
    public void before(){
        group1 = new Group();
        guest1 = new Guest("Alex", 200.0);
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
}
