package park;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    private final List<ParkingLot> parkingLots;
    private Map<ParkTicket, ParkingLot> ticketPark;
    private CommonParkingBoy commonParkingBoy;
    private SmartParkingBoy smartParkingBoy;
    private SuperParkingBoy superParkingBoy;

    public ParkingManager(List<ParkingLot> parkingLots, Map<ParkTicket, ParkingLot> ticketPark) {
        this.parkingLots = parkingLots;
        this.ticketPark = ticketPark;
    }

    public void assignParkingLotsToCommonParkingBoy(List<ParkingLot> parkingLots) {
        commonParkingBoy = new CommonParkingBoy(parkingLots, ticketPark);
    }

    public void assignParkingLotsToSmartParkingBoy(List<ParkingLot> parkingLots) {
        smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);
    }

    public void assignParkingLotsToSuperParkingBoy(List<ParkingLot> parkingLots) {
        superParkingBoy = new SuperParkingBoy(parkingLots, ticketPark);
    }

    public CommonParkingBoy getCommonParkingBoy() {
        return commonParkingBoy;
    }

    public SmartParkingBoy getSmartParkingBoy() {
        return smartParkingBoy;
    }

    public SuperParkingBoy getSuperParkingBoy() {
        return superParkingBoy;
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
        if (null != commonParkingBoy) {
            return commonParkingBoy.park(car);
        }
        return null;
    }

    public ParkTicket letSmartParkingBoyToPark(Car car) {
        if (null != smartParkingBoy) {
            return smartParkingBoy.park(car);
        }
        return null;
    }

    public ParkTicket letSuperParkingBoyToPark(Car car) {
        if (null != superParkingBoy) {
            return superParkingBoy.park(car);
        }
        return null;
    }

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

    public List<ParkingLot> getPersonalPakingLots() {
        List<ParkingLot> tempParkingLots = new ArrayList<>();
        tempParkingLots.addAll(parkingLots);
        if (null != commonParkingBoy) {
            tempParkingLots.removeAll(commonParkingBoy.getPakingLots());
        }
        if (null != smartParkingBoy) {
            tempParkingLots.removeAll(smartParkingBoy.getPakingLots());
        }
        if (null != superParkingBoy) {
            tempParkingLots.removeAll(superParkingBoy.getPakingLots());
        }
        return tempParkingLots;
    }
}
