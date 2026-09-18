import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     MOVIE TICKET BOOKING");
        System.out.println("================================");

        System.out.println("1. View Movies");
        System.out.println("2. Book Ticket");
        System.out.println("3. Cancel Ticket");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Viewing movies...");
                break;

            case 2:
                System.out.println("Booking ticket...");
                break;

            case 3:
                System.out.println("Cancelling ticket...");
                break;

            case 4:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}