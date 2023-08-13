package ParkingSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParkingSystem {
    private List<ParkingSpot> parkingSpots;
    private Map<String, List<ParkingSpot>> bookings;

    public ParkingSystem(int totalSpots) {
        parkingSpots = new ArrayList<>();
        bookings = new HashMap<>();
        for (int i = 1; i <= totalSpots; i++) {
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    public void displayBookings(String username) {
        List<ParkingSpot> userBookings = bookings.getOrDefault(username, new ArrayList<>());
        if (userBookings.isEmpty()) {
            System.out.println("You have no booked slots.");
        } else {
            System.out.println("Your Booked Slots:");
            for (ParkingSpot spot : userBookings) {
                System.out.println("Spot Number: " + spot.getSpotNumber());
            }
        }
    }

    public void showAvailableParkingSpots() {
        System.out.println("Available Parking Spots:");
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                System.out.println("Spot Number: " + spot.getSpotNumber());
            }
        }
    }

    public boolean bookParkingSpot(String username, int spotNumber) {
        ParkingSpot spotToBook = null;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                spotToBook = spot;
                break;
            }
        }

        if (spotToBook == null) {
            System.out.println("Invalid spot number. Please try again.");
            return false;
        }

        if (!spotToBook.isAvailable()) {
            System.out.println("Spot " + spotNumber + " is already booked. Please choose another spot.");
            return false;
        }

        spotToBook.book();
        bookings.computeIfAbsent(username, k -> new ArrayList<>()).add(spotToBook);

        System.out.println("Booking successful! You have booked spot number " + spotNumber + ".");
        return true;
    }

    public boolean releaseParkingSpot(String username, int spotNumber) {
        List<ParkingSpot> userBookings = bookings.get(username);
        if (userBookings == null || userBookings.isEmpty()) {
            System.out.println("You have no booked slots to release.");
            return false;
        }

        ParkingSpot spotToRelease = null;
        for (ParkingSpot spot : userBookings) {
            if (spot.getSpotNumber() == spotNumber) {
                spotToRelease = spot;
                break;
            }
        }

        if (spotToRelease == null) {
            System.out.println("You have not booked the specified spot.");
            return false;
        }

        spotToRelease.release();
        userBookings.remove(spotToRelease);

        System.out.println("Slot released successfully.");
        return true;
    }

    public boolean login(String username, String password) {
        // In a real implementation, you'd compare against stored users' data.
        // For simplicity, we assume any username and password is valid.
        return true;
    }
}

// class "ParkingSystem" end
