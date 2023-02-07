package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;

public class ModeleClient {
    private static Bdd uneBdd = new Bdd("Localhost:8889", "dsa", "root", "root");

    public static void insertClient(Client unClient) {
		String requete = "insert into Client values (null, '" + unClient.getEmail() + "','" + unClient.getMdp() + "','"
				+ unClient.getNom() + "','" + unClient.getRoles() 
                +"','" + unClient.getDatemdp()
                + "','" +unClient.getTypeclient()
                + "','" +unClient.getAdresse()
                + "','" +unClient.getVille()
                + "','" +unClient.getCp()
                + "','" +unClient.getTelephone()
                + "');";
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

	public static void deleteClient(String email) {
		String requete = "delete from Client where email=" + email + ";";
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

	public static void updateClient(Client unClient) {
		String requete = "update Client set email='" + unClient.getEmail() + "', mdp ='" + unClient.getMdp()
				+ "', nom='" + unClient.getNom() + "', datemdp='" + unClient.getDatemdp() 
                + "', typeclient='"+ unClient.getTypeclient() + "', adresse='" + unClient.getAdresse() 
                + "', ville='" + unClient.getVille() + "', cp='" + unClient.getCp()
                + "', telephone='" + unClient.getTelephone() 
                + "' where email ='"
				+ unClient.getEmail() + "';";
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

	public static ArrayList<Client> selectAllClient() {
		String requete = " select * from Client ;";
		ArrayList<Client> lesClients = new ArrayList<Client>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des clients resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les clients et enfin on les ajoute
			// dans l'ArrayList
			while (desResultats.next()) {
				Client unClient = new Client(desResultats.getInt("iduser"), desResultats.getString("email"),
						desResultats.getString("mdp"), desResultats.getString("nom"),
						desResultats.getString("roles"), desResultats.getString("datemdp"), desResultats.getString("typeclient"),
                        desResultats.getString("adresse"), desResultats.getString("ville"), desResultats.getString("cp"), desResultats.getInt("telephone"));
				// on ajoute le client dans l'ArrayList
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return lesClients;
	}

	public static Client selectWhereClient(String email) {
		String requete = " select * from Client where email= " + email + ";";
		Client unClient  = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul client resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul résultat
			if (unResultat.next()) {
				 unClient = new Client(unResultat.getInt("iduser"), unResultat.getString("email"),
						unResultat.getString("mdp"), unResultat.getString("nom"),
						unResultat.getString("roles"), unResultat.getString("datemdp"), unResultat.getString("typeclient"),
                        unResultat.getString("adresse"), unResultat.getString("ville"), unResultat.getString("cp"), unResultat.getInt("telephone"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return unClient;
	}
}
