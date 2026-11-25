public class Allocation {
    String studentId;
    String studentName;
    String roomId;

    public Allocation(String studentId, String studentName, String roomId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.roomId = roomId;
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Room ID: " + roomId);
    }
}
