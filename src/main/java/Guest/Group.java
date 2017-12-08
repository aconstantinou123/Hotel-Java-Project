package Guest;

import Rooms.Bedroom;

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

    public boolean enoughMoneyForRoom(Bedroom bedroom) {
        boolean result = false;
        Double totalMoney = totalGuestMoney();
        if (totalMoney >= bedroom.getPrice()){
            result = true;
        }
        return result;
    }

    public void deductMoney(Bedroom bedroom) {
        int numberOfGuests = guests.size();
        Double pricePerPerson = bedroom.getPrice() / numberOfGuests;
            for (Guest guest : guests) {
                Double wallet = guest.getWallet();
                wallet -= pricePerPerson;
                guest.setWallet(wallet);
            }
    }
}

