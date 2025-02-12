package Client;

public class Client {
    private String id;
    private String name;
    private static int idNumber = 1000;


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

    public String getId(){return this.id;}

    public String getName(){return this.name;}

    public void setName(String name){this.name = name;}


}
