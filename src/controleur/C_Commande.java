package controleur;
import java.util.ArrayList;
import java.util.Scanner;
import modele.ModeleCommande;
import vue.VueCommande;
public class C_Commande {

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
		Commande uneCommande = ModeleCommande.selectWhereCommande(idCommande);
		// modifier les infos du Commande
		uneCommande = VueCommande.modifierCommande(uneCommande);
		// actualiser les infos dans la bdd
		ModeleCommande.updateCommande(uneCommande);

		System.out.println("Modificiation du Commande réussie.");
	}

	public static void selectAllCommandes() {
		ArrayList<Commande> lesCommandes;
		System.out.println("________LISTE DES CommandeS________");
		// on récupère les Commandes
		lesCommandes = ModeleCommande.selectAllCommande();
		// on parcours l'ArrayList
		for (Commande uneCommande : lesCommandes) {
			// on affiche le Commande
			VueCommande.afficherCommande(uneCommande);
		}

	}

	public static void menuCommande() {

		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU Commande___");
			System.out.println("2- Lister les Commande");
			System.out.println("3- Supprimer un Commande");
			System.out.println("4- Modifier un Commande");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 2:
				selectAllCommandes();
				break;
			case 3:
				deleteCommande();
				break;
			case 4:
				updateCommande();
				break;
			}
		} while (choix != 0);
	}
}
