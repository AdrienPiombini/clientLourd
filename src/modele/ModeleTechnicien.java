package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Technicien;

public class ModeleTechnicien {

	//private static Bdd uneBdd = new Bdd("localhost:3306", "dsa", "adrien", "adrien");
    private static Bdd uneBdd = new Bdd();
    
    public static void insertTechnicien(Technicien unTechnicien) {
        String requete = "INSERT INTO technicien VALUES ( null,'"
                + unTechnicien.getEmail() + "', '"
                + unTechnicien.getMdp() + "', '"
                + unTechnicien.getNom() +"', 'technicien', curdate(), '"
                + unTechnicien.getPrenom() + "', '"
                + unTechnicien.getDiplome() + "', '"
                + unTechnicien.getDateEmb() + "', '"
                + unTechnicien.getDateDept() + "');";
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

    public static void insertTechnicienCDI(Technicien unTechnicien) {
        String requete = "INSERT INTO technicien VALUES ( null,'"
                + unTechnicien.getEmail() + "', '"
                + unTechnicien.getMdp() + "', '"
                + unTechnicien.getNom() +"', 'technicien', curdate(), '"
                + unTechnicien.getPrenom() + "', '"
                + unTechnicien.getDiplome() + "', '"
                + unTechnicien.getDateEmb() + "', NULL);";
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

    public static void updateTechnicien(Technicien unTechnicien) {
        String requete = "UPDATE technicien SET email = '" 
        		+ unTechnicien.getEmail() + "', mdp = '" 
        		+ unTechnicien.getMdp() + "', nom = '" 
        		+ unTechnicien.getNom() + "', prenom = '" 
        		+ unTechnicien.getPrenom() + "', diplome = '" 
        		+ unTechnicien.getDiplome() + "', dateEmb = '" 
        		+ unTechnicien.getDateEmb() + "', dateDept = '" 
        		+ unTechnicien.getDateDept() + "' WHERE email = '" 
        		+ unTechnicien.getEmail() + "';";
        
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

    public static void deleteTechnicien(String email) {
        String requete = "DELETE FROM technicien WHERE email = '"+email+"';";
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

    public static ArrayList<Technicien> selectAllTechnicien(String filtre) {
        String requete = "";
		if(filtre.equals("")){
		 requete = " select * from technicien ;";
		}else {
			requete = " select * from technicien where nom like '%" + filtre + "%' or prenom like '%" + filtre
					+ "%' or email like '%" + filtre + "%' or diplome like '%" + filtre + "%' or dateEmb like '%" + filtre + "%' or dateDept like '%" + filtre + "%';";
		}
        ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation des Techniciens
            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
            // on parcours les resultats et on instancie les Techniciens
            while (desResultats.next()) {
                Technicien unTechnicien = new Technicien(
                        desResultats.getInt("iduser"),
                        desResultats.getString("email"),
                        desResultats.getString("mdp"),
                        desResultats.getString("nom"),
                        desResultats.getString("roles"),
                        desResultats.getString("datemdp"),
                        desResultats.getString("prenom"),
                        desResultats.getString("diplome"),
                        desResultats.getString("dateEmb"), 
                        desResultats.getString("dateDept"));
                // on ajoute le Technicien dans l'ArrayList
                lesTechniciens.add(unTechnicien);
            }
            unStat.close();
            uneBdd.seDeConnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return lesTechniciens;
    }

    public static Technicien selectWhereTechnicien(String email) {
        Technicien unTechnicien = null;
        String requete = "SELECT * FROM technicien WHERE email = '"+email+"';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Technicien
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un résultat
            if (unResultat.next()) {
                unTechnicien = new Technicien(
                        unResultat.getInt("iduser"),
                        unResultat.getString("email"),
                        unResultat.getString("mdp"),
                        unResultat.getString("nom"),
                        unResultat.getString("roles"),
                        unResultat.getString("datemdp"),
                        unResultat.getString("prenom"),
                        unResultat.getString("diplome"),
                        unResultat.getString("dateEmb"),
                        unResultat.getString("dateDept"));
            }
            unStat.close();
            uneBdd.seDeConnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return unTechnicien;
    }
}
