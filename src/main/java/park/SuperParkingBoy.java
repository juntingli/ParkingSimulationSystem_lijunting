package park;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperParkingBoy implements ParkingBoy {
    private final List<ParkingLot> parkingLots;
    private Map<ParkTicket, ParkingLot> ticketPark;

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.ticketPark = new HashMap<>();
    }

    @Override
    public ParkTicket park(Car car) {
        double maxSeatRate = 0;
        ParkingLot maxRemainSeatRateParkingLot = new ParkingLot(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.RemainSeatRate() > maxSeatRate) {
                maxSeatRate = parkingLot.RemainSeatRate();
                maxRemainSeatRateParkingLot = parkingLot;
            }
        }
        ParkTicket parkTicket = maxRemainSeatRateParkingLot.park(car);
        ticketPark.put(parkTicket, maxRemainSeatRateParkingLot);
        return parkTicket;
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

    public int pakingCarAmount() {
        int pakingCarAmount = 0;
        for (ParkingLot parkingLot : parkingLots) {
            pakingCarAmount = pakingCarAmount + parkingLot.pakingCarNumber();
        }
        return pakingCarAmount;
    }
}
