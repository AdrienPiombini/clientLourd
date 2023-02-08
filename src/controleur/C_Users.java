package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleUsers;
import vue.VueUsers;

public class C_Users {
    public static void insertUser() {
		// instacier la classe Client
		Users unUser = new Users();
		// saisir les donnes du client
		unUser = VueUsers.saisirUser();
		// insérer le client dans la BDD
		ModeleUsers.insertUser(unUser);
		System.out.println("Insertion réussie de l'User.");
	}

	public static void deleteUser() {
		// saisir un idclient
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email a supprimer");
		email = sc.next();
		// supprimer le cliend dans la bdd
		ModeleUsers.deleteUser(email);
	}

	public static void updateUser() {
		// saisir id client a modifier
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email de l'User a modifier");
		email = sc.next();
		// récuperer le client dans la bdd avant cet id
		Users unUser = ModeleUsers.selectWhereUser(email);
		// modifier les infos du client
		unUser = VueUsers.modifierUser(unUser);
		// actualiser les infos dans la bdd
		ModeleUsers.updateUser(unUser);

		System.out.println("Modificiation du client réussie.");
	}

	public static void selectAllUser() {
		ArrayList<Users> lesUsers;
		System.out.println("________LISTE DES USERS__________");
		// on récupère les clients
		lesUsers = ModeleUsers.selectAllUser();
		// on parcours l'ArrayList
		for (Users unUser : lesUsers) {
			// on affiche le client
			VueUsers.afficherUser(unUser);
		}

	}

	public static void menuUser() {

		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU USERS______");
			System.out.println("1- Insérer un User");
			System.out.println("2- Lister les User");
			System.out.println("3- Supprimer un User");
			System.out.println("4- Modifier un User");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 1:
				insertUser();
				break;
			case 2:
				selectAllUser();
				break;
			case 3:
				deleteUser();
				break;
			case 4:
				updateUser();
				break;
			}
		} while (choix != 0);
	}
}
