import Rooms.*;
import Guest.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HotelTest {

    Hotel hotel1;
    Room room1;
    Bedroom bedroom1;
    Group group1;
    Guest guest1;
    Guest guest2;


    @Before
    public void before() {
        hotel1 = new Hotel("Club Tropicana");
        bedroom1 = new Bedroom(RoomType.SINGLE, 80.0, 2);
        guest1 = new Guest("Lacey", 300.0);
        guest2 = new Guest("Alex", 20.0);
        group1 = new Group();
    }

    @Test
    public void canGetName() {
        assertEquals("Club Tropicana", hotel1.getHotelName());
    }

    @Test
    public void getNumberofRooms(){
        assertEquals(0, hotel1.getNumberofRooms());
    }

    @Test
    public void getMoneyMade(){
        assertEquals(0.0, hotel1.getMoneyMade(), 0.1);
    }

    @Test
    public void canAddRoom(){
        hotel1.addRoom(bedroom1);
        assertEquals(1, hotel1.getNumberofRooms());
    }

    @Test
    public void canRemoveRoom(){
        hotel1.addRoom(room1);
        hotel1.removeRoom(room1);
        assertEquals(0, hotel1.getNumberofRooms());
    }

    @Test
    public void canCheckInGuests() {
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        hotel1.checkIn(bedroom1, group1);
        assertEquals(2, bedroom1.getCapacity());

    }
}
