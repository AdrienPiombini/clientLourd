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
		System.out.println("Insertion réussie du Intervention.");
	}

	public static void insertPanier(Commande uneCommande){
		ModeleCommande.insertPanier(uneCommande);
		System.out.println("Insertion réussie du commande.");
	}

	public static void deleteCommande() {
		// saisir un idCommande
		Scanner sc = new Scanner(System.in);
		int idCommande;
		System.out.println("Donner l'id a supprimer");
		idCommande = sc.nextInt();
		// supprimer le cliend dans la bdd
		ModeleCommande.deleteCommande(idCommande);
	}

	public static void updateCommande() {
		// saisir id Commande a modifier
		Scanner sc = new Scanner(System.in);
		int idCommande;
		System.out.println("Donner l'id a modifier");
		idCommande = sc.nextInt();
		// récuperer le Commande dans la bdd avant cet id
		ArrayList<Commande> uneCommande = ModeleCommande.selectWhereLaCommande(idCommande);
		// modifier les infos du Commande
		//uneCommande = VueCommande.modifierCommande(uneCommande);
		// actualiser les infos dans la bdd
		//ModeleCommande.updateCommande(uneCommande);

		System.out.println("Modificiation du Commande réussie.");
	}

	
	public static ArrayList<Commande> selectAllCommandes() {
		 return ModeleCommande.selectAllCommande();
	}

	public static ArrayList<Commande> selectWhereLaCommande(int idCommande){
		return ModeleCommande.selectWhereLaCommande(idCommande);
	}

	public static Commande selectWhereUneCommande(int idCommande){
		return ModeleCommande.selectWhereUneCommande(idCommande);
	}
}



