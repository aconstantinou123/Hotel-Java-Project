import Guest.Guest;
import Guest.Group;
import Rooms.Restaurant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RestaurantTest {

    Restaurant restaurant1;
    Guest guest1;
    Guest guest2;
    Guest guest3;
    Guest guest4;
    Guest guest5;
    Guest guest6;
    Group group1;
    Group group2;
    Hotel hotel1;

    @Before
    public void before() {
        restaurant1 = new Restaurant(20, "Mexican");
        guest1 = new Guest("Martha", 500.0);
        guest2 = new Guest("Mable", 500.0);
        guest3 = new Guest("Mary", 500.0);
        guest4 = new Guest("Matilda", 500.0);
        guest4 = new Guest("Madonna", 500.0);
        guest4 = new Guest("Margaret", 500.0);
        group1 = new Group();
        group2 = new Group();
        hotel1 = new Hotel("The Dragonfly Inn");
        group1.addGuest(guest1);
        group1.addGuest(guest2);
        group1.addGuest(guest3);
        group1.addGuest(guest4);
        group2.addGuest(guest5);
        group2.addGuest(guest6);
    }

    @Test
    public void canGetCurrentMenu(){
        assertEquals("Mexican", restaurant1.getCurrentMenu());
    }

    @Test
    public void canSetCurrentMenu(){
        restaurant1.setMenu("Indian");
        assertEquals("Indian", restaurant1.getCurrentMenu());
    }

    @Test
    public void canGetTablesBooked() {
        assertEquals(0, restaurant1.getTablesBooked());
    }

    @Test
    public void canSetTablesBooked() {
        restaurant1.setTablesBooked(1);
        assertEquals(1, restaurant1.getTablesBooked());
    }

    @Test
    public void canAddRestaurantToHotel() {
        hotel1.addRestaurant(restaurant1);
        assertEquals(1, hotel1.getNumberofRestaurants());
    }

    @Test
    public void canRemoveRestaurantFromHotel() {
        hotel1.addRestaurant(restaurant1);
        hotel1.removeRestaurant(restaurant1);
        assertEquals(0, hotel1.getNumberofRestaurants());
    }

    @Test
    public void canBookTable() {
        hotel1.addRestaurant(restaurant1);
        hotel1.bookRestaurant(group1, restaurant1, 1);
        assertEquals(4, restaurant1.numberOfGuestsInRoom());
        assertEquals(1, restaurant1.getTablesBooked());
    }

    @Test
    public void canBookTable_2() {
        hotel1.addRestaurant(restaurant1);
        hotel1.bookRestaurant(group1, restaurant1, 1);
        hotel1.bookRestaurant(group2, restaurant1, 1);
        assertEquals(6, restaurant1.numberOfGuestsInRoom());
        assertEquals(2, restaurant1.getTablesBooked());
    }

    @Test
    public void canCancelTable() {
        hotel1.addRestaurant(restaurant1);
        hotel1.bookRestaurant(group1, restaurant1, 1);
        hotel1.bookRestaurant(group2, restaurant1, 1);
        hotel1.cancelTable(group2, restaurant1, 1);
        assertEquals(4, restaurant1.numberOfGuestsInRoom());
        assertEquals(1, restaurant1.getTablesBooked());
    }
}
