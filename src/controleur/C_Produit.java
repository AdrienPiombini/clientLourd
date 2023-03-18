package controleur;

import java.util.ArrayList;
import modele.ModeleProduit;

public class C_Produit {

	public static void insertProduit(Produit unProduit){
		ModeleProduit.insertProduit(unProduit);
		System.out.println("Insertion réussie du produit.");
	}
	
	public static void deleteProduit(int idProduit){
		ModeleProduit.deleteProduit(idProduit);
	}
	
	public static void updateProduit(Produit unProduit){
		ModeleProduit.updateProduit(unProduit);
	}
	
	public static ArrayList<Produit>  selectAllProduits(String filtre){
		return ModeleProduit.selectAllProduits(filtre);
	}

	public static Produit selectWhereProduit(String nomProduit){
		return ModeleProduit.selectWhereProduit(nomProduit);
	}

	public static Produit selectWhereProduit(int idProduit){
		return ModeleProduit.selectWhereProduit(idProduit);
	}
}