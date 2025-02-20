package Client;
import Vehicules.Vehicule;

public class Lease {
    private Client client;
    private Vehicule vehicule;
    private String leaseDate;
    private String returnDate;
    private boolean isActive;

    public Lease(Client client, Vehicule vehicule, String leaseDate, String returnDate) {
        this.client = client;
        this.vehicule = vehicule;
        this.leaseDate = leaseDate;
        this.returnDate = returnDate;
        this.isActive = true; // Lease is active when created
    }

    // Getters
    public Client getClient() { return client; }
    public Vehicule getVehicule() { return vehicule; }
    public String getLeaseDate() { return leaseDate; }
    public String getReturnDate() { return returnDate; }
    public boolean isActive() { return isActive; }

    // Mark lease as completed
    public void completeLease() {
        this.isActive = false;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "Client=" + client.getName() +
                ", Vehicule=" + vehicule.getPlateNumber() +
                ", Lease Date=" + leaseDate +
                ", Return Date=" + returnDate +
                ", Active=" + isActive +
                '}';
    }
}
