package modele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Commande;

public class ModeleCommande {
    private static Bdd uneBdd = new Bdd("localhost:3306", "dsa", "adrien", "adrien");

	public static int selectDerniereCommande(){
		String requete = "select max(idcommande) from commande ;";
		int idDerniereCommande = 0; 
		try{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet resultat = unStat.executeQuery(requete);
			if(resultat.next()){
				idDerniereCommande = resultat.getInt(1);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}catch(SQLException exp){
			System.out.println("Erreur d'exécution : " + requete);
		}
		return idDerniereCommande;
	}

	public static void insertCommande(Commande uneCommande) {
		String requete = "insert into Commande values ("+ uneCommande.getIdcommande() + ","
				+ uneCommande.getIduser() + "," + uneCommande.getIdproduit() + "," + uneCommande.getQuantite()
                + ",'" + uneCommande.getStatut() + "','"+ uneCommande.getDateCommande()
				+ "'," + uneCommande.getTvaCommande() + "," 
                + uneCommande.getTotalHT() + "," + uneCommande.getTotalTTC()+ ");";
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

	public static void insertPanier(Commande uneCommande) {
		String requete = "call gestion_panier (" + uneCommande.getIdcommande() + ", "+ uneCommande.getIduser() + ", " 
		+ uneCommande.getIdproduit() +", " + uneCommande.getQuantite() +");";
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
                + "',idproduit='" + uneCommande.getIdproduit()
                + "',quantiteproduit='" + uneCommande.getQuantite()
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
				Commande uneCommande = new Commande(desResultats.getInt("idcommande"),
						desResultats.getInt("iduser"), desResultats.getInt("idproduit"),
						desResultats.getInt("quantiteproduit"), desResultats.getFloat("totalHT"), 
						desResultats.getFloat("totalTTC"), desResultats.getFloat("tvaCommande"),
						desResultats.getString("statut"),
						desResultats.getString("dateCommande")
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
                 uneCommande = new Commande(unResultat.getInt("idcommande"),
                unResultat.getInt("iduser"), unResultat.getInt("idproduit"),
                unResultat.getInt("quantiteproduit"), unResultat.getFloat("totalHT"), 
                unResultat.getFloat("totalTTC"), unResultat.getFloat("tvaCommande"),
                unResultat.getString("statut"),
                unResultat.getString("dateCommande")
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
