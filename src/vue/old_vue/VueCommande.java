package vue.old_vue;

import java.util.Scanner;

import controleur.Commande;

public class VueCommande {
    public static Commande saisirCommande() {
		
		Commande uneCommande = new Commande();
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
