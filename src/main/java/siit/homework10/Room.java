package siit.homework10;

public class Room {

    private int roomPrice;
    private String roomType;

    public Room(int roomPrice, String roomType) {
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return
                 roomPrice + " " +
                 roomType ;

    }
}
