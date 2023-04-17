package controleur;
import java.util.ArrayList;

import modele.ModeleClient;

public class C_Client {
    public static void insertClient(Client unClient) {
		ModeleClient.insertClient(unClient);
		System.out.println("Insertion réussie de l'Client.");
	}

	public static void deleteClient(String email) {
		ModeleClient.deleteClient(email);
	}

	public static void updateClient(Client unClient) {
		ModeleClient.updateClient(unClient);
		System.out.println("Modificiation du client réussie.");
	}

	public static ArrayList<Client> selectAllClient(){
		return ModeleClient.selectAllClient();
	}

}
