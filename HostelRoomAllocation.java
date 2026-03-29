import java.util.*;

class Student {
    String name;
    String regNo;
    int roomNo;

    Student(String name, String regNo, int roomNo) {
        this.name = name;
        this.regNo = regNo;
        this.roomNo = roomNo;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Registration No: " + regNo);
        System.out.println("Allocated Room: " + roomNo);
        System.out.println("------------------------");
    }
}

public class HostelRoomAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> hostel = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Allocate Room");
            System.out.println("2. View Allocated Rooms");
            System.out.println("3. Check Vacant Room");
            System.out.println("4. Remove Allocation");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Registration Number: ");
                    String regNo = sc.nextLine();

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    boolean occupied = false;

                    for (Student s : hostel) {
                        if (s.roomNo == roomNo) {
                            occupied = true;
                            break;
                        }
                    }

                    if (occupied) {
                        System.out.println("Room already occupied.");
                    } else {
                        hostel.add(new Student(name, regNo, roomNo));
                        System.out.println("Room allocated successfully.");
                    }
                    break;

                case 2:
                    for (Student s : hostel) {
                        s.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int checkRoom = sc.nextInt();

                    boolean found = false;

                    for (Student s : hostel) {
                        if (s.roomNo == checkRoom) {
                            System.out.println("Room is occupied.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Room is vacant.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Registration Number: ");
                    String removeReg = sc.nextLine();

                    hostel.removeIf(s -> s.regNo.equals(removeReg));
                    System.out.println("Allocation removed.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}