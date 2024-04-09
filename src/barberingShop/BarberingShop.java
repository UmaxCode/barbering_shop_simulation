package barberingShop;

import barberingShop.Client.Client;
import barberingShop.Client.ClientType;

import java.util.ArrayList;

public class BarberingShop {

    private static String operationPerformed;
    private final ArrayList<Client> chairs;

    private int assignVIPIdentity;
    private int assignORDIdentity;

    public BarberingShop() {
        this.chairs = new ArrayList<>();
    }

    public void receiveClient(Client client) {

        // when both main and waiting chairs are empty
        if (this.chairs.isEmpty()) {
            if (client.getClientType() == ClientType.VIP) {
                ++assignVIPIdentity;
                client.setClientName("VIP" + assignVIPIdentity);
            } else {
                ++assignORDIdentity;
                client.setClientName("ORD" + assignORDIdentity);
            }

            this.chairs.add(client);
            operationPerformed = "++ " + client.getClientName();
            return;
        }

        // when all chairs (main and waiting)  are occupied
        if (this.chairs.size() == 6) {
            client.setClientName((client.getClientType() == ClientType.VIP) ? "VIP" + (assignVIPIdentity + 1) : "ORD" + (assignORDIdentity + 1));
            operationPerformed = "+- " + client.getClientName();

            return;
        }

        // when main chair is occupied but there are/is waiting chair(s)
        if (client.getClientType() == ClientType.VIP) {
            assignVIPIdentity++;
            client.setClientName("VIP" + assignVIPIdentity);
            this.chairs.add(findIndexOfLastVIPClient(), client);

        } else {
            assignORDIdentity++;
            client.setClientName("ORD" + assignORDIdentity);
            this.chairs.add(client);
        }

        operationPerformed = "++ " + client.getClientName();
    }

    private int findIndexOfLastVIPClient() {

        // when vip is in the queue, find the last vip and join behind
        for (int i = chairs.size() - 1; i >= 1; i--) {
            if (chairs.get(i).getClientType() == ClientType.VIP) {
                return i + 1;
            }
        }

        // when no vip client is in the queue
        return 1;
    }

    public void clientServiced() {
        if (!this.chairs.isEmpty()) {  // no need to render barbering service when chairs (main and waiting) are empty
            Client client = this.chairs.removeFirst();
            operationPerformed = "-- " + client.getClientName();
            return;
        }

        operationPerformed = "No client";
    }

    private String makeFormattedArray() {

        String[] array = {"----", "----", "----", "----", "----", "----"};
        int len = this.chairs.size();
        for (int i = 0; i < len; i++) {
            array[i] = this.chairs.get(i).getClientName();
        }
        return String.join(" : ", array);
    }

    public String returnResult(int rand) {

        return String.format(" %d  ---->   ( %s )      [  %s  ]", rand, operationPerformed, makeFormattedArray());
    }

}
