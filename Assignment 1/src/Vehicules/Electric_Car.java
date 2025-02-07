package Vehicules;

public class Electric_Car extends Vehicule {
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


    public Electric_Car(int make, String model, int year, double maxAutoRange, int maxPassenger){
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

        vehiculeNumber++;
        this.plateNumber = "EC" + vehiculeNumber;
    }

    
    
    public double getMaxPasenger(){return this.maxPassenger;}

    public double getMaxAutoRange(){return this.maxAutoRange;}
}
