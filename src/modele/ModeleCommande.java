package modele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Commande;

public class ModeleCommande {
    private static Bdd uneBdd = new Bdd("localhost:8889", "dsa", "root", "root");

	public static void insertCommande(Commande uneCommande) {
		String requete = "insert into Commande values (null, '"
				+ uneCommande.getIdproduit() + "','" + uneCommande.getIduser() + "','" + uneCommande.getQuantite()
				+ "',"+ uneCommande.getTotalHT() + "," + uneCommande.getTotalTTC()
				+ "," + uneCommande.getStatut()
				+ ","+ uneCommande.getDateCommande() + ");";
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

	public static void deleteCommande(int idCommande) {
		String requete = "delete from Commande where idCommande=" + idCommande + ";";
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

	public static void updateCommande(Commande uneCommande) {
		String requete = "update Commande set dateCommande='"
				+ uneCommande.getDateCommande() + "',statut='" + uneCommande.getStatut() + "',totalHT='"+ uneCommande.getTotalHT()
                + "',totalTTC='" + uneCommande.getTotalTTC() 
                + "',idcommande='" + uneCommande.getIdcommande() 
                + "',idproduit='" + uneCommande.getIdproduit()
                + "',quantite='" + uneCommande.getQuantite()
                + "',iduser='" + uneCommande.getIduser()  + "' where idCommande ="+ uneCommande.getIdcommande()+";";
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

	public static ArrayList<Commande> selectAllCommande() {
		String requete = "select * from commande ;";
		ArrayList<Commande> lesCommandes = new ArrayList<Commande>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des Commandes resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les Commandes et enfin on les
			// ajoute
			// dans l'ArrayList
			while (desResultats.next()) {
				Commande uneCommande = new Commande(desResultats.getInt("idCommande"),
						desResultats.getInt("iduser"), desResultats.getInt("idproduit"),
						desResultats.getInt("quantite"), desResultats.getFloat("totalHT"), 
						desResultats.getFloat("totalTTC"), desResultats.getFloat("tvacommande"),
						desResultats.getString("statut"),
						desResultats.getString("datecommande")
						);
				// on ajoute le Commande dans l'ArrayList
				lesCommandes.add(uneCommande);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return lesCommandes;
	}

	public static Commande selectWhereCommande(int idCommande) {
		String requete = " select * from Commande where idCommande = " + idCommande + ";";
		Commande uneCommande = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul Commande resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul résultat
			if (unResultat.next()) {
                 uneCommande = new Commande(unResultat.getInt("idCommande"),
                unResultat.getInt("iduser"), unResultat.getInt("idproduit"),
                unResultat.getInt("quantite"), unResultat.getFloat("totalHT"), 
                unResultat.getFloat("totalTTC"), unResultat.getFloat("tvacommande"),
                unResultat.getString("statut"),
                unResultat.getString("datecommande")
                );
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution : " + requete);
		}
		return uneCommande;
	}
}
