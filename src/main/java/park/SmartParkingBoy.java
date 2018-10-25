package park;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartParkingBoy implements ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Map<ParkTicket, ParkingLot> ticketPark;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.ticketPark = new HashMap();
    }

    @Override
    public ParkTicket park(Car car) {
        int maxSeats = 0;
        ParkingLot maxRemainSeatsParkingLot = new ParkingLot(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.RemainSeats() > maxSeats) {
                maxSeats = parkingLot.RemainSeats();
                maxRemainSeatsParkingLot = parkingLot;
            }
        }
        ParkTicket parkTicket = maxRemainSeatsParkingLot.park(car);
        ticketPark.put(parkTicket, maxRemainSeatsParkingLot);
        return parkTicket;
    }

    @Override
    public Car pickUp(ParkTicket parkTicket) {
        ParkingLot parkingLot = ticketPark.get(parkTicket);
        return parkingLot.pickUp(parkTicket);
    }

    @Override
    public int manageSeats() {
        int manageSeats = 0;
        for (ParkingLot parkingLot : parkingLots) {
            manageSeats = parkingLot.getCapacity();
        }
        return manageSeats;
    }

    @Override
    public int parkingCarAmount() {
        int parkingCarAmount = 0;
        for (ParkingLot parkingLot : parkingLots) {
            parkingCarAmount = parkingLot.parkingCarNumber();
        }
        return parkingCarAmount;
    }
}
