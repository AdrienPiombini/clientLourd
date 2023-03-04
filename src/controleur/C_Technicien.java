package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleTechnicien;
import vue.old_vue.VueTechnicien;

public class C_Technicien {
	public static void insertTechnicien (Technicien unTechnicien) 
	{
		// insérer le Technicien dans la BDD
		ModeleTechnicien.insertTechnicien(unTechnicien);
		System.out.println("Insertion réussie du Technicien.");
	}

	public static void insertTechnicienCDI (Technicien unTechnicien) 
	{
		// insérer le Technicien dans la BDD
		ModeleTechnicien.insertTechnicienCDI(unTechnicien);
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
	
	public static ArrayList<Technicien> selectAllTechniciens(){
		return ModeleTechnicien.selectAllTechnicien(); 
	}
}
