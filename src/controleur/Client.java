package controleur;

public class Client extends Users {
    private String typeclient, adresse, ville, cp;
    private int telephone; 
    
    public Client(int iduser, String email, String mdp, String nom, String roles, String datemdp, String typeclient, String adresse, String ville, String cp, int telephone){
        super(iduser, email, mdp, nom, roles, datemdp);
        this.typeclient = typeclient;
        this.adresse = adresse;
        this.ville = ville; 
        this.cp = cp;
        this.telephone = telephone; 
    }

    public Client(String email, String mdp, String nom, String roles, String datemdp, String typeclient, String adresse, String ville, String cp, int telephone){
        super(email, mdp, nom, roles, datemdp);
        this.typeclient = typeclient;
        this.adresse = adresse;
        this.ville = ville; 
        this.cp = cp;
        this.telephone = telephone; 
    }

    public Client(String email, String mdp, String nom, String adresse, String ville, String cp, int telephone){
        super(email, mdp, nom);
        this.typeclient="";
        this.adresse = adresse;
        this.ville = ville; 
        this.cp = cp;
        this.telephone = telephone; 
    }

    public Client(){
        super( );
        this.typeclient = "";
        this.adresse = "";
        this.ville = ""; 
        this.cp = "";
        this.telephone = 0; 
    }

    public String getTypeclient() {
        return typeclient;
    }

    public void setTypeclient(String typeclient) {
        this.typeclient = typeclient;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

}
