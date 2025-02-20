package Vehicles;


public class Vehicle {

    protected String plateNumber;
    protected String make;
    protected String model;
    protected int year;
    
    
    public Vehicle(){
        this.make = "No make";
        this.model = "No model";
        this.year = 0;
    }

    public Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle(Vehicle vehicule){
        this.make = vehicule.make;
        this.model = vehicule.model;
        this.year = vehicule.year;
    }

    public String getPlateNumber(){return this.plateNumber;}

    public String getMake(){return this.make;}

    public String getModel(){return this.model;}

    public int getYear(){return this.year;}


    public String toString(){
        return "Make: " + this.make + "\n" 
        + "Model: " + this.model + "\n"
        + "Year: " + this.year + "\n"
        + "Plate Number: " + this.plateNumber;
    }


    public boolean equals(Vehicle vehicle){

    }

}

