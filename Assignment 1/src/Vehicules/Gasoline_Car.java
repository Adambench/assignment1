package Vehicules;

public class Gasoline_Car extends Vehicule{

    private int maxPassenger;

    private static int vehiculeNumber = 1000;

    public Gasoline_Car(){
        super();
        this.maxPassenger = 0;

        vehiculeNumber++;
        this.plateNumber = "GC" + vehiculeNumber;
    }


    public Gasoline_Car(String make, String model, int year, int maxPassenger){
        super(make, model, year);
        this.maxPassenger = maxPassenger;

        vehiculeNumber++;
        this.plateNumber = "GC" + vehiculeNumber;
    }

    public Gasoline_Car(Gasoline_Car car){
        super(car.make, car.model, car.year);
        this.maxPassenger = car.maxPassenger;

        vehiculeNumber++;
        this.plateNumber = "GC" + vehiculeNumber;
    }

    public double getMaxPasenger(){return this.maxPassenger;}


    
}
