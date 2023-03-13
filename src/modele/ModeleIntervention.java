package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Intervention;

public class ModeleIntervention {
    //private static Bdd uneBdd = new Bdd("localhost:3306", "dsa", "adrien", "adrien");
	private static Bdd uneBdd = new Bdd();
	
	public static void insertIntervention(Intervention uneIntervention) {
		String requete = "insert into intervention values (null, '" + uneIntervention.getLibelle() + "','"
				+ uneIntervention.getDateintervention() + "','" + uneIntervention.getStatut()
				+ "',"+ uneIntervention.getPrixHT() + "," + uneIntervention.getPrixTTC()
				+ "," + uneIntervention.getIduser()
				+ ","+ uneIntervention.getIdtechnicien() + ");";
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
		String requete = "update intervention set libelle= '" + uneIntervention.getLibelle() + "',dateintervention='"
				+ uneIntervention.getDateintervention() + "',statut='" + uneIntervention.getStatut() + "',prixHT='"
				+ uneIntervention.getPrixHT() + "',prixTTC='" + uneIntervention.getPrixTTC() + "',iduser='" 
				+ uneIntervention.getIduser() + "',idtechnicien='"+ uneIntervention.getIdtechnicien() + "' where idintervention ="+ uneIntervention.getIdintervention()+";";
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
		String requete = "select * from intervention ;";
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
				Intervention uneIntervention = new Intervention(desResultats.getInt("idintervention"),
						desResultats.getString("libelle"), desResultats.getString("dateintervention"),
						desResultats.getString("statut"), desResultats.getFloat("prixHT"), 
						desResultats.getFloat("prixTTC"), desResultats.getInt("iduser"),
						desResultats.getInt("idtechnicien")
						);
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

	public static Intervention selectWhereIntervention(String dateIntervention, int idClient, int idTechnicien) {
		String requete = " select * from intervention where dateintervention = '" + dateIntervention + "' and iduser = '" + idClient + "' and idtechnicien = '" + idTechnicien + "';";
		Intervention uneIntervention = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul Intervention resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul résultat
			if (unResultat.next()) {
				 uneIntervention = new Intervention(unResultat.getInt("idintervention"),
						unResultat.getString("libelle"), unResultat.getString("dateintervention"),
						unResultat.getString("statut"), unResultat.getFloat("prixHT"), 
						unResultat.getFloat("prixTTC"), unResultat.getInt("iduser"),
						unResultat.getInt("idtechnicien"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return uneIntervention;
	}
}
