package vue;

import java.util.Scanner;

import controleur.Produit;

public class VueProduit {

	public static Produit saisirProduit ()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Donner le nom produit :");
		String nomProduit = sc.next();
		System.out.println("Donner le prix du produit :");
		float prixProduit = sc.nextFloat();
		System.out.println("Donner la description du produit :");
		String description = sc.next();
		System.out.println("Donner la quantite du produit :");
		int quantite = sc.nextInt();
		// Instanciation de la classe Produit
		Produit unProduit = new Produit(nomProduit, prixProduit, description, quantite);
		return unProduit;
	}
	
	public static void afficherProduit(Produit unProduit)
	{
		System.out.println("ID Produit : " +unProduit.getIdProduit());
		System.out.println("Nom du produit : " +unProduit.getNomProduit());
		System.out.println("Prix du produit : " +unProduit.getPrixProduit());
		System.out.println("Descrption du produit : " +unProduit.getDescription());
		System.out.println("Quantité du produit : " +unProduit.getQuantite());
	}
	
	public static Produit modifierProduit (Produit unProduit)
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Ancien nom du produit :" +unProduit.getNomProduit());
		System.out.println("Donner le nouveau nom du produit : ");
		unProduit.setNomProduit(sc.next());
		
		System.out.println("Ancien prix du produit :" +unProduit.getPrixProduit());
		System.out.println("Donner le nouveau prix du produit : ");
		unProduit.setPrixProduit(sc.nextFloat());
		
		System.out.println("Ancienne description du produit :" +unProduit.getDescription());
		System.out.println("Donner la nouvelle description du produit : ");
		unProduit.setDescription(sc.next());
		
		System.out.println("Ancienne quantité produit :" +unProduit.getQuantite());
		System.out.println("Donner la nouvelle quantité produit : ");
		unProduit.setQuantite(sc.nextInt());
		
		return unProduit;
	}
}
