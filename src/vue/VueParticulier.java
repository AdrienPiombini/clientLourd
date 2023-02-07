package vue;

import java.util.Scanner;

import controleur.Particulier;

public class VueParticulier {
    public static Particulier saisirParticulier() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner l'email de Particulier");
		String email = sc.next();
		System.out.println("Donner le mdp de Particulier");
		String mdp = sc.next();
		System.out.println("Donner le nom de Particulier");
		String nom = sc.next();
		System.out.println("Donner le roles de Particulier");
		String roles = sc.next();
		System.out.println("Donner la datemdp de Particulier");
		String datemdp = sc.next();
		System.out.println("Donner le typeclient du Particulier");
		String typeclient = sc.next();
        System.out.println("Donner l'adrese du Particulier");
		String adresse = sc.next();
        System.out.println("Donner la ville du Particulier");
		String ville = sc.next();
        System.out.println("Donner le cp du Particulier");
		String cp = sc.next();
        System.out.println("Donner le telephone du Particulier");
		int telephone = sc.nextInt();
		System.out.println("Donner le prenom du Particulier");
		String prenom = sc.next();

		Particulier unParticulier = new Particulier(email, mdp, nom, roles, datemdp, typeclient, adresse, ville, cp, telephone, prenom);
		return unParticulier;
	}

	public static void afficherParticulier(Particulier unParticulier) {
		System.out.println("Email Particulier " + unParticulier.getEmail());
		System.out.println("Mdp Particulier " + unParticulier.getMdp());
		System.out.println("Nom Particulier " + unParticulier.getNom());
		System.out.println("Roles  " + unParticulier.getRoles());
		System.out.println("date  mdp " + unParticulier.getDatemdp());
		System.out.println("type client   " + unParticulier.getTypeclient());
		System.out.println("adrese Particulier " + unParticulier.getAdresse());
		System.out.println("Ville Particulier " + unParticulier.getNom());
		System.out.println("Cp Particulier " + unParticulier.getNom());
		System.out.println("Telephone du Particulier " + unParticulier.getTelephone());
		System.out.println("Prenom Particulier " + unParticulier.getPrenom());
	}

	public static Particulier modifierParticulier(Particulier unParticulier) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Ancien email   : " + unParticulier.getEmail());
		System.out.println("Donnez le nouvel email ");
		unParticulier.setEmail(sc.next());

		System.out.println("Ancien mdp : " + unParticulier.getMdp());
		System.out.println("Donnez le nouveau mdp ");
		unParticulier.setMdp(sc.next());

		System.out.println("Ancien nom : " + unParticulier.getNom());
		System.out.println("Donnez le nouveau nom ");
		unParticulier.setNom(sc.next());

        System.out.println("Ancien roles : " + unParticulier.getRoles());
		System.out.println("Donnez le nouveau roles  ");
		unParticulier.setRoles(sc.next());

        System.out.println("Ancien datemdp : " + unParticulier.getDatemdp());
		System.out.println("Donnez la nouvelle datemdp  ");
		unParticulier.setDatemdp(sc.next());

        System.out.println("Ancien typeclient : " + unParticulier.getTypeclient());
		System.out.println("Donnez le nouveau type client  ");
		unParticulier.setTypeclient(sc.next());

        System.out.println("Ancienne adresse : " + unParticulier.getAdresse());
		System.out.println("Donnez la nouvelle adresse   ");
		unParticulier.setAdresse(sc.next());

        System.out.println("Ancienne ville : " + unParticulier.getVille());
		System.out.println("Donnez la nouvelle ville   ");
		unParticulier.setVille(sc.next());

        System.out.println("Ancien cp : " + unParticulier.getCp());
		System.out.println("Donnez le nouveau cp  ");
		unParticulier.setCp(sc.next());

        System.out.println("Ancien telephone : " + unParticulier.getTelephone());
		System.out.println("Donnez le nouveau prenom  ");
		unParticulier.setTelephone(sc.nextInt());

		System.out.println("Ancien prenom : " + unParticulier.getPrenom());
		System.out.println("Donnez le nouveau prenom  ");
		unParticulier.setPrenom(sc.next());

		return unParticulier;
	}
}
