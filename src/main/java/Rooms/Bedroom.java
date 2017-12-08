package Rooms;

public class Bedroom extends Room {

    protected RoomType roomType;
    protected Double pricePerNight;
    protected boolean IsOccupied;

    public Bedroom(RoomType roomtype, Double pricePerNight, int capacity) {
        super(capacity);
        this.roomType = roomtype;
        this.pricePerNight = pricePerNight;
        this.IsOccupied = false;

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
}
