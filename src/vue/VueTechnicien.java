package vue;

import java.util.Scanner;

import controleur.Technicien;

public class VueTechnicien {

	public static Technicien saisirTechnicien ()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Donner le mail du Technicien :");
		String email = sc.next();
		System.out.println("Donner le mdp du Techncien :");
		String mdp = sc.next();
		System.out.println("Donner nom du Technicien :");
		String nom = sc.next();
		System.out.println("Donner le rôle du Technicien :");
		String roles = sc.next();
		System.out.println("Donner la date du mdp du Technicien :");
		String datemdp = sc.next();
		System.out.println("Donner le prenom du Technicien :");
		String prenom = sc.next();
		System.out.println("Donner le diplôme du Technicien :");
		String diplome = sc.next();
		System.out.println("Donner la date d'embauche du Technicien :");
		String dateEmb = sc.next();
		System.out.println("Donner la date de départ du Technicien :");
		String dateDept = sc.next();
		// Instanciation de la classe Technicien
		Technicien unTechnicien = new Technicien(email, mdp, nom, roles, datemdp, prenom, diplome, dateEmb, dateDept);
		return unTechnicien;
	}
	
	public static void afficherTechnicien(Technicien unTechnicien)
	{
		System.out.println("Email Technicien : " +unTechnicien.getEmail());
		System.out.println("Mdp Technicien : " +unTechnicien.getMdp());
		System.out.println("Nom Technicien : " +unTechnicien.getNom());
		System.out.println("Rôle Technicien : " +unTechnicien.getRoles());
		System.out.println("Date mdp Technicien : " +unTechnicien.getDatemdp());
		System.out.println("Prenom Technicien : " +unTechnicien.getPrenom());
		System.out.println("Diplôme Technicien : " +unTechnicien.getDiplome());
		System.out.println("Date d'embauche du Technicien : " +unTechnicien.getDateEmb());
		System.out.println("Date de départ du Technicien : " +unTechnicien.getDateDept());
	}
	
	public static Technicien modifierTechnicien (Technicien unTechnicien)
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Ancien email du Technicien :" +unTechnicien.getEmail());
		System.out.println("Donner le nouvel email du Technicien : ");
		unTechnicien.setEmail(sc.next());
		
		System.out.println("Ancien Mdp du Technicien :" +unTechnicien.getMdp());
		System.out.println("Donner le nouveau Mdp du Technicien : ");
		unTechnicien.setMdp(sc.next());
		
		System.out.println("Ancien nom du Technicien :" +unTechnicien.getNom());
		System.out.println("Donner le nouveau nom du Technicien : ");
		unTechnicien.setNom(sc.next());
		
		System.out.println("Ancien rôle du Technicien :" +unTechnicien.getRoles());
		System.out.println("Donner le nouveau rôle Technicien : ");
		unTechnicien.setRoles(sc.next());
		
		System.out.println("Ancienne date de mdp du Technicien :" +unTechnicien.getDatemdp());
		System.out.println("Donner la nouvelle date de mdp du Technicien : ");
		unTechnicien.setDatemdp(sc.next());
		
		System.out.println("Ancien prénom du Technicien :" +unTechnicien.getPrenom());
		System.out.println("Donner le nouveau prénom du Technicien : ");
		unTechnicien.setPrenom(sc.next());
		
		System.out.println("Ancien diplôme du Technicien :" +unTechnicien.getDiplome());
		System.out.println("Donner le nouveau diplôme du Technicien : ");
		unTechnicien.setDiplome(sc.next());
		
		System.out.println("Ancienne date d'embauche du Technicien :" +unTechnicien.getDateEmb());
		System.out.println("Donner la nouvelle date d'embauchee du Technicien : ");
		unTechnicien.setDateEmb(sc.next());
		
		System.out.println("Ancienne date de départ du Technicien :" +unTechnicien.getDateDept());
		System.out.println("Donner la nouvelle date de départ du Technicien : ");
		unTechnicien.setDateDept(sc.next());
		
		return unTechnicien;
	}
}
