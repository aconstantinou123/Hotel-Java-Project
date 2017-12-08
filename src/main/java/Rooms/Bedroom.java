package Rooms;

import Guest.Group;

public class Bedroom extends Room {

    protected RoomType roomType;
    protected Double pricePerNight;
    protected boolean isOccupied;

    public Bedroom(RoomType roomtype, Double pricePerNight, int capacity) {
        super(capacity);
        this.roomType = roomtype;
        this.pricePerNight = pricePerNight;
        this.isOccupied = false;

    }

    public RoomType getType() {
        return roomType;
    }

    public void setType(RoomType type) {
        this.roomType = type;
    }

    public double getPrice() {
        return pricePerNight;
    }

    public void setPrice(Double price) {
        this.pricePerNight = price;
    }


    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public void addGroup(Group group){
        this.getGuestsInRoom().addAll(group.getGuestsList());
    }

    public void removeGuests() {
        this.getGuestsInRoom().clear();
    }
}
