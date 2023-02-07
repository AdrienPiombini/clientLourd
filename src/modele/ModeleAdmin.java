package modele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Admin;


public class ModeleAdmin {
    private static Bdd uneBdd = new Bdd("Localhost:8889", "dsa", "root", "root");

    public static void insertAdmin(Admin unAdmin) {
		String requete = "insert into admin values (null, '" + unAdmin.getEmail() + "','" + unAdmin.getMdp() + "','"
				+ unAdmin.getNom()
				+ "','" + unAdmin.getRoles()
				+"','" + unAdmin.getDatemdp() 
				+ "','" +unAdmin.getPrenom() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
	}

	public static void deleteAdmin(String email) {
		String requete = "delete from admin where email='" + email + "';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
	}

	public static void updateAdmin(Admin unAdmin) {
		String requete = "update admin set email='" + unAdmin.getEmail() + "', mdp ='" + unAdmin.getMdp()
				+ "', nom='" + unAdmin.getNom() + "', datemdp='" + unAdmin.getDatemdp() + "', prenom='"+ unAdmin.getPrenom() + "' where email ='"
				+ unAdmin.getEmail() + "';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
	}

	public static ArrayList<Admin> selectAllAdmin() {
		String requete = " select * from admin ;";
		ArrayList<Admin> lesAdmins = new ArrayList<Admin>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des clients resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les clients et enfin on les ajoute
			// dans l'ArrayList
			while (desResultats.next()) {
				Admin unAdmin = new Admin(desResultats.getInt("iduser"), desResultats.getString("email"),
						desResultats.getString("mdp"), desResultats.getString("nom"),
						desResultats.getString("roles"), desResultats.getString("datemdp"), desResultats.getString("prenom")  );
				// on ajoute le client dans l'ArrayList
				lesAdmins.add(unAdmin);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return lesAdmins;
	}

	public static Admin selectWhereAdmin(String email) {
		String requete = " select * from admin where email= '" + email + "';";
		Admin unAdmin  = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul client resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul résultat
			if (unResultat.next()) {
				 unAdmin = new Admin(unResultat.getInt("iduser"), unResultat.getString("email"),
						unResultat.getString("mdp"), unResultat.getString("nom"),
						unResultat.getString("roles"), unResultat.getString("datemdp"), unResultat.getString("prenom")  );
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return unAdmin;
	}
}
