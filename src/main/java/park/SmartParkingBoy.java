package park;

import java.util.List;
import java.util.Map;

public class SmartParkingBoy implements ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Map<ParkTicket, ParkingLot> ticketPark;

    public SmartParkingBoy(List<ParkingLot> parkingLots, Map<ParkTicket, ParkingLot> ticketPark) {
        this.parkingLots = parkingLots;
        this.ticketPark = ticketPark;
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

    public List<ParkingLot> getPakingLots() {
        return parkingLots;
    }

    public int manageSeats() {
        int manageSeats = 0;
        for (ParkingLot parkingLot : parkingLots) {
            manageSeats = parkingLot.getCapacity();
        }
        return manageSeats;
    }

    public int pakingCarAmount() {
        int pakingCarAmount = 0;
        for (ParkingLot parkingLot : parkingLots) {
            pakingCarAmount = parkingLot.pakingCarNumber();
        }
        return pakingCarAmount;
    }
}
