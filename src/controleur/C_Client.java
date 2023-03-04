package controleur;
import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleClient;
import vue.old_vue.VueClient;

public class C_Client {
    public static void insertClient() {
		// instacier la classe Client
		Client unClient = new Client();
		// saisir les donnes du client
		unClient = VueClient.saisirClient();
		// insérer le client dans la BDD
		ModeleClient.insertClient(unClient);
		System.out.println("Insertion réussie de l'Client.");
	}

	public static void deleteClient() {
		// saisir un idclient
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'id a supprimer");
		email = sc.next();
		// supprimer le cliend dans la bdd
		ModeleClient.deleteClient(email);
	}

	public static void updateClient() {
		// saisir id client a modifier
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email de l'Client a modifier");
		email = sc.next();
		// récuperer le client dans la bdd avant cet id
		Client unClient = ModeleClient.selectWhereClient(email);
		// modifier les infos du client
		unClient = VueClient.modifierClient(unClient);
		// actualiser les infos dans la bdd
		ModeleClient.updateClient(unClient);

		System.out.println("Modificiation du client réussie.");
	}

	public static void selectAllClient() {
		ArrayList<Client> lesClients;
		System.out.println("________LISTE DES CLIENTS_________");
		// on récupère les clients
		lesClients = ModeleClient.selectAllClient();
		// on parcours l'ArrayList
		for (Client unClient : lesClients) {
			// on affiche le client
			VueClient.afficherClient(unClient);
		}

	}

	public static void menuClient() {

		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU Client_____");
			System.out.println("1- Insérer un Client");
			System.out.println("2- Lister les Client");
			System.out.println("3- Supprimer un Client");
			System.out.println("4- Modifier un Client");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 1:
				insertClient();
				break;
			case 2:
				selectAllClient();
				break;
			case 3:
				deleteClient();
				break;
			case 4:
				updateClient();
				break;
			}
		} while (choix != 0);
	}

    public static void insertUsers(Users unUser) {
    }
}
