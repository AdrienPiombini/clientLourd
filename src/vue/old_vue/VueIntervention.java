package vue.old_vue;

import java.util.Scanner;

import controleur.Intervention;

public class VueIntervention {
    public static Intervention saisirIntervention() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner le libelle intervention");
		String libelle = sc.next();
		System.out.println("Donner la date d'intervention");
		String dateintervention = sc.next();
		System.out.println("Donner le statut");
		String statut = sc.next();
		System.out.println("Donner le prixHT ");
		float prixHT = sc.nextFloat();
        System.out.println("Donner le prixTTC ");
		float prixTTC = sc.nextFloat();
		System.out.println("Donner l'id client ");
		int idclient = sc.nextInt();
		System.out.println("Donner l'id technicien ");
		int idtechnicien = sc.nextInt();
		Intervention uneIntervention = new Intervention(libelle, dateintervention, statut, prixHT, prixTTC, idclient, idtechnicien);
		return uneIntervention;
	}

	public static void afficherIntervention(Intervention uneIntervention) {
		System.out.println("ld intervention  : " + uneIntervention.getIdintervention());
		System.out.println("Libelle ntervention  : " + uneIntervention.getLibelle());
		System.out.println("date intervention : " + uneIntervention.getDateintervention());
		System.out.println("statut  : " + uneIntervention.getStatut());
		System.out.println("prixHT  : " + uneIntervention.getPrixHT());
		System.out.println("prixTTC  : " + uneIntervention.getPrixTTC());
		System.out.println("id user  : " + uneIntervention.getIduser());
		System.out.println("id technicien : " + uneIntervention.getIdtechnicien());
	}

	public static Intervention modifierIntervention(Intervention uneIntervention) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ancien libelle intervention : " + uneIntervention.getLibelle());
		System.out.println("Donner le nouveau libelle ");
		uneIntervention.setLibelle(sc.next());

		System.out.println("Ancien  dateintervention : " + uneIntervention.getDateintervention());
		System.out.println("Donner la nouvelle dateintervention  ");
		uneIntervention.setDateintervention(sc.next());

		System.out.println("Ancien statut intervention : " + uneIntervention.getStatut());
		System.out.println("Donner le nouveau statut  ");
		uneIntervention.setStatut(sc.next());

		System.out.println("Ancien prix HT : " + uneIntervention.getPrixHT());
		System.out.println("Donner le nouveau prix HT");
		uneIntervention.setPrixHT(sc.nextFloat());

        System.out.println("Ancien prix TTC : " + uneIntervention.getPrixTTC());
		System.out.println("Donner le nouveau prix TTC");
		uneIntervention.setPrixTTC(sc.nextFloat());

		System.out.println("Ancien idclient  : " + uneIntervention.getIduser());
		System.out.println("Donner le nouveau iduser ");
		uneIntervention.setIduser(sc.nextInt());

		System.out.println("Ancien idtechnicien : " + uneIntervention.getIdtechnicien());
		System.out.println("Donner le nouveau idtechnicein ");
		uneIntervention.setIdtechnicien(sc.nextInt());

		return uneIntervention;
	}
}
