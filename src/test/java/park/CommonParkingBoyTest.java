package park;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommonParkingBoyTest {

    @Test
    void should_get_parked_car_with_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        CommonParkingBoy commonParkingBoy = new CommonParkingBoy(parkingLots);

        //when
        Car car1 = new Car();
        Car car2 = new Car();
        ParkTicket parkTicket1 = commonParkingBoy.park(car1);
        ParkTicket parkTicket2 = commonParkingBoy.park(car2);
        Car pickedCar1 = commonParkingBoy.pickUp(parkTicket1);
        Car pickedCar2 = commonParkingBoy.pickUp(parkTicket2);

        //then
        assertEquals(car1, pickedCar1);
        assertEquals(car2, pickedCar2);
    }

    @Test
    void should_park_car_into_the_first_parking_lot_when_the_parking_lot_is_not_full1() {

        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        CommonParkingBoy commonParkingBoy = new CommonParkingBoy(parkingLots);

        //when
        Car car = new Car();
        ParkTicket parkTicket = commonParkingBoy.park(car);
        Car pickedCar = parkingLot1.pickUp(parkTicket);

        //then
        assertEquals(car, pickedCar);
    }

    @Test
    void should_park_car_into_the_first_parking_lot_when_the_parking_lot_is_not_full2() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        CommonParkingBoy commonParkingBoy = new CommonParkingBoy(parkingLots);

        //when
        Car car = new Car();
        ParkTicket parkTicket = commonParkingBoy.park(car);

        //then
        assertEquals(parkingLot1.isFull(), true);
        assertEquals(parkingLot2.RemainSeats(), 2);
        assertEquals(parkingLot1.isIn(parkTicket), true);
    }

}