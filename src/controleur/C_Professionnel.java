package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleProfessionnel;
import vue.old_vue.VueProfessionnel;

public class C_Professionnel {

	public static void insertProfessionnel () 
	{
		// instancier la classe Professionnel
		Professionnel unProfessionnel = new Professionnel ();
		// saisir les données du Professionnel 
		unProfessionnel = VueProfessionnel.saisirProfessionnel();
		// insérer le Professionnel dans la BDD
		ModeleProfessionnel.insertProfessionnel(unProfessionnel);
		System.out.println("Insertion réussie du Professionnel.");
	}
	
	public static void deleteProfessionnel()
	{
		// Saisir un mail Professionnel
		Scanner sc = new Scanner (System.in);
		String email;
		System.out.println("Donner l'email Professionnel à supprimer :");
		email = sc.next();
		// Supprimer dans la BDD le Professionnel avec cet id
		ModeleProfessionnel.deleteProfessionnel(email);
		System.out.println("Supression réussie du Professionnel.");
	}
	
	public static void updateProfessionnel () 
	{
		// Saisir le mail du Professionnel à modifier 
		Scanner sc = new Scanner (System.in);
		String email; 
		System.out.println("Donner le mail du Professionnel à modifier :");
		email = sc.next();	
		// Récupérer le Professionnel dans la BDD avec cet email
		Professionnel unProfessionnel = ModeleProfessionnel.selectWhereProfessionnel(email);
		// Modifier les infos du Professionnel
		unProfessionnel = VueProfessionnel.modifierProfessionnel(unProfessionnel);
		// Actualiser les infos dans la BDD
		ModeleProfessionnel.updateProfessionnel(unProfessionnel);
		System.out.println("Modification du Professionnel réussie.");
	}
	
	public static void selectAllProfessionnels ()
	{
		ArrayList<Professionnel> lesProfessionnels;
		System.out.println("_____ LISTE DES ProfessionnelS _____");
		
		// On récupère les Professionnels 
		lesProfessionnels = ModeleProfessionnel.selectAllProfessionnel();
		// On parcours l'ArrayList
		for (Professionnel unProfessionnel : lesProfessionnels)
		{
		// On affiche le Professionnel 
			VueProfessionnel.afficherProfessionnel(unProfessionnel);
		}
	}
	
	public static void menuProfessionnel ()
	{
		int choix = 0;
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("_____MENU Professionnel _____");
			System.out.println("1 - Insérer un Professionnel");
			System.out.println("2 - Lister les Professionnels");
			System.out.println("3 - Supprimer un Professionnel");
			System.out.println("4 - Modifier un Professionnel");
			System.out.println("0 - Quitter");
			System.out.println("Votre choix :");
			choix = sc.nextInt();
			switch (choix)
			{
			case 1 : insertProfessionnel(); break;
			case 2 : selectAllProfessionnels(); break;
			case 3 : deleteProfessionnel(); break;
			case 4 : updateProfessionnel(); break;
			
			}
		} while (choix != 0);
	}
}
