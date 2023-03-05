package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleUsers;
import vue.old_vue.VueUsers;

public class C_Users {
    public static void insertUser(Users unUser) {
		ModeleUsers.insertUser(unUser);
		System.out.println("Insertion réussie de l'User.");
	}

	public static void deleteUser() {
		// saisir un idclient
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email a supprimer");
		email = sc.next();
		// supprimer le cliend dans la bdd
		ModeleUsers.deleteUser(email);
	}

	public static void updateUser() {
		// saisir id client a modifier
		Scanner sc = new Scanner(System.in);
		String email;
		System.out.println("Donner l'email de l'User a modifier");
		email = sc.next();
		// récuperer le client dans la bdd avant cet id
		Users unUser = ModeleUsers.selectWhereUser(email);
		// modifier les infos du client
		unUser = VueUsers.modifierUser(unUser);
		// actualiser les infos dans la bdd
		ModeleUsers.updateUser(unUser);

		System.out.println("Modificiation du client réussie.");
	}

	public static ArrayList<Users> selectAllUser() {
		return ModeleUsers.selectAllUser();
		}

	public static Users connexion(String email, String mdp) {
        return ModeleUsers.connexion(email, mdp);
    }

}
