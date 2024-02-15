package service.Impl;

import model.Car;
import model.ParkingLot;
import model.Slot;
import service.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingLot parkingLot;
    @Override
    public boolean isSlotAvailable() {
        List<Slot> slotList=parkingLot.getSlots();
        for(int i=0;i<slotList.size();i++) {
            if (slotList.get(i).isOccupied() == false)
                return true;
        }
        return false;
    }

    @Override
    public int parkCar(String regNo, String color) {
        if(!isSlotAvailable()){
            return -1;
        }
        else{
            List<Slot> slotList=parkingLot.getSlots();
            for(int i=0;i<slotList.size();i++) {
                if (slotList.get(i).isOccupied() == false){
                    slotList.get(i).setOccupied(true);
                    Car car=new Car(regNo,color);
                    slotList.get(i).setCar(car);
                    return slotList.get(i).getSlotNo();
                }
            }
        }
        return -1;
    }

    @Override
    public int unPark(int slotNo) {
        List<Slot> slotList=parkingLot.getSlots();
        for(int i=0;i<slotList.size();i++) {
            if (slotList.get(i).getSlotNo() == slotNo){
                slotList.get(i).setOccupied(false);
                slotList.get(i).setCar(null);
                return slotList.get(i).getSlotNo();
            }
        }
        return 0;
    }

    @Override
    public void status() {
        List<Slot> slotList=parkingLot.getSlots();
        System.out.println("Slot No. Registration No Colour");
        for(int i=0;i<slotList.size();i++) {
            Slot slot=slotList.get(i);
            if (slot.isOccupied() == true){
                System.out.println(slot.getSlotNo()+" "+slot.getCar().getRegNo()+" "+slot.getCar().getColor());
            }
        }
    }

    @Override
    public void parkedCarWithColor(String color) {
        List<Slot> slotList=parkingLot.getSlots();
        for(int i=0;i<slotList.size();i++) {
            Slot slot=slotList.get(i);
            if (slot.isOccupied() == true && slot.getCar().getColor().equals(color)){
                System.out.println(slot.getCar().getRegNo()+" ");
            }
        }
    }

    @Override
    public int createParkingLot(int n) {
        List<Slot> slots=new ArrayList<>();
        for(int i=1;i<=n;i++){
            Slot slot=new Slot(i,false);
            slots.add(slot);
        }
        parkingLot=new ParkingLot(slots);
        return n;
    }

    @Override
    public int slotofCarwithRegNo(String regNo) {
        List<Slot> slotList=parkingLot.getSlots();
        for(int i=0;i<slotList.size();i++) {
            Slot slot=slotList.get(i);
            if (slot.getCar().getRegNo().equals(regNo)){
                return slot.getSlotNo();
            }
        }
        return -1;
    }
}
