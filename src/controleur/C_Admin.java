package controleur;
import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleAdmin;
import vue.old_vue.VueAdmin;

public class C_Admin {
    public static void insertAdmin(Admin unAdmin) {
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

	public static void updateAdmin(Admin unAdmin) {
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

	public static Admin connexionAdmin(String email, String mdp) {
        return ModeleAdmin.connexionAdmin(email, mdp);
    }

}
