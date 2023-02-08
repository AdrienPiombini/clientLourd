package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleProduit;
import vue.VueProduit;

public class C_Produit {

	public static void insertProduit () 
	{
		// instancier la classe Produit
		Produit unProduit = new Produit ();
		// saisir les données du Produit 
		unProduit = VueProduit.saisirProduit();
		// insérer le produit dans la BDD
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
	
	public static void selectAllProduits ()
	{
		ArrayList<Produit> lesProduits;
		System.out.println("_____ LISTE DES PRODUITS _____");
		
		// On récupère les produits 
		lesProduits = ModeleProduit.selectAllProduit();
		// On parcours l'ArrayList
		for (Produit unProduit : lesProduits)
		{
		// On affiche le produit 
			VueProduit.afficherProduit(unProduit);
		}
	}
	
	public static void menuProduit ()
	{
		int choix = 0;
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("_____MENU PRODUIT _____");
			System.out.println("1 - Insérer un produit");
			System.out.println("2 - Lister les produits");
			System.out.println("3 - Supprimer un produit");
			System.out.println("4 - Modifier un produit");
			System.out.println("0 - Quitter");
			System.out.println("Votre choix :");
			choix = sc.nextInt();
			switch (choix)
			{
			case 1 : insertProduit(); break;
			case 2 : selectAllProduits(); break;
			case 3 : deleteProduit(); break;
			case 4 : updateProduit(); break;
			
			}
		} while (choix != 0);
	}
}