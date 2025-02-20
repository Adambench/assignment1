package Vehicules;

public class Diesel_Truck extends Vehicule {
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

        vehiculeNumber++;
        this.plateNumber = "DT" + vehiculeNumber;
    }

    public double getMaxWeight(){return this.maxWeight;}

    public double getFuelTankCapacity(){return this.fuelTankCapacity;}

    public String toString(){
        return super.toString() + "\n"
        + "Max fuel tank capacity: " + fuelTankCapacity + " L\n"
        + "Max weight: " + maxWeight + "\n";
    }

}

