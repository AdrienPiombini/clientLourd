package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleParticulier;
import vue.old_vue.VueParticulier;

public class C_Particulier {
    public static void insertParticulier(Particulier unParticulier) {
		ModeleParticulier.insertParticulier(unParticulier);
		System.out.println("Insertion réussie de l'Particulier.");
	}

	public static void deleteParticulier() {
		// saisir un idclient
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email a supprimer");
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

	public static ArrayList<Particulier> selectAllParticulier() {
		return  ModeleParticulier.selectAllParticulier();
	}

	public static Particulier selectWhereParticulier(String email){
		return ModeleParticulier.selectWhereParticulier(email);
	}
}
