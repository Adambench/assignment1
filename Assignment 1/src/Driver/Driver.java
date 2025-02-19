package Driver;
import java.util.Scanner;

import Vehicules.*;
import Client.*;

public class Driver {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Array containing all the clients
        Client[] client_Arr = new Client[0];


        // Arrays that contain vehicles. One array for each type
        Electric_Truck[] electricTruck_Arr = new Electric_Truck[0];
        Diesel_Truck[] dieselTrucks_Arr = new Diesel_Truck[0];
        Electric_Car[] electricCars_Arr = new Electric_Car[0];
        Gasoline_Car[] gasolineCars_Arr = new Gasoline_Car[0];

        // The array that stores all client-vehicle relations
        String[] clientVehicle_Arr = new String[0];
        
        
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

        while (app) {
            System.out.println("What would you like to do? \n"
            + "11- Add vehicle \n"
            + "12- Delete vehicle \n"
            + "13- Update vehicle information \n"
            + "14- List all vehicles by category\n"

            + "21- Add client \n"
            + "22- Edit client \n"
            + "23- Delete client \n"

            + "31- Lease vehicle to client \n"
            + "32- Return vehicle from a client \n"
            + "33- Show all vehicles leased by a client \n"
            + "34- Show all leased vehicles (by all clients) \n"

            + "41- Display the truck with the largest capacity \n"
            + "42- Create a copy of the electric trucks array (see below) \n"
            );
            
            System.out.println("Select choice :");
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
                          
                        Electric_Truck eTruck1 = new Electric_Truck(make,model,year,maxAutoRange,maxWeight);
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
                          
                        Electric_Car eCar1 = new Electric_Car(make,model,year,maxAutoRange,maxPassenger);
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
                          
                        Diesel_Truck dTruck1 = new Diesel_Truck(make,model,year,maxWeight,fuelTankCapacity);
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
                          
                        Gasoline_Car gCar1 = new Gasoline_Car(make,model,year,maxPassenger);

                            break;
                        
                        default:
                        
                            break;
                    }

                    break;

                case 12:
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

                case 0:
                    app = false;

            }

            System.out.println("Thank you for using out app!");




        }





        sc.close();
    }







}
