package ParkingSystem;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingSystem parkingSystem = new ParkingSystem(20); // 10 parking spots available

        System.out.println("Welcome to the Treue Tech Parking System!");
        System.out.print("Please Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Please Enter your password: ");
        String password = scanner.nextLine();

        if (parkingSystem.login(username, password)) {
            System.out.println("Login successful!");

            boolean running = true;
            while (running) {
                System.out.println("\n------ Dashboard ------");
                System.out.println("1. Your Booked Slots");
                System.out.println("2. Book a New Slot");
                System.out.println("3. Remove a Slot");
                System.out.println("4. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        parkingSystem.displayBookings(username);
                        break;
                    case 2:
                        parkingSystem.showAvailableParkingSpots();
                        System.out.print("Enter the spot number to book: ");
                        int spotNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        boolean bookingStatus = parkingSystem.bookParkingSpot(username, spotNumber);
                        if (bookingStatus) {
                            System.out.println("Your Booking is successful!");
                        } else {
                            System.out.println("Failed to book the spot. Please try again later...");
                        }
                        break;
                    case 3:
                        parkingSystem.displayBookings(username);
                        System.out.print("Enter the slot number to release: ");
                        int spotToRelease = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        boolean releaseStatus = parkingSystem.releaseParkingSpot(username, spotToRelease);
                        if (releaseStatus) {
                            System.out.println("Slot released successfully!");
                        } else {
                            System.out.println("Failed to release the slot. Please try again.");
                        }
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }

        scanner.close();
    }
}