public class Guest {

    private String name;
    private String roomNumber;

    public Guest(String name) {
        this.name = name;
        this.roomNumber = null;
    }

    public String getName() {
        return name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
