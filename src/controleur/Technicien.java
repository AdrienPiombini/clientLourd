package controleur;

public class Technicien extends Users {

	private String prenom, diplome, dateEmb, dateDept;
	
	public Technicien () 
	{
		super(); // Appel du constructeur de la mère dans la fille
		this.prenom = "";
		this.diplome = ""; 
		this.dateEmb = "";
		this.dateDept = "";
	}
	
	public Technicien (int iduser, String email, String mdp, String nom, String roles, String datemdp, String prenom, String diplome, String dateEmb, String dateDept) 
	{
		super(iduser, email, mdp, nom, roles, datemdp); // Appel du constructeur de la mère dans la fille
		this.prenom = prenom;
		this.diplome = diplome;
		this.dateEmb = dateEmb;
		this.dateDept = dateDept;
	}
	
	public Technicien (String email, String mdp, String nom, String roles, String datemdp, String prenom, String diplome, String dateEmb, String dateDept) 
	{
		super(email, mdp, nom, roles, datemdp); // Appel du constructeur de la mère dans la fille
		this.prenom = prenom;
		this.diplome = diplome;
		this.dateEmb = dateEmb;
		this.dateDept = dateDept;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getDateEmb() {
		return dateEmb;
	}

	public void setDateEmb(String dateEmb) {
		this.dateEmb = dateEmb;
	}

	public String getDateDept() {
		return dateDept;
	}

	public void setDateDept(String dateDept) {
		this.dateDept = dateDept;
	}
	
		
}
