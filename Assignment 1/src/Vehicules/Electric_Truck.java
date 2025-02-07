package Vehicules;

public class Electric_Truck extends Vehicule {
    private double maxAutoRange; // Max range in km
    private double maxWeight; // Weight it can transport in kg

    private static int vehiculeNumber = 1000;

    
    public Electric_Truck(){
        super();
        vehiculeNumber++;
        this.maxAutoRange = 0;
        this.maxWeight = 0;
        this.plateNumber = "ET" + vehiculeNumber;
    }


    public double getMaxWeight(){return this.maxWeight;}

    public double getMaxAutoRange(){return this.maxAutoRange;}

}
