package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleParticulier;
import vue.VueParticulier;

public class C_Particulier {
    public static void insertParticulier() {
		// instacier la classe Client
		Particulier unParticulier = new Particulier(String email, String mdp, String nom, String adresse, String ville, String cp, int telephone, String prenom);
		// saisir les donnes du client
		unParticulier = VueParticulier.saisirParticulier();
		// insérer le client dans la BDD
		ModeleParticulier.insertParticulier(unParticulier);
		System.out.println("Insertion réussie de l'Particulier.");
	}

	public static void deleteParticulier() {
		// saisir un idclient
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'id a supprimer");
		email = sc.next();
		// supprimer le cliend dans la bdd
		ModeleParticulier.deleteParticulier(email);
	}

	public static void updateParticulier() {
		// saisir id client a modifier
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email de l'Particulier a modifier");
		email = sc.next();
		// récuperer le client dans la bdd avant cet id
		Particulier unParticulier = ModeleParticulier.selectWhereParticulier(email);
		// modifier les infos du client
		unParticulier = VueParticulier.modifierParticulier(unParticulier);
		// actualiser les infos dans la bdd
		ModeleParticulier.updateParticulier(unParticulier);

		System.out.println("Modificiation du client réussie.");
	}

	public static void selectAllParticulier() {
		ArrayList<Particulier> lesParticuliers;
		System.out.println("________LISTE DES PARTICULIERS");
		// on récupère les clients
		lesParticuliers = ModeleParticulier.selectAllParticulier();
		// on parcours l'ArrayList
		for (Particulier unParticulier : lesParticuliers) {
			// on affiche le client
			VueParticulier.afficherParticulier(unParticulier);
		}

	}

	public static void menuParticulier() {

		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU Particulier");
			System.out.println("1- Insérer un Particulier");
			System.out.println("2- Lister les Particulier");
			System.out.println("3- Supprimer un Particulier");
			System.out.println("4- Modifier un Particulier");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 1:
				insertParticulier();
				break;
			case 2:
				selectAllParticulier();
				break;
			case 3:
				deleteParticulier();
				break;
			case 4:
				updateParticulier();
				break;
			}
		} while (choix != 0);
	}
}
