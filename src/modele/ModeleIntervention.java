package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Intervention;

public class ModeleIntervention {
    private static Bdd uneBdd = new Bdd("localhost:8889", "dsa", "root", "root");

	public static void insertIntervention(Intervention uneIntervention) {
		String requete = "insert into intervention values (null, '" + uneIntervention.getMateriel() + "','"
				+ uneIntervention.getPanne() + "','" + uneIntervention.getDateinter() + "','"
				+ uneIntervention.getPrix() + "','" + uneIntervention.getIdclient() + "','"
				+ uneIntervention.getIdtechnicien() + "');";
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

	public static void deleteIntervention(int idintervention) {
		String requete = "delete from intervention where idintervention=" + idintervention + ";";
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

	public static void updateIntervention(Intervention uneIntervention) {
		String requete = "update intervention set materiel= '" + uneIntervention.getMateriel() + "',panne='"
				+ uneIntervention.getPanne() + "',dateinter='" + uneIntervention.getDateinter() + "',prix='"
				+ uneIntervention.getPrix() + "',idclient='" + uneIntervention.getIdclient() + "',idtechnicien='"
				+ uneIntervention.getIdtechnicien() + "');";
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

	public static ArrayList<Intervention> selectAllIntervention() {
		String requete = " select * from intervention ;";
		ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des Interventions resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les Interventions et enfin on les
			// ajoute
			// dans l'ArrayList
			while (desResultats.next()) {
				Intervention uneIntervention = new Intervention(desResultats.getInt("idinter"),
						desResultats.getString("materiel"), desResultats.getString("panne"),
						desResultats.getString("dateinter"), desResultats.getFloat("prix"),
						desResultats.getInt("idclient"), desResultats.getInt("idtechnicien"));
				// on ajoute le Intervention dans l'ArrayList
				lesInterventions.add(uneIntervention);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return lesInterventions;
	}

	public static Intervention selectWhereIntervention(int idintervention) {
		String requete = " select * from intervention where idintervention= " + idintervention + ";";
		Intervention uneIntervention = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul Intervention resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul résultat
			if (unResultat.next()) {
				uneIntervention = new Intervention(unResultat.getInt("idinter"), unResultat.getString("materiel"),
						unResultat.getString("panne"), unResultat.getString("dateinter"), unResultat.getFloat("prix"),
						unResultat.getInt("idclient"), unResultat.getInt("idtechnicien"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return uneIntervention;
	}
}
