package Vehicules;

public class Diesel_Car extends Vehicule{

    private int maxPassenger;

    private static int vehiculeNumber = 1000;

    public Diesel_Car(){
        super();
        vehiculeNumber++;
        this.maxPassenger = 0;
        this.plateNumber = "DC" + vehiculeNumber;
    }

    public double getMaxPasenger(){return this.maxPassenger;}


    
}
