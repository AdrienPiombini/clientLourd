package vue;

import java.util.Scanner;

import controleur.Commande;

public class VueCommande {
    public static Commande saisirCommande() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner le idcommande");
		int idcommande = sc.nextInt();
		System.out.println("Donner iduser ");
		int  iduser = sc.nextInt();
		System.out.println("Donner idproduit");
		int idproduit = sc.nextInt();
        System.out.println("Donner le statut");
		String statut = sc.next();
        System.out.println("Donner la date de la commande");
		String datecommande = sc.next();
        System.out.println("Donner la quantite");
		int quantite = sc.nextInt();
        System.out.println("Donner le tva");
		float tvaCommande = sc.nextFloat();
		System.out.println("Donner le totalHT ");
		float totalHT = sc.nextFloat();
        System.out.println("Donner le total TTC ");
		float totalTTC = sc.nextFloat();
		Commande uneCommande = new Commande(idcommande, iduser, idproduit, quantite, totalHT, totalTTC, tvaCommande, statut, datecommande);
		return uneCommande;
	}

	public static void afficherCommande(Commande uneCommande) {
		System.out.println("ld Commande  : " + uneCommande.getIdcommande());
		System.out.println("iduser  : " + uneCommande.getIduser());
		System.out.println("idproduit : " + uneCommande.getIdproduit());
		System.out.println("quantite  : " + uneCommande.getStatut());
		System.out.println("statut  : " + uneCommande.getStatut());
		System.out.println("totalTTC  : " + uneCommande.getTvaCommande());
		System.out.println("totalHT  : " + uneCommande.getTotalHT());
		System.out.println("totalTTC  : " + uneCommande.getTotalTTC());
		System.out.println("datecommande  : " + uneCommande.getDateCommande());
	}

	public static Commande modifierCommande(Commande uneCommande) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ancien id Commande : " + uneCommande.getIdcommande());
		System.out.println("Donner le nouveau idcommande ");
		uneCommande.setIdcommande(sc.nextInt());

		System.out.println("Ancien  dateCommande : " + uneCommande.getDateCommande());
		System.out.println("Donner la nouvelle dateCommande  ");
		uneCommande.setDateCommande(sc.next());

		System.out.println("Ancien statut Commande : " + uneCommande.getStatut());
		System.out.println("Donner le nouveau statut  ");
		uneCommande.setStatut(sc.next());

		System.out.println("Ancien prix HT : " + uneCommande.getTotalHT());
		System.out.println("Donner le nouveau prix HT");
		uneCommande.setTotalHT(sc.nextFloat());

        System.out.println("Ancien prix TTC : " + uneCommande.getTotalTTC());
		System.out.println("Donner le nouveau prix TTC");
		uneCommande.setTotalTTC(sc.nextFloat());

		System.out.println("Ancien iduser  : " + uneCommande.getIduser());
		System.out.println("Donner le nouveau iduser ");
		uneCommande.setIduser(sc.nextInt());

		System.out.println("Ancien idproduit : " + uneCommande.getIdproduit());
		System.out.println("Donner le nouveau idtechnicein ");
		uneCommande.setIdproduit(sc.nextInt());

		return uneCommande;
	}
}
