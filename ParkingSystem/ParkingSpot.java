package ParkingSystem;

// class "ParkingSpot" start

class ParkingSpot {
    private int spotNumber;
    private boolean isAvailable;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isAvailable = true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        isAvailable = false;
    }

    public void release() {
        isAvailable = true;
    }
}

// class "ParkingSpot" end