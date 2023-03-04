package vue.old_vue;
import java.util.Scanner;
import controleur.Professionnel;

public class VueProfessionnel {

	public static Professionnel saisirProfessionnel ()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Donner le mail du Professionnel :");
		String email = sc.next();
		System.out.println("Donner le mdp du Professionnel :");
		String mdp = sc.next();
		System.out.println("Donner nom du Professionnel :");
		String nom = sc.next();
		System.out.println("Donner le rôle du Professionnel :");
		String roles = sc.next();
		System.out.println("Donner la date du mdp du Professionnel :");
		String datemdp = sc.next();
		System.out.println("Donner le type client du Professionnel :");
		String typeclient = sc.next();
		System.out.println("Donner l'adresse du Professionnel :");
		String adresse = sc.next();
		System.out.println("Donner la ville du Professionnel :");
		String ville = sc.next();
		System.out.println("Donner le code postal du Professionnel :");
		String cp = sc.next();
		System.out.println("Donner le numero de téléphone du Professionnel :");
		int telephone = sc.nextInt();
		System.out.println("Donner le numéro de SIRET du Professionnel :");
		int numeroSiret = sc.nextInt();
		// Instanciation de la classe Technicien
		Professionnel unProfessionnel = new Professionnel(email, mdp, nom, roles, datemdp, typeclient, adresse, ville, cp, telephone, numeroSiret);
		return unProfessionnel;
	}
	
	public static void afficherProfessionnel(Professionnel unProfessionnel)
	{
		System.out.println("ID du Professionnel : " +unProfessionnel.getIduser());
		System.out.println("Email Professionnel : " +unProfessionnel.getEmail());
		System.out.println("Mdp Professionnel : " +unProfessionnel.getMdp());
		System.out.println("Nom Professionnel : " +unProfessionnel.getNom());
		System.out.println("Rôle Professionnel : " +unProfessionnel.getRoles());
		System.out.println("Date mdp Professionnel : " +unProfessionnel.getDatemdp());
		System.out.println("Type client Professionnel : " +unProfessionnel.getTypeclient());
		System.out.println("Adresse Professionnel : " +unProfessionnel.getAdresse());
		System.out.println("Ville du Professionnel : " +unProfessionnel.getVille());
		System.out.println("Code postal du Professionnel : " +unProfessionnel.getCp());
		System.out.println("Téléphone du Professionnel : " +unProfessionnel.getTelephone());
		System.out.println("Numéro SIRET du Professionnel : " +unProfessionnel.getNumeroSiret());
	}
	
	public static Professionnel modifierProfessionnel (Professionnel unProfessionnel)
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Ancien email du Professionnel :" +unProfessionnel.getEmail());
		System.out.println("Donner le nouvel email du Professionnel : ");
		unProfessionnel.setEmail(sc.next());
		
		System.out.println("Ancien Mdp du Professionnel :" +unProfessionnel.getMdp());
		System.out.println("Donner le nouveau Mdp du Professionnel : ");
		unProfessionnel.setMdp(sc.next());
		
		System.out.println("Ancien nom du Professionnel :" +unProfessionnel.getNom());
		System.out.println("Donner le nouveau nom du Professionnel : ");
		unProfessionnel.setNom(sc.next());
		
		System.out.println("Ancien rôle du Professionnel :" +unProfessionnel.getRoles());
		System.out.println("Donner le nouveau rôle Professionnel : ");
		unProfessionnel.setRoles(sc.next());
		
		System.out.println("Ancienne date de mdp du Professionnel :" +unProfessionnel.getDatemdp());
		System.out.println("Donner la nouvelle date de mdp du Professionnel : ");
		unProfessionnel.setDatemdp(sc.next());
		
		System.out.println("Ancien type de client du Professionnel :" +unProfessionnel.getTypeclient());
		System.out.println("Donner le nouveau type de client du Professionnel : ");
		unProfessionnel.setTypeclient(sc.next());
		
		System.out.println("Ancienne adresse du Professionnel :" +unProfessionnel.getAdresse());
		System.out.println("Donner la nouvelle adresse du Professionnel : ");
		unProfessionnel.setAdresse(sc.next());
		
		System.out.println("Ancienne ville du Professionnel :" +unProfessionnel.getVille());
		System.out.println("Donner la nouvelle date d'embauchee du Technicien : ");
		unProfessionnel.setVille(sc.next());
		
		System.out.println("Ancien code postal du Professionnel :" +unProfessionnel.getCp());
		System.out.println("Donner le nouveau code postal du Professionnel : ");
		unProfessionnel.setCp(sc.next());
		
		System.out.println("Ancien numéro de téléphone du Professionnel :" +unProfessionnel.getTelephone());
		System.out.println("Donner le nouveau numéro de téléphone du Professionnel : ");
		unProfessionnel.setTelephone(sc.nextInt());
		
		System.out.println("Ancien numéro de SIRET du Professionnel :" +unProfessionnel.getNumeroSiret());
		System.out.println("Donner le nouveau numéro de SIRET du Professionnel : ");
		unProfessionnel.setNumeroSiret(sc.nextInt());
		
		return unProfessionnel;
	}
}
