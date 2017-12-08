package Rooms;

public enum RoomType {
    SINGLE("Single"),
    DOUBLE("Double"),
    SUPERIORSINGLE("Superior Single"),
    SUPERIORDOUBLE("Superior Double"),
    PENTHOUSE("Penthouse");

    private final String type;

    RoomType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
