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

    // Getters
    public String getPlateNumber(){return this.plateNumber;}

    public String getMake(){return this.make;}

    public String getModel(){return this.model;}

    public int getYear(){return this.year;}


    // Setters
    public void setMake(String make) {this.make = make;}

    public void setModel(String model) {this.model = model;}

    public void setYear(int year) {this.year = year;}

    // Declare functions so that they can be overriden in subclass
    public double getMaxAutoRange(){return 0;}
    public double getMaxWeight(){return 0;}
    public double getMaxPasenger(){return 0;}
    public double getFuelTankCapacity(){return 0;}


    public void setMaxAutoRange(double maxAutoRange){}
    public void setMaxWeight(double maxWeight){}
    public void setMaxPassenger(int maxPassenger){}
    public void setFuelTankCapacity(double fuelTankCapacity){}


    public String toString(){
        return "Make: " + this.make + "\n" 
        + "Model: " + this.model + "\n"
        + "Year: " + this.year + "\n"
        + "Plate Number: " + this.plateNumber + "\n";
    }


    public boolean equals(Vehicle vehicle){
        if (this.plateNumber == vehicle.plateNumber){
            return true;
        }else{
            return false;
        }

    }




}

