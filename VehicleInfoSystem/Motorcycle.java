public class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String motorcycleType;

    public Motorcycle(String make, String model, int year, int numberOfWheels, String motorcycleType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.numberOfWheels = numberOfWheels;
        this.motorcycleType = motorcycleType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setNumberOfWheels(int wheels) {
        this.numberOfWheels = wheels;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void setMotorcycleType(String type) {
        this.motorcycleType = type;
    }

    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }

    @Override
    public String toString() {
        return "Motorcycle [Make: " + make + ", Model: " + model + ", Year: " + year + 
               ", Wheels: " + numberOfWheels + ", Type: " + motorcycleType + "]";
    }
}