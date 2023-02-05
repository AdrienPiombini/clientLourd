package controleur;

public class Admin extends Users {
    private String prenom;
    
    public Admin(String email, String mdp, String nom, String prenom){
        super(email, mdp, nom, "admin");
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
}
