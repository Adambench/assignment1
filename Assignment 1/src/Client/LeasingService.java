package Client;

import Vehicles.Vehicle;

public class LeasingService {
    private Lease[] leases;
    private int leaseCount;

    public LeasingService(int maxLeases) {
        this.leases = new Lease[maxLeases];
        this.leaseCount = 0;
    }

    // Lease a vehicle to a client
    public void leaseVehicule(Client client, Vehicle vehicle, String leaseDate, String returnDate) {
        if (isVehiculeLeased(vehicle)) {
            System.out.println("Error: Vehicle " + vehicle.getPlateNumber() + " is already leased.");
            return;
        }

        if (leaseCount >= leases.length) {
            System.out.println("Error: Maximum number of leases reached.");
            return;
        }

        leases[leaseCount] = new Lease(client, vehicle, leaseDate, returnDate);
        leaseCount++;
        System.out.println("Vehicule " + vehicle.getPlateNumber() + " leased to " + client.getName());
    }

    // Return a leased vehicle
    public void returnVehicle(Vehicle vehicule) {
        for (int i = 0; i < leaseCount; i++) {
            if (leases[i].getVehicle().equals(vehicule) && leases[i].isActive()) {
                leases[i].completeLease();
                System.out.println("Vehicle " + vehicule.getPlateNumber() + " has been returned.");
                return;
            }
        }
        System.out.println("Error: Vehicle " + vehicule.getPlateNumber() + " was not leased or has already been returned.");
    }

    // Check if a vehicle is currently leased
    public boolean isVehiculeLeased(Vehicle vehicule) {
        for (int i = 0; i < leaseCount; i++) {
            if (leases[i].getVehicle().equals(vehicule) && leases[i].isActive()) {
                return true;
            }
        }
        return false;
    }

    // Show all vehicles leased by a specific client
    public void showLeasedVehiculesByClient(Client client) {
        System.out.println("Leased vehicules for client: " + client.getName());
        for (int i = 0; i < leaseCount; i++) {
            if (leases[i].getClient().equals(client) && leases[i].isActive()) {
                System.out.println(leases[i]);
            }
        }
    }

    // Show all active leases
    public void showAllLeasedVehicules() {
        System.out.println("All currently leased vehicules:");
        for (int i = 0; i < leaseCount; i++) {
            if (leases[i].isActive()) {
                System.out.println(leases[i]);
            }
        }
    }
}
