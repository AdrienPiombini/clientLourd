package vue.old_vue;
import java.util.Scanner;

import controleur.Client;

public class VueClient {
    public static Client saisirClient() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner l'email de Client");
		String email = sc.next();
		System.out.println("Donner le mdp de lClient");
		String mdp = sc.next();
		System.out.println("Donner le nom de Client");
		String nom = sc.next();
		System.out.println("Donner le roles de Client");
		String roles = sc.next();
		System.out.println("Donner la datemdp de Client");
		String datemdp = sc.next();
		System.out.println("Donner le type de Client");
		String typeclient = sc.next();
        System.out.println("Donner l'adresse de'Client");
		String adresse = sc.next();
        System.out.println("Donner la ville de Client");
		String ville = sc.next();
        System.out.println("Donner le code postal de Client");
		String cp = sc.next();
        System.out.println("Donner le telephone du Client");
		int telephone = sc.nextInt();

		Client unClient = new Client(email, mdp, nom, roles, datemdp, typeclient, adresse, ville, cp, telephone);
		return unClient;
	}

	public static void afficherClient(Client unClient) {
		System.out.println("Email Client " + unClient.getEmail());
		System.out.println("Mdp Client " + unClient.getMdp());
		System.out.println("Nom Client " + unClient.getNom());
		System.out.println("Roles  " + unClient.getRoles());
		System.out.println("date  mdp " + unClient.getDatemdp());
		System.out.println("type Client " + unClient.getTypeclient());
		System.out.println("adresse Client " + unClient.getAdresse());
		System.out.println("ville Client " + unClient.getVille());
		System.out.println("cp Client " + unClient.getCp());
		System.out.println("telephone Client " + unClient.getTelephone());

	}

	public static Client modifierClient(Client unClient) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Ancien email   : " + unClient.getEmail());
		System.out.println("Donnez le nouvel email ");
		unClient.setEmail(sc.next());

		System.out.println("Ancien mdp : " + unClient.getMdp());
		System.out.println("Donnez le nouveau mdp ");
		unClient.setMdp(sc.next());

		System.out.println("Ancien nom : " + unClient.getNom());
		System.out.println("Donnez le nouveau nom ");
		unClient.setNom(sc.next());

		System.out.println("Ancien roles : " + unClient.getRoles());
		System.out.println("Donnez le nouveau roles ");
		unClient.setRoles(sc.next());

		System.out.println("Ancien roles : " + unClient.getDatemdp());
		System.out.println("Donnez la nouvelle datemdp  ");
		unClient.setDatemdp(sc.next());

		System.out.println("Ancien typeclient : " + unClient.getTypeclient());
		System.out.println("Donnez le nouveau typeclient  ");
		unClient.setTypeclient(sc.next());

        System.out.println("Ancienne adresse : " + unClient.getAdresse());
		System.out.println("Donnez l'adresse  ");
		unClient.setAdresse(sc.next());

        System.out.println("Ancienne ville : " + unClient.getVille());
		System.out.println("Donnez la ville   ");
		unClient.setVille(sc.next());

        System.out.println("Ancien cp : " + unClient.getTypeclient());
		System.out.println("Donnez le nouveau cp  ");
		unClient.setCp(sc.next());

        System.out.println("Ancien telephone : " + unClient.getTypeclient());
		System.out.println(" le nouveau telephone  ");
		unClient.setTelephone(sc.nextInt());

		return unClient;
	}
}
