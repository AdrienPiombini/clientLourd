package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Professionnel;

public class ModeleProfessionnel {

	//private static Bdd uneBdd = new Bdd("localhost:3306", "dsa", "adrien", "adrien");
    private static Bdd uneBdd = new Bdd();
    
    public static void insertProfessionnel(Professionnel unProfessionnel) {
        String requete = "INSERT INTO professionnel VALUES ( null,'"
                + unProfessionnel.getEmail() + "', '"
                + unProfessionnel.getMdp() + "', '"
                + unProfessionnel.getNom() + "', 'client', curdate(), 'professionnel', '"
                + unProfessionnel.getAdresse() + "', '"
                + unProfessionnel.getVille() + "', '"
                + unProfessionnel.getCp() + "', '"
                + unProfessionnel.getTelephone() + "', '"
                + unProfessionnel.getNumeroSiret() + "');";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeConnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static void updateProfessionnel(Professionnel unProfessionnel) {
        String requete = "UPDATE professionnel SET email = '" 
        		+ unProfessionnel.getEmail() + "', mdp = '" 
        		+ unProfessionnel.getMdp() + "', nom = '" 
        		+ unProfessionnel.getNom() + "', adresse = '" 
        		+ unProfessionnel.getAdresse() + "', ville = '" 
        		+ unProfessionnel.getVille() + "', cp = '" 
        		+ unProfessionnel.getCp() + "', telephone = '" 
        		+ unProfessionnel.getTelephone() + "', numeroSiret = '" 
        		+ unProfessionnel.getNumeroSiret() + "' WHERE email = '" 
        		+ unProfessionnel.getEmail() + "';";
        
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeConnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static void deleteProfessionnel(String email) {
        String requete = "DELETE FROM professionnel WHERE email = '"+email+"';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeConnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static ArrayList<Professionnel> selectAllProfessionnel(String filtre) {
        String requete = "";
		if(filtre.equals("")){
		 requete = " select * from professionnel ;";
		}else {
			requete = " select * from professionnel where nom like '%" + filtre + "%' or numeroSiret like '%" + filtre
					+ "%' or email like '%" + filtre + "%' or adresse like '%" + filtre + "%' or ville like '%" + filtre + "%' or cp like '%" + filtre + "%' or telephone like '%" + filtre + "%';";
		}	
        ArrayList<Professionnel> lesProfessionnels = new ArrayList<Professionnel>();
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation des Professionnels
            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
            // on parcours les resultats et on instancie les Professionnels
            while (desResultats.next()) {
            	Professionnel unProfessionnel = new Professionnel(
                        desResultats.getInt("iduser"),
                        desResultats.getString("email"),
                        desResultats.getString("mdp"),
                        desResultats.getString("nom"),
                        desResultats.getString("roles"),
                        desResultats.getString("datemdp"),
                        desResultats.getString("typeclient"),
                        desResultats.getString("adresse"),
                        desResultats.getString("ville"),
                        desResultats.getString("cp"),
                        desResultats.getInt("telephone"), 
                        desResultats.getInt("numeroSiret"));
                // on ajoute le Professionnel dans l'ArrayList
                lesProfessionnels.add(unProfessionnel);
            }
            unStat.close();
            uneBdd.seDeConnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return lesProfessionnels;
    }

    public static Professionnel selectWhereProfessionnel(String email) {
    	Professionnel unProfessionnel = null;
        String requete = "SELECT * FROM professionnel WHERE email = '"+email+"';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Professionnel
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un résultat
            if (unResultat.next()) {
                unProfessionnel = new Professionnel(
                        unResultat.getInt("iduser"),
                        unResultat.getString("email"),
                        unResultat.getString("mdp"),
                        unResultat.getString("nom"),
                        unResultat.getString("roles"),
                        unResultat.getString("datemdp"),
                        unResultat.getString("typeclient"),
                        unResultat.getString("adresse"),
                        unResultat.getString("ville"),
                        unResultat.getString("cp"),
                        unResultat.getInt("telephone"),
                        unResultat.getInt("numeroSiret"));
            }
            unStat.close();
            uneBdd.seDeConnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return unProfessionnel;
    }
}
