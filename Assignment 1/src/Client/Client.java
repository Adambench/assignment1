package Client;

public class Client {
    private final String id;
    private String name;
    private static int idNumber = 1001;


    public Client(){
        this.name = "No name";
        this.id = "CL" + idNumber;
        idNumber++;
    }

    public Client(String name){
        this.name = name;
        this.id = "CL" + idNumber;
        idNumber++;
    }

    public Client(Client client){
        this.name = client.name;
        this.id = client.id;
    }

    // Getters
    public String getId(){return this.id;}

    public String getName(){return this.name;}


    // Setters
    public void setName(String name){this.name = name;}

    @Override
    public String toString(){
        return "Name : " + this.name + "\n" 
            + "Id : " + this.id;
    }

}
