package controleur;

public class Particulier  extends Client{
    private String prenom;

    public Particulier(int iduser, String email, String mdp, String nom, String roles, String datemdp, String typeclient, String adresse, String ville, String cp, int telephone, String prenom){
        super(iduser, email, mdp, nom, roles, datemdp, typeclient, adresse, ville, cp, telephone);
        this.prenom = prenom; 
    }

    public Particulier (String email, String mdp, String nom, String roles, String datemdp, String typeclient, String adresse, String ville, String cp, int telephone, String prenom){
        super(email, mdp, nom, roles, datemdp, typeclient, adresse, ville, cp, telephone);
        this.prenom = prenom; 
    }

    public Particulier(){
        super();
        this.prenom = ""; 
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    
}
