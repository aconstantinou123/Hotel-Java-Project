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

    public String getGuestNames() {
        ArrayList<String> guestNames = new ArrayList<>();
        for(Guest guest : guestsInRoom){
            guestNames.add(guest.getName());
        }
        String result = String.join(" and ", guestNames);
        return result;
    }



    public int numberOfGuestsInRoom() {
        return this.guestsInRoom.size();
    }

}
