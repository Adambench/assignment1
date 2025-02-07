package Vehicules;

public class Electric_Car extends Vehicule {
    private double maxAutoRange; // Max range in km
    private int maxPassenger;

    private static int vehiculeNumber = 1000;

    public Electric_Car(){
        super();
        vehiculeNumber++;
        this.maxAutoRange = 0;
        this.maxPassenger = 0;
        this.plateNumber = "EC" + vehiculeNumber;
    }
    
    public double getMaxPasenger(){return this.maxPassenger;}

    public double getMaxAutoRange(){return this.maxAutoRange;}
}
