package park;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SuperParkingBoyTest {

    @Test
    void should_get_parked_car_with_ticket() {

        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        //when
        Car car1 = new Car();
        Car car2 = new Car();
        ParkTicket parkTicket1 = superParkingBoy.park(car1);
        ParkTicket parkTicket2 = superParkingBoy.park(car2);
        Car pickedCar1 = superParkingBoy.pickUp(parkTicket1);
        Car pickedCar2 = superParkingBoy.pickUp(parkTicket2);

        //then
        assertEquals(car1, pickedCar1);
        assertEquals(car2, pickedCar2);
    }

    @Test
    void should_park_car_into_the_parking_lot_when_the_parking_lot_RemainSeatRate_is_most1() {

        //given
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        //when
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkTicket parkTicket1 = superParkingBoy.park(car1);
        ParkTicket parkTicket2 = superParkingBoy.park(car2);
        ParkTicket parkTicket3 = superParkingBoy.park(car3);
        Car pickedCar = parkingLot2.pickUp(parkTicket3);

        //then
        assertEquals(car3, pickedCar);
    }

    @Test
    void should_park_car_into_the_parking_lot_when_the_parking_lot_RemainSeatRate_is_most2() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        //when
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkTicket parkTicket1 = superParkingBoy.park(car1);
        ParkTicket parkTicket2 = superParkingBoy.park(car2);
        ParkTicket parkTicket3 = superParkingBoy.park(car3);

        //then
        assertEquals(parkingLot1.isFull(), false);
        assertEquals(parkingLot2.RemainSeats(), 1);
        assertEquals(parkingLot2.isIn(parkTicket3), true);
    }

    @Test
    void should_park_car_into_first_parking_lot_when_all_parking_lot_RemainSeats_is_same() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);

        //when
        Car car = new Car();
        ParkTicket parkTicket = superParkingBoy.park(car);

        //then
        assertEquals(parkingLot1.isIn(parkTicket), true);
        assertEquals(parkingLot1.isFull(), true);
        assertEquals(parkingLot2.RemainSeats(), 1);
    }

}