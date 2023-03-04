package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleTechnicien;
import vue.old_vue.VueTechnicien;

public class C_Technicien {
	public static void insertTechnicien () 
	{
		// instancier la classe Technicien
		Technicien unTechnicien = new Technicien ();
		// saisir les données du Technicien 
		unTechnicien = VueTechnicien.saisirTechnicien();
		// insérer le Technicien dans la BDD
		ModeleTechnicien.insertTechnicien(unTechnicien);
		System.out.println("Insertion réussie du Technicien.");
	}
	
	public static void deleteTechnicien()
	{
		// Saisir un mail Technicien
		Scanner sc = new Scanner (System.in);
		String email;
		System.out.println("Donner l'email Technicien à supprimer :");
		email = sc.next();
		// Supprimer dans la BDD le Technicien avant cet id
		ModeleTechnicien.deleteTechnicien(email);
		System.out.println("Supression réussie du Technicien.");
	}
	
	public static void updateTechnicien () 
	{
		// Saisir le mail du Technicien à modifier 
		Scanner sc = new Scanner (System.in);
		String email; 
		System.out.println("Donner le mail du Technicien à modifier :");
		email = sc.next();	
		// Récupérer le Technicien dans la BDD avec cet email
		Technicien unTechnicien = ModeleTechnicien.selectWhereTechnicien(email);
		// Modifier les infos du Technicien
		unTechnicien = VueTechnicien.modifierTechnicien(unTechnicien);
		// Actualiser les infos dans la BDD
		ModeleTechnicien.updateTechnicien(unTechnicien);
		System.out.println("Modification du Technicien réussie.");
	}
	
	public static void selectAllTechniciens ()
	{
		ArrayList<Technicien> lesTechniciens;
		System.out.println("_____ LISTE DES TECHNICIENS _____");
		
		// On récupère les Techniciens 
		lesTechniciens = ModeleTechnicien.selectAllTechnicien();
		// On parcours l'ArrayList
		for (Technicien unTechnicien : lesTechniciens)
		{
		// On affiche le Technicien 
			VueTechnicien.afficherTechnicien(unTechnicien);
		}
	}
	
	public static void menuTechnicien ()
	{
		int choix = 0;
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("_____MENU Technicien _____");
			System.out.println("1 - Insérer un Technicien");
			System.out.println("2 - Lister les Techniciens");
			System.out.println("3 - Supprimer un Technicien");
			System.out.println("4 - Modifier un Technicien");
			System.out.println("0 - Quitter");
			System.out.println("Votre choix :");
			choix = sc.nextInt();
			switch (choix)
			{
			case 1 : insertTechnicien(); break;
			case 2 : selectAllTechniciens(); break;
			case 3 : deleteTechnicien(); break;
			case 4 : updateTechnicien(); break;
			
			}
		} while (choix != 0);
	}
}
