package controleur;

import java.util.ArrayList;

import modele.ModeleUsers;

public class C_Users {
	
    public static void insertUser(Users unUser) {
		ModeleUsers.insertUser(unUser);
		System.out.println("Insertion réussie de l'User.");
	}

	public static void deleteUser(String email) {

		ModeleUsers.deleteUser(email);
	}

	public static void updateUser(Users unUser) {
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
