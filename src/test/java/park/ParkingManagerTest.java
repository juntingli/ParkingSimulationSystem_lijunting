package park;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingManagerTest {

    @Test
    void should_get_parked_car_with_ticket() {

        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ParkingLot parkingLot3 = new ParkingLot(3);
        ParkingLot parkingLot4 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        parkingLots.add(parkingLot4);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        ParkingManager parkingManager = new ParkingManager(parkingLots, ticketPark);
        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot2);
        List<ParkingLot> suoerParkingBoyParkingLots = new ArrayList<>();
        suoerParkingBoyParkingLots.add(parkingLot3);
        suoerParkingBoyParkingLots.add(parkingLot4);
        parkingManager.assignParkingLotsToSmartParkingBoy(smartParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSuperParkingBoy(suoerParkingBoyParkingLots);

        //when
        Car car = new Car();
        ParkTicket parkTicket = parkingManager.personallyPark(car);
        Car pickedCar = parkingManager.pickUp(parkTicket);

        //then
        assertEquals(car, pickedCar);
    }

    @Test
    void should_get_parked_car_with_ticket_when_assign_parking_lots_to_common_parking_boy() {

        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ParkingLot parkingLot3 = new ParkingLot(3);
        ParkingLot parkingLot4 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        parkingLots.add(parkingLot4);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        ParkingManager parkingManager = new ParkingManager(parkingLots, ticketPark);
        List<ParkingLot> commonParkingBoyParkingLots = new ArrayList<>();
        commonParkingBoyParkingLots.add(parkingLot2);
        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot3);
        List<ParkingLot> superParkingBoyParkingLots = new ArrayList<>();
        superParkingBoyParkingLots.add(parkingLot4);
        parkingManager.assignParkingLotsToCommonParkingBoy(commonParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSmartParkingBoy(smartParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSuperParkingBoy(superParkingBoyParkingLots);

        //when
        Car car = new Car();
        ParkTicket parkTicket = parkingManager.letCommonParkingBoyToPark(car);
        Car pickedCar = parkingManager.pickUp(parkTicket);

        //then
        assertEquals(car, pickedCar);
    }

    @Test
    void should_get_parked_car_with_ticket_when_assign_parking_lots_to_smart_parking_boy() {

        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ParkingLot parkingLot3 = new ParkingLot(3);
        ParkingLot parkingLot4 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        parkingLots.add(parkingLot4);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        ParkingManager parkingManager = new ParkingManager(parkingLots, ticketPark);
        List<ParkingLot> commonParkingBoyParkingLots = new ArrayList<>();
        commonParkingBoyParkingLots.add(parkingLot2);
        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot3);
        List<ParkingLot> superParkingBoyParkingLots = new ArrayList<>();
        superParkingBoyParkingLots.add(parkingLot4);
        parkingManager.assignParkingLotsToCommonParkingBoy(commonParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSmartParkingBoy(smartParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSuperParkingBoy(superParkingBoyParkingLots);

        //when
        Car car = new Car();
        ParkTicket parkTicket = parkingManager.letSmartParkingBoyToPark(car);
        Car pickedCar = parkingManager.pickUp(parkTicket);

        //then
        assertEquals(car, pickedCar);
    }


    @Test
    void should_get_parked_car_with_ticket_when_assign_parking_lots_to_super_parking_boy() {

        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(5);
        ParkingLot parkingLot3 = new ParkingLot(3);
        ParkingLot parkingLot4 = new ParkingLot(2);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        parkingLots.add(parkingLot4);
        Map<ParkTicket, ParkingLot> ticketPark = new HashMap<>();
        ParkingManager parkingManager = new ParkingManager(parkingLots, ticketPark);
        List<ParkingLot> commonParkingBoyParkingLots = new ArrayList<>();
        commonParkingBoyParkingLots.add(parkingLot2);
        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot3);
        List<ParkingLot> superParkingBoyParkingLots = new ArrayList<>();
        superParkingBoyParkingLots.add(parkingLot4);
        parkingManager.assignParkingLotsToCommonParkingBoy(commonParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSmartParkingBoy(smartParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSuperParkingBoy(superParkingBoyParkingLots);

        //when
        Car car = new Car();
        ParkTicket parkTicket = parkingManager.letSuperParkingBoyToPark(car);
        Car pickedCar = parkingManager.pickUp(parkTicket);

        //then
        assertEquals(car, pickedCar);
    }
}