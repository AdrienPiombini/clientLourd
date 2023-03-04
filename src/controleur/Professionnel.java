package controleur;

public class Professionnel extends Client {

	private int numeroSiret;
	
	public Professionnel ()
	{
		super(); // Appel du constructeur de la mère dans la fille
		this.numeroSiret = 0;
	}
	
	public Professionnel (int iduser, String email, String mdp, String nom, String roles, String datemdp, String typeclient, String adresse, String ville, String cp, int telephone, int numeroSiret)
	{
		super (iduser, email, mdp, nom, roles, datemdp, typeclient, adresse, ville, cp, telephone); // Appel du constructeur de la mère dans la fille
		this.numeroSiret = numeroSiret;
	}
	
	public Professionnel (String email, String mdp, String nom, String roles, String datemdp, String typeclient, String adresse, String ville, String cp, int telephone, int numeroSiret)
	{
		super (email, mdp, nom, roles, datemdp, typeclient, adresse, ville, cp, telephone); // Appel du constructeur de la mère dans la fille
		this.numeroSiret = numeroSiret;
	}

	public Professionnel (String email, String mdp, String nom, String adresse, String ville, String cp, int telephone, int numeroSiret){
		super (email, mdp, nom, adresse, ville, cp, telephone); // Appel du constructeur de la mère dans la fille
		this.numeroSiret = numeroSiret;
	}

	public int getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(int numeroSiret) {
		this.numeroSiret = numeroSiret;
	}
	
	
}
