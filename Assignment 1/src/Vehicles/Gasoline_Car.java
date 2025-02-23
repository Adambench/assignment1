package Vehicles;

public class Gasoline_Car extends Vehicle{

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
        this.plateNumber = car.plateNumber;
    }

    // Getter
    @Override
    public double getMaxPasenger(){return this.maxPassenger;}

    // Setter
    @Override
    public void setMaxPassenger(int maxPassenger){this.maxPassenger = maxPassenger;}

    @Override
    public String toString(){
        return super.toString() + "\n"
        + "Max number of passenger: " + maxPassenger + "\n";
    }
    
}
