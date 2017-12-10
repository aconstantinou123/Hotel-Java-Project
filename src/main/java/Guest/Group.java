package Guest;

import Rooms.Bedroom;
import Rooms.ConferenceRoom;

import java.util.ArrayList;

public class Group {
    private ArrayList<Guest> guests;


    public Group() {
        this.guests = new ArrayList<>();

    }

    public ArrayList<Guest> getGuestsList() {
        return guests;
    }

    public int getGuestsNumber() {
        return guests.size();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public Guest removeGuest(String name) {
        ArrayList<Guest> removedGuest = new ArrayList<>();
        for(Guest guest : guests) {
            if(name == guest.getName()) {
                removedGuest.add(guest);
                guests.remove(guest);
            }
        }
        return removedGuest.get(0);
    }

    public void removeAll() {
        this.guests.clear();
    }

    public boolean checkCapacity(Bedroom bedroom) {
        boolean result = false;
        if (getGuestsNumber() <= bedroom.getCapacity()){
            result = true;
        }
        return result;
    }

    public double totalGuestMoney() {
        Double money = 0.0;
        for (Guest guest : guests){
            money += guest.getWallet();
            }
            return money;
    }

    public boolean enoughMoneyForRoom(Bedroom bedroom, int numberOfNights) {
        boolean result = false;
        Double totalMoney = totalGuestMoney();
        if (totalMoney >= (bedroom.getPrice() * numberOfNights)){
            result = true;
        }
        return result;
    }

    public boolean enoughMoneyForConferenceRoom(ConferenceRoom conferenceRoom) {
        boolean result = false;
        Double totalMoney = totalGuestMoney();
        if (totalMoney >= conferenceRoom.getPrice()) {
            result = true;
        }
        return result;
    }

    public void deductMoney(Bedroom bedroom, int numberOfNights) {
        int numberOfGuests = guests.size();
        Double pricePerPerson = (bedroom.getPrice() * numberOfNights) / numberOfGuests;
            for (Guest guest : guests) {
                Double wallet = guest.getWallet();
                wallet -= pricePerPerson;
                guest.setWallet(wallet);
            }
    }

    public void deductMoneyConferenceRoom(ConferenceRoom conferenceRoom) {
        int numberOfGuests = guests.size();
        Double pricePerPerson = conferenceRoom.getPrice() / numberOfGuests;
        for (Guest guest : guests) {
            Double wallet = guest.getWallet();
            wallet -= pricePerPerson;
            guest.setWallet(wallet);
        }
    }

    public void checkInAllGuests() {
        for(Guest guest : guests){
            guest.setCheckedInStatus(true);
        }
    }

    public Guest findGuest(String guestName) {
        ArrayList<Guest> foundGuest = new ArrayList<>();
        for(Guest guest : guests) {
            if(guestName == guest.getName()) {
                foundGuest.add(guest);
            }
        }
        if (foundGuest.isEmpty()) {
            System.out.println("Guest not found!");
        }
        return foundGuest.get(0);
    }

}

