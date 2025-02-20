package Vehicules;


public class Vehicule {

    protected String plateNumber;
    protected String make;
    protected String model;
    protected int year;
    
    
    public Vehicule(){
<<<<<<< HEAD
        this.make = "None";
=======
        this.make = "No make";
>>>>>>> a65f268419de57caf14803fea5a60ced3ccab489
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

