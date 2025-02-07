package Vehicules;

public class Electric_Truck extends Vehicule {
    private String plateNumber;
    private double maxAutoRange;
    private double maxWeight; // Weight it can transport in kg

    private static int vehiculeNumber = 1000;

    
    public Electric_Truck(){
        super();
        vehiculeNumber++;
        this.maxWeight = 0;
        this.plateNumber = "ET" + vehiculeNumber;
    }
}
