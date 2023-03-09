package controleur;

public class Admin extends Users {
    private String prenom;

    public Admin(int iduser, String email, String mdp, String nom, String roles, String datemdp, String prenom){
        super(iduser, email, mdp, nom, roles, datemdp);
        this.prenom = prenom;
    }

    public Admin(String email, String mdp, String nom, String roles, String datemdp, String prenom){
        super(email, mdp, nom, roles, datemdp);
        this.prenom = prenom;
    }

    public Admin(String email, String mdp, String nom, String prenom){
        super(email, mdp, nom);
        this.prenom = prenom;
    }

    public Admin(){
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
