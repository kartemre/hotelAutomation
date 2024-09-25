/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2221221702_zeynepsude_yılmaz_bp2_proje;


// Room class
class Room {
    private int roomNumber;
    private int capacity;
    private double price;
    private boolean isOccupied;
    private boolean isClean;

    public Room(int roomNumber, int capacity, double price) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isOccupied = false; // Initially, the room is not occupied
        this.isClean = true; // Initially, the room is clean
    }

    // Getter and setter methods
    // ...

    // Method to book the room
    public void bookRoom() {
        if (!isOccupied) {
            isOccupied = true;
            System.out.println("Room " + roomNumber + " has been booked.");
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }

    // Method to free the room
    public void freeRoom() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Room " + roomNumber + " has been freed.");
        } else {
            System.out.println("Room " + roomNumber + " is already free.");
        }
    }

    // Method to clean the room
    public void cleanRoom() {
        if (!isClean) {
            isClean = true;
            System.out.println("Room " + roomNumber + " has been cleaned.");
        } else {
            System.out.println("Room " + roomNumber + " is already clean.");
        }
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Capacity: " + capacity);
        System.out.println("Price: $" + price + " per night");
        System.out.println("Occupied: " + (isOccupied ? "Yes" : "No"));
        System.out.println("Clean: " + (isClean ? "Yes" : "No"));
    }

    // Other utility methods
    // ...
}

// StandardRoom class inherits from Room
class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber, 2, 100); // Default capacity and price for a standard room
    }
}

// SuiteRoom class inherits from Room
class SuiteRoom extends Room {
    public SuiteRoom(int roomNumber) {
        super(roomNumber, 4, 200); // Default capacity and price for a suite room
    }
}
