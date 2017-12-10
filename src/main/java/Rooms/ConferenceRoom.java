package Rooms;

    

import Guest.Group;

public class ConferenceRoom extends Room {
    
    protected String currentUse;
    protected Double price;
    protected boolean isInUse;
    
    public ConferenceRoom(int capacity, Double price, String currentUse) {
        super(capacity);
        this.currentUse = currentUse;
        this.price = price;
        this.isInUse = false;
        
    }

    public String getCurrentUse() {
        return currentUse;
    }

    public Double getPrice() {
        return price;
    }

    public void setCurrentUse(String currentUse) {
        this.currentUse = currentUse;
    }

    public boolean getIsInUse() {
        return isInUse;
    }

    public void setIsInUse(boolean isInUse) {
        this.isInUse = isInUse;
    }

    public void addGroup(Group group){
        this.getGuestsInRoom().addAll(group.getGuestsList());
    }

    public void removeGuests() {
        this.getGuestsInRoom().clear();
    }

}
