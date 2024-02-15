import service.Impl.ParkingLotServiceImpl;
import service.ParkingLotService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotService service = new ParkingLotServiceImpl();

        while (true) {
            System.out.print("$ ");
            String command = scanner.next();

            switch (command) {
                case "create_parking_lot":
                    int capacity = scanner.nextInt();
                    int n=service.createParkingLot(capacity);
                    System.out.println("Created a parking lot with " + n + " slots");
                    break;
                case "park":
                    String registrationNumber = scanner.next();
                    String color = scanner.next();
                    int slotno=service.parkCar(registrationNumber, color);
                    if(slotno==-1)
                        System.out.println("Sorry, parking lot is full ");
                    else
                      System.out.println("Allocated slot number: "+slotno);
                    break;
                case "leave":
                    int slotNumber = scanner.nextInt();
                    int unParkslotno=service.unPark(slotNumber);
                    System.out.println("Slot number "+unParkslotno+" is free");
                    break;
                case "status":
                    service.status();
                    break;
                case "registration_numbers_for_cars_with_colour":
                    String targetColor = scanner.next();
                    service.parkedCarWithColor(targetColor);
                    break;
                case "slot_number_for_registration_number":
                    String targetRegistrationNumber = scanner.next();
                    int slot = service.slotofCarwithRegNo(targetRegistrationNumber);
                    if (slot != -1) {
                        System.out.println("Slot number: " + slot);
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}