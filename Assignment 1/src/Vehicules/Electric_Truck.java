package Vehicules;

public class Electric_Truck extends Vehicule {
    private double maxAutoRange; // Max range in km
    private double maxWeight; // Weight it can transport in kg

    private static int vehiculeNumber = 1000;

    
    public Electric_Truck(){
        super();
        this.maxAutoRange = 0;
        this.maxWeight = 0;

        vehiculeNumber++;
        this.plateNumber = "ET" + vehiculeNumber;
    }

    public Electric_Truck(int make, String model, int year, double maxAutoRange, double maxWeight){
        super(make, model, year);
        this.maxAutoRange = maxAutoRange;
        this.maxWeight =  maxWeight;

        vehiculeNumber++;
        this.plateNumber = "ET" + vehiculeNumber;
    }

    public Electric_Truck(Electric_Truck truck){
        super(truck.make, truck.model, truck.year);
        this.maxAutoRange = truck.maxAutoRange;
        this.maxWeight =  truck.maxWeight;

        vehiculeNumber++;
        this.plateNumber = "ET" + vehiculeNumber;
    }
    

    public double getMaxWeight(){return this.maxWeight;}

    public double getMaxAutoRange(){return this.maxAutoRange;}

}
