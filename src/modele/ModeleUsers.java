package modele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Users;

public class ModeleUsers {
    private static Bdd uneBdd = new Bdd("Localhost:8889", "dsa", "root", "root");

    public static void insertUser(Users unUser) {
		String requete = "insert into users values (null, '" + unUser.getEmail() + "','" + unUser.getMdp() + "','"
				+ unUser.getNom() + "','" + unUser.getRoles() +"','" + unUser.getDatemdp() + "');";
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

	public static void deleteUser(String email) {
		String requete = "delete from users where email='" + email +"';";
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

	public static void updateUser(Users unUser) {
		String requete = "update users set email='" + unUser.getEmail() + "', mdp ='" + unUser.getMdp()
				+ "', nom='" + unUser.getNom() + "', datemdp='" + unUser.getDatemdp() 
				+ "' where iduser ="+ unUser.getIduser() + ";";
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

	public static ArrayList<Users> selectAllUser() {
		String requete = " select * from users ;";
		ArrayList<Users> lesUsers = new ArrayList<Users>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des clients resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les clients et enfin on les ajoute
			// dans l'ArrayList
			while (desResultats.next()) {
				Users unUser = new Users(desResultats.getInt("iduser"), desResultats.getString("email"),
						desResultats.getString("mdp"), desResultats.getString("nom"),
						desResultats.getString("roles"), desResultats.getString("datemdp"));
				// on ajoute le client dans l'ArrayList
				lesUsers.add(unUser);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return lesUsers;
	}

	public static Users selectWhereUser(String email) {
		String requete = " select * from Users where email= '" + email + "';";
		Users unUser  = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul client resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul résultat
			if (unResultat.next()) {
				 unUser = new Users(unResultat.getInt("iduser"), unResultat.getString("email"),
						unResultat.getString("mdp"), unResultat.getString("nom"),
						unResultat.getString("roles"), unResultat.getString("datemdp"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return unUser;
	}
}
