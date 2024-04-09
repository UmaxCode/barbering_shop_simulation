package barberingShop.Client;

public class Client {

    private final ClientType clientType;
    private String clientName;


    public Client(ClientType clientType) {
        this.clientType = clientType;
    }

    public ClientType getClientType() {
        return this.clientType;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


}
