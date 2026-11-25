import java.util.*;

public class HostelRoomAllocationSystem {

    // Hashing
    HashMap<String, Student> students = new HashMap<>();
    HashMap<String, Room> rooms = new HashMap<>();

    // Priority Queue
    PriorityQueue<Request> requests = new PriorityQueue<>(
        (a, b) -> {
            if (a.priority == b.priority) {
                return a.sequence - b.sequence;
            }
            return b.priority - a.priority;
        }
    );

    // Linked List
    LinkedList<Allocation> allocations = new LinkedList<>();

    int counter = 0;

    // Add Room
    public void addRoom(String id, int capacity) {

        if (rooms.containsKey(id)) {
            System.out.println("Room already exists!");
            return;
        }

        rooms.put(id, new Room(id, capacity));

        System.out.println("Room Added Successfully!");
    }

    // Register Student
    public void registerStudent(String id, String name, int capacity) {

        if (students.containsKey(id)) {
            System.out.println("Student already exists!");
            return;
        }

        students.put(id, new Student(id, name, capacity));

        System.out.println("Student Registered Successfully!");
    }

    // Submit Request
    public void submitRequest(String studentId, int priority) {

        Student student = students.get(studentId);

        if (student == null) {
            System.out.println("Student Not Found!");
            return;
        }

        if (priority < 1 || priority > 5) {
            System.out.println("Priority must be between 1 and 5!");
            return;
        }

        requests.add(new Request(student, priority, counter++));

        System.out.println("Request Added Successfully!");
    }

    // Greedy Room Allocation
    public void allocateRoom() {

        if (requests.isEmpty()) {
            System.out.println("No Pending Requests!");
            return;
        }

        Request request = requests.poll();

        Room bestRoom = null;

        for (Room room : rooms.values()) {

            if (room.available &&
                room.occupied < room.capacity &&
                room.capacity >= request.student.requiredCapacity) {

                if (bestRoom == null ||
                    room.capacity < bestRoom.capacity) {

                    bestRoom = room;
                }
            }
        }

        if (bestRoom == null) {
            System.out.println("No Suitable Room Available!");
            return;
        }

        bestRoom.occupyRoom();

        Allocation allocation = new Allocation(
            request.student.id,
            request.student.name,
            bestRoom.id
        );

        allocations.add(allocation);

        System.out.println("Room Allocated Successfully!");
        System.out.println("Student: " + request.student.name);
        System.out.println("Room: " + bestRoom.id);
    }

    // Display Rooms
    public void displayRooms() {

        for (Room room : rooms.values()) {

            System.out.println("Room ID: " + room.id);
            System.out.println("Capacity: " + room.capacity);
            System.out.println("Occupied: " + room.occupied);
            System.out.println("Available: " + room.available);

            System.out.println("------------------");
        }
    }

    // Display Allocations
    public void displayAllocations() {

        if (allocations.isEmpty()) {
            System.out.println("No Allocations Found!");
            return;
        }

        for (Allocation allocation : allocations) {
            allocation.display();
            System.out.println("------------------");
        }
    }

    // Display Pending Requests
    public void displayRequests() {

        PriorityQueue<Request> temp =
            new PriorityQueue<>(requests);

        while (!temp.isEmpty()) {

            Request r = temp.poll();

            System.out.println("Student: " + r.student.name);
            System.out.println("Priority: " + r.priority);
        }
    }
}
