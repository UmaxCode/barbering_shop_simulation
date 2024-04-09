import barberingShop.BarberingShop;
import barberingShop.Client.Client;
import barberingShop.Client.ClientType;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        BarberingShop barberingShop = new BarberingShop();

        ArrayList<String> finalSimulationResult = new ArrayList<>();
        finalSimulationResult.add(
                "|----x----|----Events----|----------------State of the Shop------------------|"
        );

        Scanner scanner = new Scanner(System.in);

        System.out.print("Press space key to continue and any other key to quit: ");
        String keyPressed = scanner.nextLine();

        while (keyPressed.equals(" ")) {

            int randomNumber = (int) Math.floor(Math.random() * 3);

            Client client = null;

            if (randomNumber == 0) {
                barberingShop.clientServiced();
            } else if (randomNumber == 1) {
                client = new Client(ClientType.VIP);
            } else {
                client = new Client(ClientType.ORD);
            }

            if (client != null) { // can't receive a client (VIP / ORD) who hasn't entered the shop
                barberingShop.receiveClient(client);
            }


            String result = barberingShop.returnResult(randomNumber);
            finalSimulationResult.add(result);

            System.out.println(result);
            System.out.println();

            System.out.print("Press space key to continue and any other key to quit: ");
            keyPressed = scanner.nextLine();

        }

        if (finalSimulationResult.size() > 1) {  // output final simulation result
            for (String eachResult : finalSimulationResult) {
                System.out.println(eachResult);

            }
        }


    }
}