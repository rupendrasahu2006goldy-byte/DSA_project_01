import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HostelRoomAllocationSystem system =
            new HostelRoomAllocationSystem();

        int choice;

        do {

            System.out.println("\n===== HOSTEL ROOM ALLOCATION SYSTEM =====");

            System.out.println("1. Add Room");
            System.out.println("2. Register Student");
            System.out.println("3. Submit Request");
            System.out.println("4. Allocate Room");
            System.out.println("5. Display Rooms");
            System.out.println("6. Display Allocations");
            System.out.println("7. Display Pending Requests");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Room ID: ");
                    String roomId = sc.nextLine();

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    system.addRoom(roomId, capacity);
                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Required Capacity: ");
                    int required = sc.nextInt();

                    system.registerStudent(id, name, required);
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.nextLine();

                    System.out.print("Enter Priority (1-5): ");
                    int priority = sc.nextInt();

                    system.submitRequest(studentId, priority);
                    break;

                case 4:

                    system.allocateRoom();
                    break;

                case 5:

                    system.displayRooms();
                    break;

                case 6:

                    system.displayAllocations();
                    break;

                case 7:

                    system.displayRequests();
                    break;

                case 0:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
