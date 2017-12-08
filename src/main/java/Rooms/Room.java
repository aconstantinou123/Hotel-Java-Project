package Rooms;
import Guest.Guest;

import java.util.ArrayList;

public class Room {

    int capacity;
    ArrayList<Guest> guestsInRoom;

    public Room(int capacity){

        this.capacity = capacity;
        this.guestsInRoom = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
}
