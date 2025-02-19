package Vehicules;


public class Vehicule {

    protected String plateNumber;
    protected String make;
    protected String model;
    protected int year;
    
    
    public Vehicule(){
        this.make = "No make";
        this.model = "No model";
        this.year = 0;
    }

    public Vehicule(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicule(Vehicule vehicule){
        this.make = vehicule.make;
        this.model = vehicule.model;
        this.year = vehicule.year;
    }

    public String getPlateNumber(){return this.plateNumber;}

    public String getMake(){return this.make;}

    public String getModel(){return this.model;}

    public int getYear(){return this.year;}

}

