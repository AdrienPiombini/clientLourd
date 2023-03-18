package modele;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Produit;

public class ModeleProduit 
{
	//private static Bdd uneBdd = new Bdd("localhost:3306","dsa","adrien","adrien");
	private static Bdd uneBdd = new Bdd();
	
	public static void insertProduit(Produit unProduit)
	{
		String requete = "insert into produit values (null, '"
				+ unProduit.getNomProduit()+"','" + unProduit.getPrixProduit()+"','"
				+ unProduit.getDescription()+"','" + unProduit.getQuantite()+ "');";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			uneBdd.seDeConnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
	}
	
	public static void deleteProduit (int idProduit)
	{
		String requete = "delete from produit where idProduit="+idProduit+";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			uneBdd.seDeConnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
	}
	
	public static void updateProduit (Produit unProduit){
		String requete = "update produit set nomProduit ='"
				+unProduit.getNomProduit()+"', prixProduit='" + unProduit.getPrixProduit()+"', description='"
				+unProduit.getDescription()+"', quantite='" + unProduit.getQuantite() + "' where idProduit ="+ unProduit.getIdProduit() + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			uneBdd.seDeConnecter();
		}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
	}
	
	public static ArrayList<Produit> selectAllProduits(String filtre){
		String requete = "";
		if(filtre.equals("")){
			requete = "select * from produit";
		}else{
			requete = " select * from produit where idProduit like '%" + filtre + "%' or nomProduit like '%" + filtre + "%' or prixProduit like '%" + filtre +"%' or description like '%" + filtre + "%' or quantite like '%" + filtre + "%'";
		}
		ArrayList<Produit> lesProduits = new ArrayList <Produit>();
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation des produits resultats
			ResultSet desResultats = unStat.executeQuery(requete);
			// on parcours les resultats et on instancie les produits et enfin on les ajoute dans l'ArrayList
			while (desResultats.next())
			{
				Produit unProduit = new Produit (
						desResultats.getInt("idProduit"), desResultats.getString("nomProduit"), desResultats.getFloat("prixProduit"),
						desResultats.getString("description"), desResultats.getInt("quantite")
						);
				
				// on ajoute le produit dans l'ArrayList
				lesProduits.add(unProduit);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} 
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
		}
		return lesProduits;
	}
	
	public static Produit selectWhereProduit (int idProduit)
	{
		String requete = "select * from produit where idProduit="+idProduit+";";
		Produit unProduit = null;
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul client resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul resultat 
			if (unResultat.next())
				{
					unProduit = new Produit (
							unResultat.getInt("idProduit"), unResultat.getString("nomProduit"),
							unResultat.getFloat("prixProduit"), unResultat.getString("description"), unResultat.getInt("quantite")
							);
				}
			unStat.close();
			uneBdd.seDeConnecter();
			}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
			
		}
		return unProduit;
	}
	
	public static Produit selectWhereProduit (String nomProduit)
	{
		String requete = "select * from produit where nomProduit='"+nomProduit+"';";
		Produit unProduit = null;
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// recuperation un seul client resultat
			ResultSet unResultat = unStat.executeQuery(requete);
			// on teste si on a un seul resultat 
			if (unResultat.next())
				{
					unProduit = new Produit (
							unResultat.getInt("idProduit"), unResultat.getString("nomProduit"),
							unResultat.getFloat("prixProduit"), unResultat.getString("description"), unResultat.getInt("quantite")
							);
				}
			unStat.close();
			uneBdd.seDeConnecter();
			}
		catch (Exception exp)
		{
			System.out.println("Erreur d'execution :" +requete);
			
		}
		return unProduit;
	}
}
