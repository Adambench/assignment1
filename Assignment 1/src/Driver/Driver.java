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

        String clientName;
        String clientId;
        int clientIndex;
        boolean clientFound;

        while (app) {
            System.out.println("What would you like to do? \n\n"
            + "0 - Leave \n\n"

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

                        // adds one more place at the end of the array 
                        vehicles = addVehicle(vehicles, vehicleTypeChoice);

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
                        
                        vehicles = (addVehicle(vehicles, vehicleTypeChoice));

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
                        
                        
                        vehicles = (addVehicle(vehicles, vehicleTypeChoice));

                        // Add the newly added Diesel truck
                        vehicles[2][vehicles[2].length -1] = new Diesel_Truck(make, model, year, fuelTankCapacity, maxWeight);

                        System.out.println("--------------------------------------------------\n"
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

                                               
                        vehicles = (addVehicle(vehicles, vehicleTypeChoice));

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
                    vehicles = removeVehicle(vehicles, plateNumber);
                    break;

                case 13:
                    int indexOfArray = 0;
                    int indexOfVehicle = 0;
                    sc.nextLine();
                    System.out.println("Which vehicle would you like to update? (input plate number)");
                    plateNumber = sc.next();

                    // Get the index of the vehicle with the plate number to modify
                    for (int i = 0; i<4; i++ ){
                        for(int j =0; j<vehicles[i].length; j++){
                            if(vehicles[i][j].getPlateNumber().equals(plateNumber)){
                                indexOfArray = i;
                                indexOfVehicle = j;
                                break;
                            }
                        }
                    }

                    System.out.println("You will now have to input the changes you want to apply to this vehicle:");
                    System.out.println("What is the make (company) of the vehicle: ");
                    make = sc.nextLine();
                    System.out.println("What is the model of the vehicle: ");
                    model = sc.nextLine();
                    System.out.println("What is the year of the vehicle: ");
                    year = sc.nextInt();

                    vehicles[indexOfArray][indexOfVehicle].setMake(make);
                    vehicles[indexOfArray][indexOfVehicle].setModel(model);;
                    vehicles[indexOfArray][indexOfVehicle].setYear(year);

                    switch (indexOfArray) {
                        case 0:
                            System.out.print("Input max auto range : ");
                            maxAutoRange = sc.nextDouble();
                            
                            System.out.print("\nInput max weight : ");
                            maxWeight = sc.nextDouble();

                            vehicles[0][indexOfVehicle].setMaxAutoRange(maxAutoRange);
                            vehicles[0][indexOfVehicle].setMaxWeight(maxWeight);
                            break;

                        case 1:
                            System.out.print("Input max number of passenger : ");
                            maxPassenger = sc.nextInt();

                            System.out.println("\nInput max auto range : ");
                            maxAutoRange = sc.nextDouble();

                            vehicles[1][indexOfVehicle].setMaxPassenger(maxPassenger);
                            vehicles[1][indexOfVehicle].setMaxAutoRange(maxAutoRange);
                            break;

                        case 2:
                            System.out.print("Input max weight : ");
                            maxWeight = sc.nextDouble();

                            System.out.print("\nInput fuel tank capacity : ");
                            fuelTankCapacity = sc.nextDouble();

                            vehicles[2][indexOfVehicle].setMaxWeight(maxWeight);;
                            vehicles[2][indexOfVehicle].setFuelTankCapacity(fuelTankCapacity);;
                            break;

                        case 3:
                            System.out.print("Input max number of passengers : ");
                            maxPassenger = sc.nextInt();

                            vehicles[3][indexOfVehicle].setMaxPassenger(maxPassenger);;
                            break;
                    

                    }

                    System.out.println("\n\nHere is the updated vehicle: \n"
                                    + vehicles[indexOfArray][indexOfVehicle]);

                    break;


                case 14:
                    for(int i =0; i< 4; i++){
                        for(int j = 0; j < vehicles[i].length; j++) {
                            System.out.println(vehicles[i][j]);
                        }
                        System.out.println("________________________________________________________");
                    }
                    break;


                case 21:
                    System.out.println("Input the name of the client you would like to add: ");
                    clientName = sc.nextLine();

                    // Adds a place in the client array
                    client_Arr = addClient(client_Arr);

                    client_Arr[client_Arr.length -1] = new Client(clientName);

                    System.out.println("New client added : \n" + client_Arr[client_Arr.length -1]);
                    break; 

                case 22:
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
                    break;

                case 23:
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
                for (int i=0; i < vehicles[0].length;i++ ){
                    if (vehicles[0][i].getMaxWeight() > vehicles[0][j].getMaxWeight()) j=i;
                }
                for (int i=0; i < vehicles[2].length;i++ ){
                    if (vehicles[2][i].getMaxWeight() > vehicles[2][k].getMaxWeight()) k=i;
                }
                // Yo btw t'a pas besoin d'ecrire .toString() cette methode va etre called by defaut quand tu le mets
                // dans un system.out.print() function
                if (vehicles[0][j].getMaxWeight()>vehicles[0][k].getMaxWeight()) {
                    System.out.println("The truck with the largest capacity is: " + vehicles[0][j].toString());
                } else {
                    System.out.println("The truck with the largest capacity is: " + vehicles[2][k].toString());
                } 
                
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

        System.out.println("\n\n\n\nThank you for using our app!");

        sc.close();
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
        resultingArray[1] = new Electric_Car[vehicles[0].length];
        resultingArray[2] = new Diesel_Truck[vehicles[0].length];
        resultingArray[3] = new Gasoline_Car[vehicles[0].length];


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
