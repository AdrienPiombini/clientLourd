package modele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeleParticulier {
    private static Bdd uneBdd = new Bdd("Localhost:8889", "dsa", "root", "root");

    public static void insertParticulier(Particulier unParticulier) {
		String requete = "insert into Particulier values (null, '" + unParticulier.getEmail() + "','" + unParticulier.getMdp() + "','"
				+ unParticulier.getNom() + "','" + unParticulier.getRoles() + "','" + unParticulier.getDatemdp() + "','" + unParticulier.getTypeclient() +"','" + unParticulier.getAdresse() +"','" + unParticulier.getVille() +"','" + unParticulier.getCp() +"','" + unParticulier.getTelephone() + unParticulier.getPrenom() + ");";
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

	public static void deleteParticulier(String email) {
		String requete = "delete from Particulier where email=" + email + ";";
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

	public static void updateParticulier(Particulier unParticulier) {
		String requete = "update Particulier set email='" + unParticulier.getEmail() + "', mdp ='" + unParticulier.getMdp()
				+ "', nom='" + unParticulier.getNom() + "', datemdp='" + unParticulier.getDatemdp() + "', typeclient='" + unParticulier.getTypeclient() + "', adresse='" + unParticulier.getAdresse() + "', ville='" + unParticulier.getVille() + "', cp='" + unParticulier.getCp() + "', telephone='" + unParticulier.getTelephone() + "', prenom='"+ unParticulier.getPrenom() + "' where email ="
				+ unParticulier.getEmail() + ";";
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

	public static ArrayList<Particulier> selectAllParticulier() {
		String requete = " select * from Particulier ;";
		ArrayList<Particulier> lesParticuliers = new ArrayList<Particulier>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des clients resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les clients et enfin on les ajoute
			// dans l'ArrayList
			while (desResultats.next()) {
				Particulier unParticulier = new Particulier(desResultats.getInt("iduser"), desResultats.getString("email"),
						desResultats.getString("mdp"), desResultats.getString("nom"),
						desResultats.getString("roles"), desResultats.getString("datemdp"), 
                        desResultats.getString("typeclient") , desResultats.getString("adresse"),
                        desResultats.getString("ville") , desResultats.getString("cp"),
                        desResultats.getString("telephone"), desResultats.getString("prenom") );
				// on ajoute le client dans l'ArrayList
				lesParticuliers.add(unParticulier);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return lesParticuliers;
	}

	public static Particulier selectWhereParticulier(String email) {
		String requete = " select * from Particulier where email= " + email + ";";
		Client unClient = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul client resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul résultat
			if (unResultat.next()) {
				Particulier unParticulier = new Particulier(unResultat.getInt("iduser"), unResultat.getString("email"),
						unResultat.getString("mdp"), unResultat.getString("nom"),
						unResultat.getString("roles"), unResultat.getString("datemdp"), 
                        unResultat.getString("typeclient") , unResultat.getString("adresse"),
                        unResultat.getString("ville") , unResultat.getString("cp"),
                        unResultat.getString("telephone"), unResultat.getString("prenom") );
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return unParticulier;
	}
}
