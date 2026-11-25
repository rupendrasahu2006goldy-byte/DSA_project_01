public class Room {
    String id;
    int capacity;
    int occupied;
    boolean available;

    public Room(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.occupied = 0;
        this.available = true;
    }

    public void occupyRoom() {
        if (occupied < capacity) {
            occupied++;
        }

        if (occupied >= capacity) {
            available = false;
        }
    }
}
