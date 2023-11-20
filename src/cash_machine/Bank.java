package cash_machine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class represents a bank, its list of clients and related functionality.
 * Each client has ID, PIN, current account and saving account.
 *
 * @author Martin Dekanovský
 */
public class Bank {

    private static List<Client> clients = new ArrayList<>();

    /**
     * Constructor for creating a bank and getting its list of clients present in txt file.
     *
     * @throws FileNotFoundException
     */
    public Bank() throws FileNotFoundException {
        try {
            FileReader reader = new FileReader("clients.txt");
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                clients.add(new Client(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble()));
            }
            reader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for finding the client, e.i., checking whether the client even exists.
     *
     * @param ID client ID to search for.
     * @return the Client or null if client with such ID does not exist.
     */
    public Client findClient(int ID) {
        for (Client client : clients) {
            if (client.getID() == ID) {
                return client;
            }
        }
        return null;
    }

    /**
     * Method for updating the list of clients present in txt file. The list is updated after the client logs out.
     *
     * @param clientToUpdate Client to be updated.
     * @throws FileNotFoundException
     */
    public static void updateClientList(Client clientToUpdate) throws FileNotFoundException {
        clients.set(clientToUpdate.getID() - 10000, clientToUpdate);
        PrintWriter writer = new PrintWriter("clients.txt");
        StringBuilder updatedClientList = new StringBuilder();
        for (Client client : clients) {
            updatedClientList.append(client).append("\n");
        }
        writer.print(String.valueOf(updatedClientList).trim());
        writer.close();
    }
}