package controleur;

import java.util.ArrayList;
import java.util.Scanner;
import modele.ModeleIntervention;
import vue.VueIntervention;

public class C_Intervention {
	public static void insertIntervention() {
		// instacier la classe Intervention
		Intervention uneIntervention = new Intervention();
		// saisir les donnes du Intervention
		uneIntervention = VueIntervention.saisirIntervention();
		// insérer le Intervention dans la BDD
		ModeleIntervention.insertIntervention(uneIntervention);
		System.out.println("Insertion réussie du Intervention.");
	}

	public static void deleteIntervention() {
		// saisir un idIntervention
		Scanner sc = new Scanner(System.in);
		int idIntervention;
		System.out.println("Donner l'id a supprimer");
		idIntervention = sc.nextInt();
		// supprimer le cliend dans la bdd
		ModeleIntervention.deleteIntervention(idIntervention);
	}

	public static void updateIntervention() {
		// saisir id Intervention a modifier
		Scanner sc = new Scanner(System.in);
		int idIntervention;
		System.out.println("Donner l'id a modifier");
		idIntervention = sc.nextInt();
		// récuperer le Intervention dans la bdd avant cet id
		Intervention uneIntervention = ModeleIntervention.selectWhereIntervention(idIntervention);
		// modifier les infos du Intervention
		uneIntervention = VueIntervention.modifierIntervention(uneIntervention);
		// actualiser les infos dans la bdd
		ModeleIntervention.updateIntervention(uneIntervention);

		System.out.println("Modificiation du Intervention réussie.");
	}

	public static void selectAllInterventions() {
		ArrayList<Intervention> lesInterventions;
		System.out.println("________LISTE DES INTERVENTIONS________");
		// on récupère les Interventions
		lesInterventions = ModeleIntervention.selectAllIntervention();
		// on parcours l'ArrayList
		for (Intervention uneIntervention : lesInterventions) {
			// on affiche le Intervention
			VueIntervention.afficherIntervention(uneIntervention);
		}

	}

	public static void menuIntervention() {

		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU Intervention___");
			System.out.println("1- Insérer un Intervention");
			System.out.println("2- Lister les Intervention");
			System.out.println("3- Supprimer un Intervention");
			System.out.println("4- Modifier un Intervention");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 1:
				insertIntervention();
				break;
			case 2:
				selectAllInterventions();
				break;
			case 3:
				deleteIntervention();
				break;
			case 4:
				updateIntervention();
				break;
			}
		} while (choix != 0);
	}
}
