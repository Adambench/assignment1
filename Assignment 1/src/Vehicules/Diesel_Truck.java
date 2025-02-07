package Vehicules;

public class Diesel_Truck extends Vehicule {
    private double maxWeight; // Weight it can transport in kg
    private double fuelTankCapacity;

    private static int vehiculeNumber = 1000;

    public Diesel_Truck(){
        super();
        vehiculeNumber++;
        this.fuelTankCapacity = 0;
        this.maxWeight = 0;
        this.plateNumber = "DT" + vehiculeNumber;
    }

    public double getMaxWeight(){return this.maxWeight;}

    public double getFuelTankCapacity(){return this.fuelTankCapacity;}


}

