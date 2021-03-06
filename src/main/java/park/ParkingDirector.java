package park;

import java.util.ArrayList;
import java.util.List;

public class ParkingDirector {
    public String reportOutPrint(ParkingManager parkingManager) {
        StringBuffer reportOutPrintInfo = new StringBuffer();
/*        reportOutPrintInfo.append("M " + parkingManager.parkingCarAmount() + " " + parkingManager.manageSeats() + System.lineSeparator());*/
/*        for (ParkingLot parkingLot : parkingManager.getPersonalPakingLots()) {
            reportOutPrintInfo.append("P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity() + System.lineSeparator());
        }*/
/*        if (null != parkingManager.getCommonParkingBoy()) {
            reportOutPrintInfo.append(" B " + parkingManager.getCommonParkingBoy().parkingCarNumber() + " " + parkingManager.getCommonParkingBoy().manageSeats() + System.lineSeparator());
*//*            for (ParkingLot parkingLot : parkingManager.getCommonParkingBoy().getPakingLots()) {
                reportOutPrintInfo.append("   P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity() + System.lineSeparator());
            }*//*
        }*/
/*        if (null != parkingManager.getSmartParkingBoy()) {
            reportOutPrintInfo.append(" B " + parkingManager.getSmartParkingBoy().parkingCarAmount() + " " + parkingManager.getSmartParkingBoy().manageSeats() + System.lineSeparator());
*//*            for (ParkingLot parkingLot : parkingManager.getSmartParkingBoy().getPakingLots()) {
                reportOutPrintInfo.append("   P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity() + System.lineSeparator());
            }*//*
        }*/
/*        if (null != parkingManager.getSuperParkingBoy()) {
            reportOutPrintInfo.append(" B " + parkingManager.getSuperParkingBoy().parkingCarAmount() + " " + parkingManager.getSuperParkingBoy().manageSeats() + System.lineSeparator());
*//*            for (ParkingLot parkingLot : parkingManager.getSuperParkingBoy().getPakingLots()) {
                reportOutPrintInfo.append("   P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity() + System.lineSeparator());
            }*//*
        }*/
        return reportOutPrintInfo.toString();
    }

    public static void main(String[] args) {
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
        System.out.println("M " + parkingManager.parkingCarAmount() + " " + parkingManager.manageSeats());
/*        for (ParkingLot parkingLot : parkingManager.getPersonalPakingLots()) {
            System.out.println("P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity());
        }*/
/*        if (null != parkingManager.getCommonParkingBoy()) {
*//*            System.out.println(" B " + parkingManager.getCommonParkingBoy().parkingCarNumber() + " " + parkingManager.getCommonParkingBoy().manageSeats());
            for (ParkingLot parkingLot : parkingManager.getCommonParkingBoy().getPakingLots()) {
                System.out.println("   P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity());
            }*//*
        }*/
/*        if (null != parkingManager.getSmartParkingBoy()) {
            System.out.println(" B " + parkingManager.getSmartParkingBoy().parkingCarAmount() + " " + parkingManager.getSmartParkingBoy().manageSeats());
*//*            for (ParkingLot parkingLot : parkingManager.getSmartParkingBoy().getPakingLots()) {
                System.out.println("   P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity());
            }*//*
        }*/
/*        if (null != parkingManager.getSuperParkingBoy()) {
            System.out.println(" B " + parkingManager.getSuperParkingBoy().parkingCarAmount() + " " + parkingManager.getSuperParkingBoy().manageSeats());
*//*            for (ParkingLot parkingLot : parkingManager.getSuperParkingBoy().getPakingLots()) {
                System.out.println("   P " + parkingLot.parkingCarNumber() + " " + parkingLot.getCapacity());
            }*//*
        }*/
        System.out.println("-----------------------------------------------------------");
        ParkingDirector parkingDirector = new ParkingDirector();
        System.out.println(parkingDirector.reportOutPrint(parkingManager));
    }
}
