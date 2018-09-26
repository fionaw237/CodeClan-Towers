public class Guest {

    private String name;
    private String roomNumber;
    private int numberOfNights;

    public Guest(String name) {
        this.name = name;
        this.roomNumber = null;
        this.numberOfNights = 0;
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

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
}
