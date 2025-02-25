package Client;
import Vehicles.Vehicle;

public class Lease {
    private final Client client;
    private final Vehicle vehicle;
    private boolean isActive;

    public Lease(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
        this.isActive = true; // Lease is active when created
    }

    public Lease(Lease lease){
        this.client = lease.client;
        this.vehicle = lease.vehicle;
        this.isActive = lease.isActive; // Lease is active when created
    }

    // Getters
    public Client getClient() { return client; }
    public Vehicle getVehicle() { return vehicle; }
    public boolean getIsActive() { return isActive; }

    // Mark lease as completed
    public void completeLease() {
        this.isActive = false;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "Client=" + client.getName() +
                ", Vehicle=" + vehicle.getPlateNumber() +
                ", Active=" + isActive +
                '}';
    }
}
