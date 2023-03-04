package controleur;

import java.util.Scanner;

public class Filelec {

	public static void main(String[] args) {
		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU CLIENT___");
			System.out.println("1- Gestion des users");
			System.out.println("2- Gestion des particuliers");
			System.out.println("3- Gestion des professionnels");
			System.out.println("4- Gestion des techniciens");
			System.out.println("5- Gestion des Produits");
			System.out.println("6- Gestion des admins");
			System.out.println("7- Gestion des interventions");
			System.out.println("8- Gestion des Clients");
			System.out.println("9- Gestion des commandes");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 2: C_Particulier.menuParticulier();break;
			case 3: C_Professionnel.menuProfessionnel();break;
			case 4: C_Technicien.menuTechnicien();break;
			case 5: C_Produit.menuProduit();break;
			case 6: C_Admin.menuAdmin();break;
			case 7:C_Intervention.menuIntervention();break;
			case 8:C_Client.menuClient();break;
			case 9:C_Commande.menuCommande();break;


			}
		} while (choix != 0);
	}
}
