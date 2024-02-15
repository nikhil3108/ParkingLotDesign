package service;

import model.Car;
import model.Slot;

import java.util.List;

public interface ParkingLotService {
    boolean isSlotAvailable();
    int parkCar(String regNo,String color);
    int unPark(int slotNo);
    void status();
    void parkedCarWithColor(String color);
    int createParkingLot(int n);
    int slotofCarwithRegNo(String regNo);
}
