package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleProduit;
import vue.old_vue.VueProduit;

public class C_Produit {

	public static void insertProduit(Produit unProduit){
		ModeleProduit.insertProduit(unProduit);
		System.out.println("Insertion réussie du produit.");
	}
	
	public static void deleteProduit()
	{
		// Saisir un id produit
		Scanner sc = new Scanner (System.in);
		int idProduit;
		System.out.println("Donner l'id produit à supprimer :");
		idProduit = sc.nextInt();
		// Supprimer dans la BDD le produit avec cet id
		ModeleProduit.deleteProduit(idProduit);
		System.out.println("Suppression du produit réussie.");
	}
	
	public static void updateProduit () 
	{
		// Saisir id produit à modifier 
		Scanner sc = new Scanner (System.in);
		int idProduit; 
		System.out.println("Donner l'id produit à modifier :");
		idProduit = sc.nextInt();
		// Récupérer le produit dans la BDD avec cet id
		Produit unProduit = ModeleProduit.selectWhereProduit(idProduit);
		// Modifier les infos du produit
		unProduit = VueProduit.modifierProduit(unProduit);
		// Actualiser les infos dans la BDD
		ModeleProduit.updateProduit(unProduit);
		System.out.println("Modification du produit réussie.");
	}
	
	public static ArrayList<Produit>  selectAllProduits(){
		return ModeleProduit.selectAllProduit();
	}

	public static Produit selectWhereProduit(String nomProduit){
		return ModeleProduit.selectWhereProduit(nomProduit);
	}
}