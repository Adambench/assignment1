package Driver;
import java.util.Scanner;

import Client.*;
import Vehicles.*;

public class Driver {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Array containing all the clients
        Client[] client_Arr = new Client[0];
        Vehicle[][] vehicles = new Vehicle[4][];

        vehicles[0] = new Electric_Truck[0];
        vehicles[1] = new Electric_Car[0];
        vehicles[2] = new Diesel_Truck[0];
        vehicles[3] = new Gasoline_Car[0];



        /*
         * Index of every type of vehicle: 
         * 0 - Electric truck
         * 1 - Electric car
         * 2 - Diesel truck
         * 3 - Gasoline car
         */


    
        Vehicle[] tempArr = new Vehicle[1];        
        
        boolean app = true;
        int choice;
        int vehicleTypeChoice;
        String make;
        String model;
        int year;
        double maxAutoRange;
        int maxPassenger;
        double maxWeight;
        double fuelTankCapacity;
        String plateNumber;


        while (app) {
            System.out.println("What would you like to do? \n\n"
            + "11- Add vehicle \n"
            + "12- Delete vehicle \n"
            + "13- Update vehicle information \n"
            + "14- List all vehicles by category\n\n"

            + "21- Add client \n"
            + "22- Edit client \n"
            + "23- Delete client \n\n"

            + "31- Lease vehicle to client \n"
            + "32- Return vehicle from a client \n"
            + "33- Show all vehicles leased by a client \n"
            + "34- Show all leased vehicles (by all clients) \n\n"

            + "41- Display the truck with the largest capacity \n"
            + "42- Create a copy of the electric trucks array (see below) \n"
            );
            
            System.out.print("Select choice :");
            choice = sc.nextInt();

            switch (choice) {
                case 11:
                    
                    System.out.println("Which type of vehicle would you like to add? \n"
                    + "1. Electric truck \n"
                    + "2. Electric Car \n"
                    + "3. Diesel truck \n"
                    + "4. Gasoline car \n"
                    );
                    vehicleTypeChoice = sc.nextInt();

                    switch (vehicleTypeChoice) {
                        case 1:
                        // Get all the necessary 
                        sc.nextLine();
                        System.out.println("What is the make (company) of the electric truck: ");
                        make = sc.nextLine();
                        System.out.println("What is the model of the electric truck: ");
                        model = sc.nextLine();
                        System.out.println("What is the year of the electric truck: ");
                        year = sc.nextInt();
                        System.out.println("What is the maximum autonomy range (in km) of the electric truck: ");
                        maxAutoRange = sc.nextDouble();
                        System.out.println("What is the maximum weight capacity (in kg) of the electric truck: ");
                        maxWeight = sc.nextDouble();

                        // (Vehicle[][] vehicles, Vehicle[] tempArr, int arrayIndex){
                        // adds one more place at the end of the array 
                        vehicles = addVehicle(vehicles, tempArr, vehicleTypeChoice);

                        // Add the newly added Electric Truck
                        vehicles[0][vehicles[0].length -1] = new Electric_Truck(make, model, year, maxAutoRange, maxWeight);

                        System.out.println("The following Electric Truck was just added: \n" 
                                            +vehicles[0][vehicles[0].length -1] + "\n");
                        break;

                        case 2:
                        sc.nextLine();
                        System.out.println("What is the make (company) of the electric car: ");
                        make = sc.nextLine();
                        System.out.println("What is the model of the electric car: ");
                        model = sc.nextLine();
                        System.out.println("What is the year of the electric car: ");
                        year = sc.nextInt();
                        System.out.println("What is the maximum autonomy range (in km) of the electric car: ");
                        maxAutoRange = sc.nextDouble();
                        System.out.println("What is the maximum number of passenger of the electric car: ");
                        maxPassenger = sc.nextInt();
                        
                        vehicles = (addVehicle(vehicles, tempArr, vehicleTypeChoice));

                        // Add the newly added Electric Car
                        vehicles[1][vehicles[1].length -1] = new Electric_Car(make, model, year, maxAutoRange, maxPassenger);

                        System.out.println("The following Electric Car was just added: \n" 
                                            +vehicles[1][vehicles[1].length -1] + "\n");
                        
                        break;


                        case 3:
                        sc.nextLine();
                        System.out.println("What is the make (company) of the diesel truck: ");
                        make = sc.nextLine();
                        System.out.println("What is the model of the diesel truck: ");
                        model = sc.nextLine();
                        System.out.println("What is the year of the diesel truck: ");
                        year = sc.nextInt();
                        System.out.println("What is the maximum fuel tank capacity of the diesel truck: ");
                        fuelTankCapacity = sc.nextDouble();
                        System.out.println("What is the maximum weight capacity (in kg) of the diesel truck: ");
                        maxWeight = sc.nextDouble();
                        
                        
                        vehicles = (addVehicle(vehicles, tempArr, vehicleTypeChoice));

                        // Add the newly added Electric Car
                        vehicles[2][vehicles[2].length -1] = new Diesel_Truck(make, model, year, fuelTankCapacity, maxWeight);

                        System.out.println("------------------------------------------------\n"
                                            +"The following Diesel Truck was just added: \n" 
                                            +vehicles[2][vehicles[2].length -1] + "\n");
                        break;

                        case 4:
                        sc.nextLine();
                        System.out.println("What is the make (company) of the gasoline car: ");
                        make = sc.nextLine();
                        System.out.println("What is the model of the gasoline car: ");
                        model = sc.nextLine();
                        System.out.println("What is the year of the gasoline car: ");
                        year = sc.nextInt();
                        System.out.println("What is the maximum number of passenger of the gasoline car: ");
                        maxPassenger = sc.nextInt();

                                               
                        vehicles = (addVehicle(vehicles, tempArr, vehicleTypeChoice));

                        // Add the newly added Gasoline Car
                        vehicles[3][vehicles[3].length -1] = new Gasoline_Car(make, model, year, maxPassenger);

                        System.out.println("The following Gasoline Car was just added: \n" 
                                            +vehicles[3][vehicles[3].length -1] + "\n");

                        break;
                        
                    }

                    break;

                case 12:
                    System.out.println("Enter the plate number of the vehicle you would like to delete: ");
                    plateNumber = sc.nextLine();
                    if(plateNumber.substring(0, 1).equals("DT")){

                    }
                    break;

                case 13:
                    break;

                case 14:
                    break;


                case 21:
                    break;

                case 22:
                    break;

                case 23:
                    break;


                case 31:
                
                    break;  

                case 32:
                    break;

                case 33:
                    break;

                case 34:
                    break;  

                case 41:

                int j=0;
                int k=0;
                 for (int i=0; i < electricTruck_Arr.length;i++ ){
                    if (electricTruck_Arr[i].getMaxWeight() > electricTruck_Arr[j].getMaxWeight()) j=i;
                 }
                 for (int i=0; i < dieselTrucks_Arr.length;i++ ){
                    if (dieselTrucks_Arr[i].getMaxWeight() > dieselTrucks_Arr[k].getMaxWeight()) k=i;
                 }
                 if (electricTruck_Arr[j].getMaxWeight()>dieselTrucks_Arr[k].getMaxWeight()) {
                    System.out.println("The truck with the largest capacity is: " + electricTruck_Arr[j].toString());
                }
                else  
                System.out.println("The truck with the largest capacity is: " + dieselTrucks_Arr[k].toString());
                
                    break; 

                case 42:
                    break; 
                case 0:
                    app = false;
                    break;
                
                default:
                    System.out.println("Please input a valid number");
                    break;

            }

            System.out.println("----------------------------------------------------------------------");
        }

        System.out.println("\n\n\n\nThank you for using out app!");

        sc.close();
    }





    // Adds one more place to the array vehicles array
    public static Vehicle[][] addVehicle(Vehicle[][] vehicles, Vehicle[] tempArr, int arrayIndex){
        arrayIndex--;

        if (vehicles[arrayIndex].length != 0){

           // Copy current array into temporary array
            tempArr = new Vehicle[vehicles[arrayIndex].length];

            for(int i =0; i<vehicles[arrayIndex].length;i++){
                tempArr[i] = getVehicle(arrayIndex, vehicles[arrayIndex][i]);
            }                   
            // Modify length of the array
            vehicles[arrayIndex] = getCorrectArray(arrayIndex, tempArr.length + 1);
            
            // Copy over all the objects in the temporary array back into the Electric Truck array
            for(int i =0; i<tempArr.length ;i++){
                vehicles[arrayIndex][i] = getVehicle(arrayIndex, tempArr[i]);
            }
            
        } else{
            vehicles[arrayIndex] = getCorrectArray(arrayIndex, 1);
        }
        return vehicles;
    }
    

    public static Vehicle getVehicle(int arrayIndex, Vehicle vehicle){
        // Returns a vehicle of the correct type

        switch (arrayIndex) {
            case 0:
                return new Electric_Truck((Electric_Truck) vehicle);

            case 1:
                return new Electric_Car((Electric_Car) vehicle);

            case 2:
                return new Diesel_Truck((Diesel_Truck) vehicle);

            case 3: 
                return new Gasoline_Car((Gasoline_Car) vehicle);

            default:// Adding this default because I kept having an error for nothing "MuSt rEturN vEHiclE 🥸" :\
                return new Vehicle();
        }
        
    }

    // Used to modify length of array. Just returns the correct type of array with the length inputted
    public static Vehicle[] getCorrectArray(int arrayIndex, int length){
        switch (arrayIndex) {
            case 0:
                return new Electric_Truck[length];

            case 1:
                return new Electric_Car[length];

            case 2:
                return new Diesel_Truck[length];

            case 3: 
                return new Gasoline_Car[length];

            default:// Adding this default because I kept having an error for nothing "MuSt rEturN vEHiclE 🥸" :\
                return new Vehicle[0];
        }
    }

}
