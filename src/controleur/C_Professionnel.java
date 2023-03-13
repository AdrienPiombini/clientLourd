package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleProfessionnel;
import vue.old_vue.VueProfessionnel;

public class C_Professionnel {

	public static void insertProfessionnel (Professionnel unProfessionnel) 
	{
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
	
	public static ArrayList<Professionnel> selectAllProfessionnels (){
	return  ModeleProfessionnel.selectAllProfessionnel();
	}

	public static Professionnel selectWhereProfessionnel(String email){
		return ModeleProfessionnel.selectWhereProfessionnel(email);
	}
	
}
