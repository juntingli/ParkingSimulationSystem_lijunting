package park;

public interface ParkingBoy {
    ParkTicket park(Car car);

    Car pickUp(ParkTicket parkTicket);
}
