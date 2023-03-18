package controleur;
import java.util.ArrayList;
import java.util.Scanner;
import modele.ModeleCommande;
import vue.old_vue.VueCommande;
public class C_Commande {


	public static int selectDerniereCommande(){
		return ModeleCommande.selectDerniereCommande();
	}

    public static void insertCommande(Commande uneCommande){
		ModeleCommande.insertCommande(uneCommande);
	}

	public static void insertPanier(Commande uneCommande){
		ModeleCommande.insertPanier(uneCommande);
	}

	public static void deleteCommande(int idCommande) {
		ModeleCommande.deleteCommande(idCommande);
	}

	public static void updateCommande(Commande uneCommande) {
		ModeleCommande.updateCommande(uneCommande);
	}

	
	public static ArrayList<Commande> selectAllCommandes(String filtre) {
		 return ModeleCommande.selectAllCommandes(filtre);
	}

	public static ArrayList<Commande> selectWhereLaCommande(int idCommande){
		return ModeleCommande.selectWhereLaCommande(idCommande);
	}

	public static Commande selectWhereUneCommande(int idCommande){
		return ModeleCommande.selectWhereUneCommande(idCommande);
	}
}



