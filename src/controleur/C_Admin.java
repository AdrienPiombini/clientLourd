package controleur;
import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleAdmin;
import vue.old_vue.VueAdmin;

public class C_Admin {
    public static void insertAdmin() {
		// instacier la classe Client
		Admin unAdmin = new Admin();
		// saisir les donnes du client
		unAdmin = VueAdmin.saisirAdmin();
		// insérer le client dans la BDD
		ModeleAdmin.insertAdmin(unAdmin);
		System.out.println("Insertion réussie de l'admin.");
	}

	public static void deleteAdmin() {
		// saisir un idclient
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email de l'admin a supprimer");
		email = sc.next();
		// supprimer le cliend dans la bdd
		ModeleAdmin.deleteAdmin(email);
	}

	public static void updateAdmin() {
		// saisir id client a modifier
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email de l'admin a modifier");
		email = sc.next();
		// récuperer le client dans la bdd avant cet id
		Admin unAdmin = ModeleAdmin.selectWhereAdmin(email);
		// modifier les infos du client
		unAdmin = VueAdmin.modifierAdmin(unAdmin);
		// actualiser les infos dans la bdd
		ModeleAdmin.updateAdmin(unAdmin);

		System.out.println("Modificiation de l'admin réussie.");
	}

	public static void selectAllAdmin() {
		ArrayList<Admin> lesAdmins;
		System.out.println("________LISTE DES ADMINS_________");
		// on récupère les clients
		lesAdmins = ModeleAdmin.selectAllAdmin();
		// on parcours l'ArrayList
		for (Admin unAdmin : lesAdmins) {
			// on affiche le client
			VueAdmin.afficherAdmin(unAdmin);
		}

	}

	public static void menuAdmin() {

		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU ADMIN");
			System.out.println("1- Insérer un admin");
			System.out.println("2- Lister les admin");
			System.out.println("3- Supprimer un admin");
			System.out.println("4- Modifier un admin");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 1:
				insertAdmin();
				break;
			case 2:
				selectAllAdmin();
				break;
			case 3:
				deleteAdmin();
				break;
			case 4:
				updateAdmin();
				break;
			}
		} while (choix != 0);
	}
}
