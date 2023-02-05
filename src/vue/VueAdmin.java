package vue;

import java.util.Scanner;

import controleur.Admin;

public class VueAdmin {

	public static Admin saisirAdmin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner l'email de l'admin");
		String email = sc.next();
		System.out.println("Donner le mdp de l'admin");
		String mdp = sc.next();
		System.out.println("Donner le nom de l'admin");
		String nom = sc.next();
		System.out.println("Donner le prenom de l'admin");
		String prenom = sc.next();

		Admin unAdmin = new Admin(email, mdp, nom, prenom);
		return unAdmin;
	}

	public static void afficherClient(Admin unAdmin) {
		System.out.println("Email admin " + unAdmin.getEmail());
		System.out.println("Mdp admin " + unAdmin.getMdp());
		System.out.println("Nom admin " + unAdmin.getNom());
		System.out.println("Prenom admin " + unAdmin.getPrenom());
	}

	public static Client modifierClient(Client unClient) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ancien nom   : " + unClient.getNom());
		System.out.println("Donnez le new nom ");
		unClient.setNom(sc.next());

		System.out.println("Ancien prenom   : " + unClient.getPrenom());
		System.out.println("Donnez le new prenom ");
		unClient.setPrenom(sc.next());

		System.out.println("Ancien adresse client   : " + unClient.getAdresse());
		System.out.println("Donnez la new adresse ");
		unClient.setAdresse(sc.next());

		System.out.println("Ancien email client   : " + unClient.getEmail());
		System.out.println("Donnez le new email ");
		unClient.setEmail(sc.next());

		return unClient;
	}

}
