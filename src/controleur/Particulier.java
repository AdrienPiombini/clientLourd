package controleur;

public class Particulier  extends Client{
    private String prenom;
    
    public Particulier(String email, String mdp, String nom, String adresse, String ville, String cp, int telephone, String prenom){
        super(email, mdp, nom, "client", "particulier", adresse, ville, cp, telephone);
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
}
