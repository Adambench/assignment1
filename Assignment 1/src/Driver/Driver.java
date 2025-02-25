package Driver;
/*
 * Assignment 1
 * Written by: Mountaga Sy 40312584 and Adam Benchekroun 40306874
 * 
 * This Java program is a vehicle leasing management system for RoyalRentals, allowing employees to lease vehicles to clients, 
 * process returns, and view leased vehicles. It features a text-based menu where users can select clients, choose available 
 * vehicles, and input lease and return dates. The system supports leasing operations, returning vehicles,
 *  displaying all leased vehicles, and viewing leases by specific clients. It uses arrays to manage clients, vehicles, and leases,
 *  and handles user input through the Java Scanner
 */
import Client.*;
import Vehicles.*;
import java.util.Scanner;

public class Driver {
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        LeasingService leases = new LeasingService();
        
        
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
        
        // System variables
        boolean app = true;
        int choice;
        int vehicleTypeChoice;
        
        // Vehicle variables
        String make;
        String model;
        int year;
        double maxAutoRange;
        int maxPassenger;
        double maxWeight;
        double fuelTankCapacity;
        String plateNumber;
        boolean vehicleFound;
        
        // Client variables
        String clientName;
        String clientId;
        int clientIndex;
        boolean clientFound;

        System.out.print("Type 1 to choose your own vehicles & clients, type 2 to see the output of the hard-coded scenario.");
        choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                while (app) {
                    System.out.println("""
                                       What would you like to do? 
                                       
                                       0 - Leave 
                                       
                                       11- Add vehicle 
                                       12- Delete vehicle 
                                       13- Update vehicle information 
                                       14- List all vehicles by category
                                       
                                       21- Add client 
                                       22- Edit client 
                                       23- Delete client 
                                       
                                       31- Lease vehicle to client 
                                       32- Return vehicle from a client 
                                       33- Show all vehicles leased by a client 
                                       34- Show all leased vehicles (by all clients) 
                                       
                                       41- Display the truck with the largest capacity 
                                       42- Create a copy of the electric trucks array (see below) 
                                       """);
                    
                    System.out.print("Select choice :");
                    choice = sc.nextInt();
                    sc.nextLine();
                    
                    switch (choice) {
                        case 11 -> {
                            System.out.println("""
                                               Which type of vehicle would you like to add? 
                                               1. Electric truck 
                                               2. Electric Car 
                                               3. Diesel truck 
                                               4. Gasoline car 
                                               """);
                            vehicleTypeChoice = sc.nextInt();

                            switch (vehicleTypeChoice) {
                                case 1 -> {
                                    // Get all the necessary inputs
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
                                    
                                    // adds one more place at the end of the array
                                    vehicles = addVehicle(vehicles, vehicleTypeChoice);
                                    
                                    // Add the newly added Electric Truck
                                    vehicles[0][vehicles[0].length -1] = new Electric_Truck(make, model, year, maxAutoRange, maxWeight);
                                    
                                    System.out.println("The following Electric Truck was just added: \n"
                                            +vehicles[0][vehicles[0].length -1] + "\n");
                                }
                                
                                case 2 -> {
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
                                    
                                    vehicles = (addVehicle(vehicles, vehicleTypeChoice));
                                    
                                    // Add the newly added Electric Car
                                    vehicles[1][vehicles[1].length -1] = new Electric_Car(make, model, year, maxAutoRange, maxPassenger);
                                    
                                    System.out.println("The following Electric Car was just added: \n"
                                            +vehicles[1][vehicles[1].length -1] + "\n");
                                }
                                
                                
                                case 3 -> {
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
                                    
                                    
                                    vehicles = (addVehicle(vehicles, vehicleTypeChoice));
                                    
                                    // Add the newly added Diesel truck
                                    vehicles[2][vehicles[2].length -1] = new Diesel_Truck(make, model, year, fuelTankCapacity, maxWeight);
                                    
                                    System.out.println("""
                                                       --------------------------------------------------
                                                       The following Diesel Truck was just added: 
                                                       """
                                            +vehicles[2][vehicles[2].length -1] + "\n");
                                }
                                
                                case 4 -> {
                                    sc.nextLine();
                                    System.out.println("What is the make (company) of the gasoline car: ");
                                    make = sc.nextLine();
                                    System.out.println("What is the model of the gasoline car: ");
                                    model = sc.nextLine();
                                    System.out.println("What is the year of the gasoline car: ");
                                    year = sc.nextInt();
                                    System.out.println("What is the maximum number of passenger of the gasoline car: ");
                                    maxPassenger = sc.nextInt();
                                    
                                    
                                    vehicles = (addVehicle(vehicles, vehicleTypeChoice));
                                    
                                    // Add the newly added Gasoline Car
                                    vehicles[3][vehicles[3].length -1] = new Gasoline_Car(make, model, year, maxPassenger);
                                    
                                    System.out.println("The following Gasoline Car was just added: \n"
                                            +vehicles[3][vehicles[3].length -1] + "\n");
                                }  
                            }
                        }
        
                    case 12 -> {
                        System.out.println("Enter the plate number of the vehicle you would like to delete: ");
                        plateNumber = sc.nextLine();
                        vehicles = removeVehicle(vehicles, plateNumber);
                        }
        
                    case 13 -> {
                        int indexOfArray = 0;
                        int indexOfVehicle = 0;
                        vehicleFound = false;
        
                        sc.nextLine();
                        System.out.println("Which vehicle would you like to update? (input plate number)");
                        plateNumber = sc.next();
        
                        // Get the index of the vehicle with the plate number to modify
                        for (int i = 0; i<4; i++ ){
                            for(int j =0; j<vehicles[i].length; j++){
                                if(vehicles[i][j].getPlateNumber().equals(plateNumber)){
                                    indexOfArray = i;
                                    indexOfVehicle = j;
                                    vehicleFound = true;
                                    break;
                                }
                            }
                        }
        
                        if (!vehicleFound){
                            System.out.print("No vehicle found with this plate number!");
                            return;
                        }
        
                        System.out.println("You will now have to input the changes you want to apply to this vehicle:");
                        System.out.println("What is the make (company) of the vehicle: ");
                        make = sc.nextLine();
                        System.out.println("What is the model of the vehicle: ");
                        model = sc.nextLine();
                        System.out.println("What is the year of the vehicle: ");
                        year = sc.nextInt();
        
                        vehicles[indexOfArray][indexOfVehicle].setMake(make);
                        vehicles[indexOfArray][indexOfVehicle].setModel(model);
                        vehicles[indexOfArray][indexOfVehicle].setYear(year);
        
                        switch (indexOfArray) {
                            case 0 -> {
                                System.out.print("Input max auto range : ");
                                maxAutoRange = sc.nextDouble();
                                
                                System.out.print("\nInput max weight : ");
                                maxWeight = sc.nextDouble();
        
                                vehicles[0][indexOfVehicle].setMaxAutoRange(maxAutoRange);
                                vehicles[0][indexOfVehicle].setMaxWeight(maxWeight);
                            }
        
                            case 1 -> {
                                System.out.print("Input max number of passenger : ");
                                maxPassenger = sc.nextInt();
        
                                System.out.println("\nInput max auto range : ");
                                maxAutoRange = sc.nextDouble();
        
                                vehicles[1][indexOfVehicle].setMaxPassenger(maxPassenger);
                                vehicles[1][indexOfVehicle].setMaxAutoRange(maxAutoRange);
                            }
        
                            case 2 -> {
                                System.out.print("Input max weight : ");
                                maxWeight = sc.nextDouble();
        
                                System.out.print("\nInput fuel tank capacity : ");
                                fuelTankCapacity = sc.nextDouble();
        
                                vehicles[2][indexOfVehicle].setMaxWeight(maxWeight);
                                vehicles[2][indexOfVehicle].setFuelTankCapacity(fuelTankCapacity);
                            }
        
                            case 3 -> {
                                System.out.print("Input max number of passengers : ");
                                maxPassenger = sc.nextInt();
        
                                vehicles[3][indexOfVehicle].setMaxPassenger(maxPassenger);
                            }
                                
                                
                        }
                        
                        System.out.println("\n\nHere is the updated vehicle: \n"
                                + vehicles[indexOfArray][indexOfVehicle]);
                        }
        
        
                    case 14 -> {
                        for(int i =0; i< 4; i++){
                            for (Vehicle vehicle : vehicles[i]) {
                                System.out.println(vehicle);
                            }
                            System.out.println("________________________________________________________");
                        }
                        }
        
        
                    case 21 -> {
                        System.out.println("Input the name of the client you would like to add: ");
                        clientName = sc.nextLine();
        
                        // Adds a place in the client array
                        client_Arr = addClient(client_Arr);
        
                        client_Arr[client_Arr.length -1] = new Client(clientName);
        
                        System.out.println("New client added : \n" + client_Arr[client_Arr.length -1]);
                        } 
        
                    case 22 -> {
                        clientIndex = 0;
                        clientFound = false;
        
                        System.out.print("Input the id of the client to change : ");
                        clientId = sc.nextLine();
        
                        for (int i = 0; i<client_Arr.length; i++){
                            if (client_Arr[i].getId().equals(clientId)){
                                clientIndex = i;
                                break;
                            }
                        }
                        if(clientFound){
                            System.out.println("Input new name : ");
                            clientName = sc.nextLine();
        
                            client_Arr[clientIndex].setName(clientName);
        
                            System.out.println("Here is the updated client: \n" + client_Arr[clientIndex]);
                        } else{
                            System.out.println("Client not found !");
                        }
                        }
        
                    case 23 -> {
                        if(client_Arr.length != 0){
                            clientFound = false;
                            clientIndex = 0;
        
                            System.out.print("Please input the id of the client to delete : ");
                            clientId = sc.nextLine();
        
                            for (int i = 0; i<client_Arr.length; i++){
                                if (client_Arr[i].getId().equals(clientId)){
                                    clientIndex = i;
                                    clientFound = true;
                                    break;
                                }
                            }
        
                            if (clientFound){
                                client_Arr = removeClient(client_Arr, clientIndex);
                                System.out.println("Client Successfully deleted!");
                            } else {
                                System.out.println("Client not found !");
                            }
                        } else {
                            System.out.println("There are not clients to remove! (yet)");
                        }
                        }
        
        
                    case 31 -> {
                        clientFound = false;
                        clientIndex = 0;
        
                        int indexOfArray = 0;
                        int indexOfVehicle = 0;
                        vehicleFound = false;
        
                        // Get plate number
                        System.out.print("Enter the vehicle plate number : ");
                        plateNumber = sc.nextLine();
        
                        // Get client ID
                        System.out.print("Enter the Id of the client : ");
                        clientId = sc.nextLine();
                        
                        // Get index of client
                        for (int i = 0; i<client_Arr.length; i++){
                            if (client_Arr[i].getId().equals(clientId)){
                                clientIndex = i;
                                clientFound = true;
                                break;
                            }
                        }
        
                        if(!clientFound){
                            System.out.print("Client not found!");
                            return;
                        }
        
                        // Get the index of the vehicle with the plate number
                        for (int i = 0; i<4; i++ ){
                            for(int j =0; j<vehicles[i].length; j++){
                                if(vehicles[i][j].getPlateNumber().equals(plateNumber)){
                                    indexOfArray = i;
                                    indexOfVehicle = j;
                                    vehicleFound = true;
                                    break;
                                }
                            }
                        }
        
                        if (!vehicleFound){
                            System.out.print("No vehicle found with this plate number!");
                            return;
                        }
                        leases.leaseVehicle(client_Arr[clientIndex], vehicles[indexOfArray][indexOfVehicle]);
        
                    }
        
                    case 32 -> {
                        int indexOfArray = 0;
                        int indexOfVehicle = 0;
                        vehicleFound = false;
        
                        System.out.println("Which vehicle would you like to return ? (enter plate number)");
                        plateNumber = sc.nextLine();
        
                        // Get the index of the vehicle with the plate number
                        for (int i = 0; i<4; i++ ){
                            for(int j =0; j<vehicles[i].length; j++){
                                if(vehicles[i][j].getPlateNumber().equals(plateNumber)){
                                    indexOfArray = i;
                                    indexOfVehicle = j;
                                    vehicleFound = true;
                                    break;
                                }
                            }
                        }
                    
                        if (!vehicleFound){
                            System.out.print("No vehicle found with this plate number!");
                            return;
                        }
        
                        leases.returnVehicle(vehicles[indexOfArray][indexOfVehicle]);
                        }
        
                    case 33 -> {
                        clientFound = false;
                        clientIndex = 0;
        
                        System.out.println("Which client's lease(s) would you like to see? (enter client ID)");
                        clientId = sc.nextLine();
                        
                        // Get index of client
                        for (int i = 0; i<client_Arr.length; i++){
                            if (client_Arr[i].getId().equals(clientId)){
                                clientIndex = i;
                                clientFound = true;
                                break;
                            }
                        }
                    
                        if(!clientFound){
                            System.out.print("Client not found!");
                            return;
                        }
        
                        leases.showLeasedVehiclesByClient(client_Arr[clientIndex]);
                    }
        
                    case 34 -> {
                        leases.showAllLeasedVehicles();
                        }  
                    
                
                    case 41 -> {
                        getLargestTruck(vehicles);
                        } 
        
                    case 42 -> {
                         copyVehicles(vehicles);
                        } 
        
                    case 0 -> app = false;
                    
                    default -> System.out.println("Please input a valid number");
        
                }
        
                System.out.println("----------------------------------------------------------------------");
            }
        
            System.out.println("\n\n\n\nThank you for using our app!");
        
            sc.close();
            
            } // End of app :)


            // Hard coded scenario
            case 2 -> {

            }
            default -> System.out.println("Input a valid number");
        }
    }
        


    // Return a new client array with one more in length
    public static Client[] addClient(Client[] clientArr){
        
        // Create temp array that is one space bigger than client array
        Client[] temp = new Client[clientArr.length + 1];

        // Copy clients over to temp array
        for (int i = 0; i< clientArr.length; i++){
            temp[i] = new Client(clientArr[i]);
        }

        return temp;
    }


    public static Client[] removeClient(Client[] client_Arr, int clientIndex){
        Client [] temp = new Client[client_Arr.length -1];
    
        client_Arr[clientIndex] = null;

        // Copy everything into client array except client to delete
        for (int i = 0; i<temp.length; i++){
            if(client_Arr[i] != null){
                temp[i] = new Client(client_Arr[i]);
            }
        }

        // If the client to delete is not the last one, copy it (the last client in the array)
        // into the spot left empty in the temp array
        if(clientIndex != (client_Arr.length-1)){
            temp[clientIndex] = client_Arr[client_Arr.length -1];
        }

        return temp;
    }

    



    // Adds one more place to the array vehicles array
    public static Vehicle[][] addVehicle(Vehicle[][] vehicles, int arrayIndex){
        arrayIndex--;

        if (vehicles[arrayIndex].length != 0){

           // Copy current array into temporary array
            Vehicle[] resultingArray = new Vehicle[vehicles[arrayIndex].length];

            for(int i =0; i<vehicles[arrayIndex].length;i++){
                resultingArray[i] = getVehicle(arrayIndex, vehicles[arrayIndex][i]);
            }                   
            // Modify length of the array
            vehicles[arrayIndex] = getCorrectArray(arrayIndex, resultingArray.length + 1);
            
            // Copy over all the objects in the temporary array back into the Electric Truck array
            for(int i =0; i<resultingArray.length ;i++){
                vehicles[arrayIndex][i] = getVehicle(arrayIndex, resultingArray[i]);
            }
            
        } else{
            vehicles[arrayIndex] = getCorrectArray(arrayIndex, 1);
        }
        return vehicles;
    }


    public static Vehicle[][] removeVehicle(Vehicle[][] vehicles, String plateNumber){
        int indexOfArray = 0;
        int indexOfVehicle = 0;
        boolean vehicleFound = false;

        // Create a 2D Result Array and initialize it
        Vehicle[][] resultingArray = new Vehicle[4][];

        resultingArray[0] = new Electric_Truck[vehicles[0].length];
        resultingArray[1] = new Electric_Car[vehicles[1].length];
        resultingArray[2] = new Diesel_Truck[vehicles[2].length];
        resultingArray[3] = new Gasoline_Car[vehicles[3].length];


        // Get the index of the vehicle with the plate number to delete
        for (int i = 0; i<4; i++ ){
            for(int j =0; j<vehicles[i].length; j++){
                if(vehicles[i][j].getPlateNumber().equals(plateNumber)){
                    indexOfArray = i;
                    indexOfVehicle = j;
                    vehicleFound = true;
                    break;
                }
            }
        }

        // If we find the vehicle to delete, then copy everything into the result array except that vehicle
        if (vehicleFound){

            vehicles[indexOfArray][indexOfVehicle] = null;
            resultingArray[indexOfArray] = getCorrectArray(indexOfArray, vehicles[indexOfArray].length -1);

            // Copy all the vehicles from the vehicles array into the result array
            for (int i = 0; i < 4; i++){
                for (int j = 0; j<resultingArray[i].length; j++){
                    if (vehicles[i][j] != null){
                        resultingArray[i][j] = getVehicle(i, vehicles[i][j]);
                    }
                }
            }
            /*
             * By default, when copying from the vehicles array to the result array, the last element of the array
             * of whichever type of vehicle we are trying to delete will not get copied. If we are trying to delete an 
             * element that is not the last element of the array, then the last element of the array will not get copied 
             * and two elements will be removed. There will also be an empty element in the resulting array.
             * 
             * Therefore the following line takes in the last element of the array in which we are trying to delete an element
             * and copies it into the empty slot of the resulting array. That way, no additional element is lost besides the 
             * element we are trying to delete
             * 
             * This line runs only if the element we are trying to delete is NOT in the last place of it's subarray
             */

            if(resultingArray[indexOfArray].length != indexOfVehicle){ 
                // This line gets run if the vehicle we want to remove is not the last element of it's array
                resultingArray[indexOfArray][indexOfVehicle] = getVehicle(indexOfArray, vehicles[indexOfArray][vehicles[indexOfArray].length-1]);
            }
            return resultingArray;

        } else {
            System.out.println("Error : plate number inexistant. Plate number :" + plateNumber);
            return vehicles;
        }

    }
    

    public static Vehicle getVehicle(int arrayIndex, Vehicle vehicle){
        // Returns a vehicle of the correct type
        return switch (arrayIndex) {
            case 0 -> new Electric_Truck((Electric_Truck) vehicle);
            case 1 -> new Electric_Car((Electric_Car) vehicle);
            case 2 -> new Diesel_Truck((Diesel_Truck) vehicle);
            case 3 -> new Gasoline_Car((Gasoline_Car) vehicle);
            default -> new Vehicle();
        }; // Adding this default because I kept having an error for nothing "MuSt rEturN vEHiclE 🥸" :\
        
    }


    // Used to modify length of array. Just returns the correct type of array with the length inputted
    public static Vehicle[] getCorrectArray(int arrayIndex, int length){
        return switch (arrayIndex) {
            case 0 -> new Electric_Truck[length];
            case 1 -> new Electric_Car[length];
            case 2 -> new Diesel_Truck[length];
            case 3 -> new Gasoline_Car[length];
            default -> new Vehicle[0]; // Adding this default because I kept having an error for nothing "MuSt rEturN vEHiclE 🥸" :\
        }; 
    }
    
    public static void getLargestTruck(Vehicle[][] vehicles){
        int k=0;  
        for (int i=0; i < vehicles[2].length;i++ ){
            if (vehicles[2][i].getMaxWeight() > vehicles[2][k].getMaxWeight()) k=i;
        }
        System.out.println("The truck with the largest capacity is: " + vehicles[2][k]);
        
    }
   public static void copyVehicles(Vehicle[][] vehicles) {
        Vehicle[] copyElectric_Trucks = new Vehicle[vehicles[0].length];
        for (int i=0;i<vehicles[0].length;i++){
            copyElectric_Trucks[i]= vehicles[0][i];
        }
      System.out.println("All electric trucks have been copied successfully!");
    }

}


