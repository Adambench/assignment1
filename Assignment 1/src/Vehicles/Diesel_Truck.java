package Vehicles;

public class Diesel_Truck extends Vehicle {
    private double maxWeight; // Weight it can transport in kg
    private double fuelTankCapacity;

    private static int vehiculeNumber = 1000;

    public Diesel_Truck(){
        super();
        this.fuelTankCapacity = 0;
        this.maxWeight = 0;

        vehiculeNumber++;
        this.plateNumber = "DT" + vehiculeNumber;
    }


    public Diesel_Truck(String make, String model, int year, double maxWeight, double fuelTankCapacity){
        super(make, model, year);
        this.maxWeight = maxWeight;
        this.fuelTankCapacity =  fuelTankCapacity;

        vehiculeNumber++;
        this.plateNumber = "DT" + vehiculeNumber;
    }

    public Diesel_Truck(Diesel_Truck truck){
        super(truck.make, truck.model, truck.year);
        this.maxWeight = truck.maxWeight;
        this.fuelTankCapacity =  truck.fuelTankCapacity;
        this.plateNumber = truck.plateNumber;
    }

    // Getters
    @Override
    public double getMaxWeight(){return this.maxWeight;}
    
    @Override
    public double getFuelTankCapacity(){return this.fuelTankCapacity;}

    //Setters
    @Override
    public void setMaxWeight(double maxWeight){this.maxWeight = maxWeight;}

    @Override
    public void setFuelTankCapacity(double fuelTankCapacity){this.fuelTankCapacity = fuelTankCapacity;}

    @Override
    public String toString(){
        return super.toString() + "\n"
        + "Max fuel tank capacity: " + fuelTankCapacity + " L\n"
        + "Max weight: " + maxWeight + "\n";
    }

}

