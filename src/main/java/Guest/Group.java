package Guest;

import java.util.ArrayList;

public class Group {
    private ArrayList<Guest> guests;


    public Group() {
        this.guests = new ArrayList<>();

    }

    public int getGuestsNumber() {
        return guests.size();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeAll() {
        this.guests.clear();
    }
}
