package model;

public class Slot {
    int slotNo;
    boolean occupied;
    Car car;

    public Slot(int slotNo, boolean isOccupied) {
        this.slotNo = slotNo;
        this.occupied = isOccupied;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Car getCar() {
        return car;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
