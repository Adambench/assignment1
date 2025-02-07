package Vehicules;

public class Truck extends Vehicule {
private double maxWeight;
private static int vehiculeNumber = 1000;
private String plateNumber;

public Truck(){
    super();
    this.maxWeight=0.0;
    vehiculeNumber++;
    this.plateNumber=
}
public Truck(int make, String model, int year, double maxWeight){
    super(make, model, year);
    this.maxWeight=maxWeight;
}


}
