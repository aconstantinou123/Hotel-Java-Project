import Rooms.*;

import java.util.ArrayList;

public class Hotel {

    private String hotelName;
    private ArrayList<Room> rooms;
    private Double moneyMade;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<Room>();
        this.moneyMade = 0.0;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getNumberofRooms() {
        return rooms.size();
    }

    public Double getMoneyMade() {
        return moneyMade;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void removeRoom(Room room) {
        this.rooms.remove(room);
    }
}
