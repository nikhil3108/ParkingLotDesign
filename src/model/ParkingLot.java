package model;

import java.util.List;


public class ParkingLot {
    List<Slot> slots;

    public ParkingLot(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Slot> getSlots() {
        return slots;
    }

}
