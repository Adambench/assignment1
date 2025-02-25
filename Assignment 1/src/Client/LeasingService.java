package Client;

import Vehicles.Vehicle;

public class LeasingService {
    private Lease[] leases = new Lease[0];
    private Lease[] temp;

    public LeasingService() {
        this.leases = new Lease[0];
    }

    // Lease a vehicle to a client
    public void leaseVehicle(Client client, Vehicle vehicle) {
        if (isVehicleLeased(vehicle)) {
            System.out.println("Error: Vehicle " + vehicle.getPlateNumber() + " is already leased.");
            return;
        }

        this.temp = new Lease[leases.length];

        // copy all leases into temporary array
        for (int i =0; i< leases.length; i++){
            this.temp[i] = new Lease(leases[i]);
        }

        // add a place in the lease array
        this.leases = new Lease[temp.length + 1];

        // Copy back all the leases from the temp into the leases array
        for (int i = 0; i<temp.length; i++){
            this.leases[i] = new Lease(temp[i]);
        }

        this.leases[leases.length - 1] = new Lease(client, vehicle);
        System.out.println("Vehicle " + vehicle.getPlateNumber() + " leased to " + client.getName());
    }

    // Return a leased vehicle
    public void returnVehicle(Vehicle vehicle) {
        for (Lease lease : leases) {
            if (lease.getVehicle().getPlateNumber().equals(vehicle.getPlateNumber()) && lease.getIsActive()) {
                lease.completeLease();
                System.out.println("Vehicle " + vehicle.getPlateNumber() + " has been returned.");
                return;
            }
        }
        System.out.println("Error: Vehicle " + vehicle.getPlateNumber() + " was not leased or has already been returned.");
    }

    // Check if a vehicle is currently leased
    public boolean isVehicleLeased(Vehicle vehicle) {
        for (Lease lease : leases) {
            if (lease.getVehicle().equals(vehicle) && lease.getIsActive()) {
                return true;
            }
        }
        return false;
    }

    // Show all vehicles leased by a specific client
    public void showLeasedVehiclesByClient(Client client) {
        System.out.println("Leased vehicles for client: " + client.getName());
        for (Lease lease : leases) {
            if (lease.getClient().equals(client) && lease.getIsActive()) {
                System.out.println(lease);
            }
        }
    }

    // Show all active leases
    public void showAllLeasedVehicles() {
        System.out.println("\n\nAll currently leased vehicles:");
        for (Lease lease : leases) {
            if (lease.getIsActive()) {
                System.out.println(lease);
            }
        }
    }
}
