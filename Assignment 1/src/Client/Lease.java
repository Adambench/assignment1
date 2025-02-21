package Client;
import Vehicles.Vehicle;

public class Lease {
    private Client client;
    private Vehicle vehicle;
    private String leaseDate;
    private String returnDate;
    private boolean isActive;

    public Lease(Client client, Vehicle vehicle, String leaseDate, String returnDate) {
        this.client = client;
        this.vehicle = vehicle;
        this.leaseDate = leaseDate;
        this.returnDate = returnDate;
        this.isActive = true; // Lease is active when created
    }

    public Lease(Lease lease){
        this.client = lease.client;
        this.vehicle = lease.vehicle;
        this.leaseDate = lease.leaseDate;
        this.returnDate = lease.returnDate;
        this.isActive = lease.isActive; // Lease is active when created
    }

    // Getters
    public Client getClient() { return client; }
    public Vehicle getVehicle() { return vehicle; }
    public String getLeaseDate() { return leaseDate; }
    public String getReturnDate() { return returnDate; }
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
                ", Lease Date=" + leaseDate +
                ", Return Date=" + returnDate +
                ", Active=" + isActive +
                '}';
    }
}
