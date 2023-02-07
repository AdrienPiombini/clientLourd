package controleur;

import java.util.Scanner;

public class Filelec {

	public static void main(String[] args) {
		int choix = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("___ MENU CLIENT___");
			System.out.println("1- Gestion des clients");
			System.out.println("2- Gestion des techniciens");
			System.out.println("3- Gestion des interventions");
			System.out.println("0- Quitter");
			System.out.println("Votre choix : ");
			choix = sc.nextInt();
			switch (choix) {
			case 3:
				C_Intervention.menuIntervention();
				break;
			}
		} while (choix != 0);
	}
}
