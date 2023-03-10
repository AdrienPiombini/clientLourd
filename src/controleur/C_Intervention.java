package controleur;

import java.util.ArrayList;
import java.util.Scanner;
import modele.ModeleIntervention;
import vue.old_vue.VueIntervention;

public class C_Intervention {
	public static void insertIntervention(Intervention uneIntervention){
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
		//Intervention uneIntervention = ModeleIntervention.selectWhereIntervention(idIntervention);
		// modifier les infos du Intervention
		//uneIntervention = VueIntervention.modifierIntervention(uneIntervention);
		// actualiser les infos dans la bdd
		//ModeleIntervention.updateIntervention(uneIntervention);

		System.out.println("Modificiation du Intervention réussie.");
	}

	public static ArrayList<Intervention> selectAllInterventions() {
		return  ModeleIntervention.selectAllIntervention();	
	}

	public static Intervention selectWhereIntervention(String dateIntervention, int idClient, int idTechnicien){
		return ModeleIntervention.selectWhereIntervention(dateIntervention, idClient, idTechnicien );
	}
}
