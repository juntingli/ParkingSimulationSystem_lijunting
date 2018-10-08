package park;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {

    @Test
    void should_get_parked_car_with_ticket() {

        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);

        //when
        Car car1 = new Car();
        Car car2 = new Car();
        ParkTicket parkTicket1 = smartParkingBoy.park(car1);
        ParkTicket parkTicket2 = smartParkingBoy.park(car2);
        Car pickedCar1 = smartParkingBoy.pickUp(parkTicket1);
        Car pickedCar2 = smartParkingBoy.pickUp(parkTicket2);

        //then
        assertEquals(car1, pickedCar1);
        assertEquals(car2, pickedCar2);
    }

    @Test
    void should_park_car_into_the_parking_lot_when_the_parking_lot_RemainSeats_is_most1() {

        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);

        //when
        Car car = new Car();
        ParkTicket parkTicket = smartParkingBoy.park(car);
        Car pickedCar = parkingLot2.pickUp(parkTicket);

        //then
        assertEquals(car, pickedCar);
    }

    @Test
    void should_park_car_into_the_parking_lot_when_the_parking_lot_RemainSeats_is_most2() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);

        //when
        Car car = new Car();
        ParkTicket parkTicket = smartParkingBoy.park(car);

        //then
        assertEquals(parkingLot1.isFull(), false);
        assertEquals(parkingLot2.RemainSeats(), 1);
        assertEquals(parkingLot2.isIn(parkTicket), true);
    }

    @Test
    void should_park_car_into_first_parking_lot_when_all_parking_lot_RemainSeats_is_same() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots, ticketPark);

        //when
        Car car = new Car();
        ParkTicket parkTicket = smartParkingBoy.park(car);

        //then
        assertEquals(parkingLot1.isIn(parkTicket), true);
        assertEquals(parkingLot1.isFull(), true);
        assertEquals(parkingLot2.RemainSeats(), 1);
    }

}