package park;

import java.util.HashMap;

public class ParkingLot {

    private HashMap<ParkTicket, Car> parkTicketCarHashMap;

    private int capacity;

    public ParkingLot(int capacity) {
        parkTicketCarHashMap = new HashMap<>();
        this.capacity = capacity;
    }

    public ParkTicket park(Car car) {
        if (parkTicketCarHashMap.size() >= capacity) {
            throw new IndexOutOfBoundsException("Parking Lot Is Full!");
        }
        ParkTicket parkTicket = new ParkTicket();
        parkTicketCarHashMap.put(parkTicket, car);
        return parkTicket;
    }

    public Car pickUp(ParkTicket parkTicket) {
        return parkTicketCarHashMap.remove(parkTicket);
    }

    public boolean isIn(ParkTicket parkTicket) {
        return parkTicketCarHashMap.containsKey(parkTicket);
    }

    public boolean isFull() {
        return parkTicketCarHashMap.size() == capacity;
    }

    public int RemainSeats() {
        return capacity - parkTicketCarHashMap.size();
    }

    public double RemainSeatRate() {
        return (capacity - parkTicketCarHashMap.size()) * 1.0 / capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int parkingCarNumber() {
        return parkTicketCarHashMap.size();
    }
}
