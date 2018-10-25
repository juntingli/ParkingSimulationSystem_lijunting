package park;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonParkingBoy implements ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Map<ParkTicket, ParkingLot> ticketPark;

    public CommonParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.ticketPark = new HashMap<>();
    }

    @Override
    public ParkTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                ParkTicket parkTicket = parkingLot.park(car);
                ticketPark.put(parkTicket, parkingLot);
                return parkTicket;
            }
        }
        throw new IndexOutOfBoundsException("All Parking Lots Are Full!");
    }

    @Override
    public Car pickUp(ParkTicket parkTicket) {
        ParkingLot parkingLot = ticketPark.get(parkTicket);
        return parkingLot.pickUp(parkTicket);
    }

    public int manageSeats() {
        int manageSeats = 0;
        for (ParkingLot parkingLot : parkingLots) {
            manageSeats = manageSeats + parkingLot.getCapacity();
        }
        return manageSeats;
    }

    public int parkingCarAmount() {
        int pakingCarAmount = 0;
        for (ParkingLot parkingLot : parkingLots) {
            pakingCarAmount = pakingCarAmount + parkingLot.pakingCarNumber();
        }
        return pakingCarAmount;
    }
}
