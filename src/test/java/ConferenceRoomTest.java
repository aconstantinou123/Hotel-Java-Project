import Guest.Group;
import Guest.Guest;
import Rooms.ConferenceRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom1;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Group group1;
    Hotel hotel1;

    @Before
    public void before(){
        conferenceRoom1 = new ConferenceRoom(20, 200.0, "None");
        group1 = new Group();
        guest1 = new Guest("Alex", 200.0);
        guest2 = new Guest("Jack", 200.0);
        guest3 = new Guest("Lacey", 200.0);
        guest4 = new Guest("Randy", 200.0);
        hotel1 = new Hotel("CodeClan Towers");
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        group1.addGuest(guest3);
        group1.addGuest(guest4);
        hotel1.addConferenceRoom(conferenceRoom1);
    }

    @Test
    public void canGetCurrentUse() {
        assertEquals("None", conferenceRoom1.getCurrentUse());
    }

    @Test
    public void canSetCurrentUse() {
        conferenceRoom1.setCurrentUse("Business Meeting");
        assertEquals("Business Meeting", conferenceRoom1.getCurrentUse());
    }

    @Test
    public void canGetIstOccupied() {
        assertEquals(false, conferenceRoom1.getIsInUse());
    }

    @Test
    public void canSetIsOccupied() {
        conferenceRoom1.setIsInUse(true);
        assertEquals(true, conferenceRoom1.getIsInUse());
    }

    @Test
    public void guestsCanBookConferenceRoom() {
        hotel1.bookConferenceRoom(conferenceRoom1, group1, "Business Meeting");
        assertEquals(4, conferenceRoom1.numberOfGuestsInRoom());
        assertEquals("Business Meeting", conferenceRoom1.getCurrentUse());
        assertEquals(150.0, guest1.getWallet(), 0.1);
        assertEquals(200, hotel1.getMoneyMade(), 0.1);
    }

    @Test
    public void guestsCanLeaveConferenceRoom() {
        hotel1.bookConferenceRoom(conferenceRoom1, group1, "Business Meeting");
        hotel1.leaveConferenceRoom(conferenceRoom1);
        assertEquals(0, conferenceRoom1.numberOfGuestsInRoom());
        assertEquals("None", conferenceRoom1.getCurrentUse());
    }

    @Test
    public void canSeeConferenceRoomActivity() {
        hotel1.bookConferenceRoom(conferenceRoom1, group1, "Business Meeting");
        assertEquals("The conference room is currently being used by 4 guests for a Business Meeting",
                hotel1.viewConferenceRoomActivity());
    }

    @Test
    public void canSeeConferenceRoomActivity_none() {
        assertEquals("The conference room is currently empty",
                hotel1.viewConferenceRoomActivity());
    }
}
