package Vehicles;

public class Electric_Car extends Vehicle {
    private double maxAutoRange; // Max range in km
    private int maxPassenger;

    private static int vehiculeNumber = 1000;

    public Electric_Car(){
        super();
        this.maxAutoRange = 0;
        this.maxPassenger = 0;

        vehiculeNumber++;
        this.plateNumber = "EC" + vehiculeNumber;
    }


    public Electric_Car(String make, String model, int year, double maxAutoRange, int maxPassenger){
        super(make, model, year);
        this.maxPassenger = maxPassenger;
        this.maxAutoRange = maxAutoRange;

        vehiculeNumber++;
        this.plateNumber = "EC" + vehiculeNumber;
    }

    public Electric_Car(Electric_Car car){
        super(car.make, car.model, car.year);
        this.maxAutoRange = car.maxAutoRange;
        this.maxPassenger = car.maxPassenger;
        this.plateNumber = car.plateNumber;
    }

    
    // Getters
    @Override
    public double getMaxPasenger(){return this.maxPassenger;}

    @Override
    public double getMaxAutoRange(){return this.maxAutoRange;}

    // Setters
    @Override
    public void setMaxPassenger(int maxPassenger){this.maxPassenger = maxPassenger;}
    
    @Override
    public void setMaxAutoRange(double maxAutoRange){this.maxAutoRange = maxAutoRange;}


    @Override
    public String toString(){
        return super.toString() + "\n"
        + "Max truck range: " + maxAutoRange + "\n"
        + "Max number of passenger: " + maxPassenger + "\n";
    }
}
