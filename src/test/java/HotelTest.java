import Rooms.*;
import Guest.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class HotelTest {

    Hotel hotel1;
    Hotel hotel2;
    Room room1;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    Bedroom bedroom4;
    Bedroom bedroom5;
    Group group1;
    Group group2;
    Group group3;
    Group group4;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Guest guest5;
    Guest guest6;


    @Before
    public void before() {
        hotel1 = new Hotel("Club Tropicana");
        hotel2 = new Hotel("The Great Northern");
        bedroom1 = new Bedroom(RoomType.SINGLE, 80.0, 101, 2);
        bedroom2 = new Bedroom(RoomType.DOUBLE, 200.0, 102, 2);
        bedroom3 = new Bedroom(RoomType.PENTHOUSE, 300.0, 103, 4);
        bedroom4 = new Bedroom(RoomType.SINGLE, 300.0, 104, 2);
        bedroom5 = new Bedroom(RoomType.DOUBLE, 300.0, 105, 2);
        guest1 = new Guest("Lacey", 300.0);
        guest2 = new Guest("Alex", 120.0);
        guest3 = new Guest("Bill", 220.0);
        guest4 = new Guest("Steve", 120.0);
        guest5 = new Guest("Jenny", 300.0);
        guest6 = new Guest("Sarah", 300.0);
        group1 = new Group();
        group2 = new Group();
        group3 = new Group();
        group4 = new Group();

        hotel2.addBedRoom(bedroom1);
        hotel2.addBedRoom(bedroom2);
        hotel2.addBedRoom(bedroom3);
        hotel2.addBedRoom(bedroom4);
        hotel2.addBedRoom(bedroom5);
        group2.addGuest(guest1);
        group2.addGuest(guest2);
        group3.addGuest(guest3);
        group3.addGuest(guest4);
        group4.addGuest(guest5);
        group4.addGuest(guest6);
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
    public void canAddBedRoom(){
        hotel1.addBedRoom(bedroom1);
        assertEquals(1, hotel1.getNumberofRooms());
    }

    @Test
    public void canRemoveBedRoom(){
        hotel1.addBedRoom(bedroom1);
        hotel1.removeBedRoom(bedroom1);
        assertEquals(0, hotel1.getNumberofRooms());
    }

    @Test
    public void canCheckInGuests() {
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        hotel1.checkIn(bedroom1, group1, 2);
        assertEquals(2, bedroom1.numberOfGuestsInRoom());
        assertEquals(220.0, guest1.getWallet(), 0.1);
        assertEquals(true, bedroom1.getIsOccupied());
        assertEquals(160.0, hotel1.getMoneyMade(), 0.1);
        assertEquals(0, group1.getGuestsNumber());

    }

    @Test
    public void canCheckOutGuests() {
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        hotel1.checkIn(bedroom1, group1, 2);
        hotel1.checkOut(bedroom1, group1);
        assertEquals(0, bedroom1.numberOfGuestsInRoom());
        assertEquals(false, bedroom1.getIsOccupied());
        assertEquals(false, guest1.getCheckedInStatus());
        assertEquals(false, guest2.getCheckedInStatus());
    }

    @Test
    public void canSeeTotalNumberOfGuests() {
        hotel2.checkIn(bedroom1, group2, 1);
        hotel2.checkIn(bedroom2, group3, 1);
        hotel2.checkIn(bedroom3, group4, 1);
        assertEquals(6, hotel2.totalNumberOfGuests());
    }

    @Test
    public void canAllInfo() {
        hotel2.checkIn(bedroom1, group2, 1);
        hotel2.checkIn(bedroom2, group3,1);
        hotel2.checkIn(bedroom3, group4,1);
        assertEquals("Room 101 is currently occupied by 2 people for 1 night(s)\n" +
                "Guest names: Lacey and Alex\n" +
                "\n" +
                "Room 102 is currently occupied by 2 people for 1 night(s)\n" +
                "Guest names: Bill and Steve\n" +
                "\n" +
                "Room 103 is currently occupied by 2 people for 1 night(s)\n" +
                "Guest names: Jenny and Sarah\n" +
                "\n" +
                "Room 104 is currently unoccupied\n" +
                "\n" +
                "Room 105 is currently unoccupied\n\n", hotel2.allRoomInfo());
    }

    @Test
    public void canAllInfo_Unoccupied() {
        hotel2.checkIn(bedroom1, group2,1);
        hotel2.checkIn(bedroom3, group4,1);
        assertEquals("Room 101 is currently occupied by 2 people for 1 night(s)\n" +
                "Guest names: Lacey and Alex\n" +
                "\n" +
                "Room 102 is currently unoccupied\n" +
                "\n" +
                "Room 103 is currently occupied by 2 people for 1 night(s)\n" +
                "Guest names: Jenny and Sarah\n" +
                "\n" +
                "Room 104 is currently unoccupied\n" +
                "\n" +
                "Room 105 is currently unoccupied\n\n", hotel2.allRoomInfo());
    }

    @Test
    public void canSeeUnoccupiedRooms(){
        hotel2.checkIn(bedroom1, group2, 1);
        hotel2.checkIn(bedroom3, group4,1);
        assertEquals("Room 102 - Double\n" +
                "Room 104 - Single\n" +
                "Room 105 - Double\n", hotel2.unoccupiedRooms());
    }
    
}
