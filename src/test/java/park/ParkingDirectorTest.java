package park;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingDirectorTest {

    @Test
    void reportOutPrint() {

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
        ParkingManager parkingManager = new ParkingManager(parkingLots);
        List<ParkingLot> smartParkingBoyParkingLots = new ArrayList<>();
        smartParkingBoyParkingLots.add(parkingLot2);
        List<ParkingLot> suoerParkingBoyParkingLots = new ArrayList<>();
        suoerParkingBoyParkingLots.add(parkingLot3);
        suoerParkingBoyParkingLots.add(parkingLot4);
        parkingManager.assignParkingLotsToSmartParkingBoy(smartParkingBoyParkingLots);
        parkingManager.assignParkingLotsToSuperParkingBoy(suoerParkingBoyParkingLots);

        //when
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        parkingManager.personallyPark(car1);
        parkingManager.personallyPark(car2);
        parkingManager.letSmartParkingBoyToPark(car3);
        parkingManager.letSmartParkingBoyToPark(car4);
        parkingManager.letSuperParkingBoyToPark(car5);
        StringBuffer reportOutPrintInfo = new StringBuffer();
        reportOutPrintInfo.append("M 5 20" + System.lineSeparator());
        reportOutPrintInfo.append("P 2 10" + System.lineSeparator());
        reportOutPrintInfo.append(" B 2 5" + System.lineSeparator());
        reportOutPrintInfo.append("   P 2 5" + System.lineSeparator());
        reportOutPrintInfo.append(" B 1 5" + System.lineSeparator());
        reportOutPrintInfo.append("   P 1 3" + System.lineSeparator());
        reportOutPrintInfo.append("   P 0 2" + System.lineSeparator());
        ParkingDirector parkingDirector = new ParkingDirector();

        //then
        assertEquals(reportOutPrintInfo.toString(), parkingDirector.reportOutPrint(parkingManager));
    }
}