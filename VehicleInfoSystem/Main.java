import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Car object
        System.out.println("Enter Car details:");
        System.out.print("Make: ");
        String carMake = scanner.nextLine();
        System.out.print("Model: ");
        String carModel = scanner.nextLine();
        System.out.print("Year: ");
        int carYear = scanner.nextInt();
        System.out.print("Number of Doors: ");
        int carDoors = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fuel Type (Petrol/Diesel/Electric): ");
        String carFuelType = scanner.nextLine();
        Car car = new Car(carMake, carModel, carYear, carDoors, carFuelType);

        // Create a Motorcycle object
        System.out.println("\nEnter Motorcycle details:");
        System.out.print("Make: ");
        String motorcycleMake = scanner.nextLine();
        System.out.print("Model: ");
        String motorcycleModel = scanner.nextLine();
        System.out.print("Year: ");
        int motorcycleYear = scanner.nextInt();
        System.out.print("Number of Wheels: ");
        int motorcycleWheels = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type (Sport/Cruiser/Off-road): ");
        String motorcycleType = scanner.nextLine();
        Motorcycle motorcycle = new Motorcycle(motorcycleMake, motorcycleModel, motorcycleYear, motorcycleWheels, motorcycleType);

        // Create a Truck object
        System.out.println("\nEnter Truck details:");
        System.out.print("Make: ");
        String truckMake = scanner.nextLine();
        System.out.print("Model: ");
        String truckModel = scanner.nextLine();
        System.out.print("Year: ");
        int truckYear = scanner.nextInt();
        System.out.print("Cargo Capacity (in tons): ");
        double cargoCapacity = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Transmission Type (Manual/Automatic): ");
        String transmissionType = scanner.nextLine();
        Truck truck = new Truck(truckMake, truckModel, truckYear, cargoCapacity, transmissionType);

        // Display details
        System.out.println("\nVehicle Details:");
        System.out.println(car);
        System.out.println(motorcycle);
        System.out.println(truck);

        scanner.close();
    }
}