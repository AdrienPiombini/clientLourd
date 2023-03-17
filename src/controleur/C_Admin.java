package controleur;
import java.util.ArrayList;


import modele.ModeleAdmin;


public class C_Admin {
    public static void insertAdmin(Admin unAdmin) {
		// insérer le client dans la BDD
		ModeleAdmin.insertAdmin(unAdmin);
		System.out.println("Insertion réussie de l'admin.");
	}

	public static void deleteAdmin(String email) {
		ModeleAdmin.deleteAdmin(email);
	}

	public static void updateAdmin(Admin unAdmin) {
		ModeleAdmin.updateAdmin(unAdmin);
	}

	public static ArrayList<Admin>  selectAllAdmin(String filtre) {
		return ModeleAdmin.selectAllAdmin(filtre);
	}

	public static Admin connexionAdmin(String email, String mdp) {
        return ModeleAdmin.connexionAdmin(email, mdp);
    }

	public static Admin selectWhereAdmin(String email){
		return ModeleAdmin.selectWhereAdmin(email);
	}

}
