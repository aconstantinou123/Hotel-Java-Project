package Rooms;
import Guest.Guest;

import java.util.ArrayList;

public class Room {

    int capacity;
    protected ArrayList<Guest> guestsInRoom;

    public Room(int capacity){

        this.capacity = capacity;
        this.guestsInRoom = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Guest> getGuestsInRoom() {
        return guestsInRoom;
    }


    public int numberOfGuestsInRoom() {
        return this.guestsInRoom.size();
    }

}
