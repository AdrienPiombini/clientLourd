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
		System.out.println("Donner le roles de l'admin");
		String roles = sc.next();
		System.out.println("Donner la datemdp de l'admin");
		String datemdp = sc.next();
		System.out.println("Donner le prenom de l'admin");
		String prenom = sc.next();

		Admin unAdmin = new Admin(email, mdp, nom, roles, datemdp, prenom);
		return unAdmin;
	}

	public static void afficherAdmin(Admin unAdmin) {
		System.out.println("Email admin " + unAdmin.getEmail());
		System.out.println("Mdp admin " + unAdmin.getMdp());
		System.out.println("Nom admin " + unAdmin.getNom());
		System.out.println("Nom Particulier " + unAdmin.getRoles());
		System.out.println("date  mdp " + unAdmin.getDatemdp());
		System.out.println("Prenom admin " + unAdmin.getPrenom());
	}

	public static Admin modifierAdmin(Admin unAdmin) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Ancien email   : " + unAdmin.getEmail());
		System.out.println("Donnez le nouvel email ");
		unAdmin.setEmail(sc.next());

		System.out.println("Ancien mdp : " + unAdmin.getMdp());
		System.out.println("Donnez le nouveau mdp ");
		unAdmin.setMdp(sc.next());

		System.out.println("Ancien nom : " + unAdmin.getNom());
		System.out.println("Donnez le nouveau nom ");
		unAdmin.setNom(sc.next());

		System.out.println("Ancien roles : " + unAdmin.getRoles());
		System.out.println("Donnez le nouveau roles ");
		unAdmin.setRoles(sc.next());

		System.out.println("Ancien roles : " + unAdmin.getDatemdp());
		System.out.println("Donnez la nouvelle datemdp  ");
		unAdmin.setDatemdp(sc.next());

		System.out.println("Ancien prenom : " + unAdmin.getPrenom());
		System.out.println("Donnez le nouveau prenom  ");
		unAdmin.setPrenom(sc.next());

		return unAdmin;
	}

}
