package park;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    private final List<ParkingLot> parkingLots;
    private Map<ParkTicket, ParkingLot> ticketPark;
    private Map<ParkTicket, ParkingBoy> ticketBoy;
    private List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.ticketPark = new HashMap<>();
        this.ticketBoy = new HashMap<>();
        this.parkingBoys = new ArrayList<>();
    }

    public void assignParkingLotsToCommonParkingBoy(List<ParkingLot> parkingLots) {
        parkingBoys.add(new CommonParkingBoy(parkingLots));
    }

    public void assignParkingLotsToSmartParkingBoy(List<ParkingLot> parkingLots) {
        parkingBoys.add(new SmartParkingBoy(parkingLots));
    }

    public void assignParkingLotsToSuperParkingBoy(List<ParkingLot> parkingLots) {
        parkingBoys.add(new SuperParkingBoy(parkingLots));
    }

    public ParkTicket personallyPark(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                ParkTicket parkTicket = parkingLot.park(car);
                ticketPark.put(parkTicket, parkingLot);
                return parkTicket;
            }
        }
        throw new IndexOutOfBoundsException("All Parking Lots Are Full!");
    }

    public ParkTicket letCommonParkingBoyToPark(Car car) {
        ParkTicket parkTicket = null;
        for(ParkingBoy parkingBoy : parkingBoys){
            if(null != parkingBoy && parkingBoy instanceof CommonParkingBoy){
                parkTicket = parkingBoy.park(car);
                ticketBoy.put(parkTicket, parkingBoy);
            }
        }
        return parkTicket;
    }

    public ParkTicket letSmartParkingBoyToPark(Car car) {
        ParkTicket parkTicket = null;
        for(ParkingBoy parkingBoy : parkingBoys){
            if(null != parkingBoy && parkingBoy instanceof SmartParkingBoy){
                parkTicket = parkingBoy.park(car);
                ticketBoy.put(parkTicket, parkingBoy);
            }
        }
        return parkTicket;
    }

    public ParkTicket letSuperParkingBoyToPark(Car car) {
        ParkTicket parkTicket = null;
        for(ParkingBoy parkingBoy : parkingBoys){
            if(null != parkingBoy && parkingBoy instanceof SuperParkingBoy){
                parkTicket = parkingBoy.park(car);
                ticketBoy.put(parkTicket, parkingBoy);
            }
        }
        return parkTicket;
    }

    public Car pickUp(ParkTicket parkTicket) {
        ParkingLot parkingLot = ticketPark.get(parkTicket);
        if (parkingLot != null) {
            return parkingLot.pickUp(parkTicket);
        }
        ParkingBoy parkingBoy = ticketBoy.get(parkTicket);
        return parkingBoy.pickUp(parkTicket);
    }

    public int manageSeats() {
        int manageSeats = 0;
        for (ParkingLot parkingLot : parkingLots) {
            manageSeats = manageSeats + parkingLot.getCapacity();
        }
        for (ParkingBoy parkingBoy : parkingBoys){
            manageSeats = manageSeats + parkingBoy.manageSeats();
        }
        return manageSeats;
    }

    public int parkingCarAmount() {
        int parkingCarAmount = 0;
        for (ParkingLot parkingLot : parkingLots) {
            parkingCarAmount = parkingCarAmount + parkingLot.parkingCarNumber();
        }
        for (ParkingBoy parkingBoy : parkingBoys){
            parkingCarAmount = parkingCarAmount + parkingBoy.parkingCarAmount();
        }
        return parkingCarAmount;
    }

}
