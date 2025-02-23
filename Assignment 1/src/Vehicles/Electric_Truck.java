package Vehicles;

public class Electric_Truck extends Vehicle {
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

    public Electric_Truck(String make, String model, int year, double maxAutoRange, double maxWeight){
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
        this.plateNumber = truck.plateNumber;
    }
    
    // Getters
    @Override
    public double getMaxWeight(){return this.maxWeight;}

    
    @Override
    public double getMaxAutoRange(){return this.maxAutoRange;}

    // Setters
    @Override
    public void setMaxWeight(double maxWeight){this.maxWeight = maxWeight;}

    @Override
    public void setMaxAutoRange(double maxAutoRange){this.maxAutoRange = maxAutoRange;}


    @Override
    public String toString(){
        return super.toString() + "\n"
        + "Max truck range: " + maxAutoRange + "\n"
        + "Max weight: " + maxWeight + "\n";
    }

}
