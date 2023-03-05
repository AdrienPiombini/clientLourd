package controleur;

public class Commande {
    private int idcommande, iduser, idproduit, quantite;
    private float totalHT, totalTTC, tvaCommande;
    private String statut, dateCommande ;

    public Commande(){
        this.idcommande = 0;
        this.iduser = 0; 
        this.idproduit = 0; 
        this. quantite = 0;
        this.totalHT = 0;
        this.totalTTC = 0;
        this.tvaCommande = (float) 1.2;
        this.statut = "";
        this.dateCommande = "";
    }

    public Commande(int iduser, int idproduit, int quantite, float totalHT, float totalTTC, float tvaCommande, String statut, String dateCommande){
        this.idcommande = 0;
        this.iduser = iduser; 
        this.idproduit = idproduit; 
        this. quantite = quantite;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
        this.tvaCommande = (float) 1.2;
        this.statut = statut; 
        this.dateCommande = dateCommande;
    }

    public Commande(int idcommande, int iduser, int idproduit, int quantite, float totalHT, float totalTTC, float tvaCommande, String statut, String dateCommande){
        this.idcommande = idcommande;
        this.iduser = iduser; 
        this.idproduit = idproduit; 
        this. quantite = quantite;
        this.totalHT = totalHT;
        this.totalTTC = totalTTC;
        this.tvaCommande = (float) 1.2;
        this.statut = statut; 
        this.dateCommande = dateCommande;
    }

    public Commande(int idcommande, int iduser, int idproduit, int quantite, String statut){
        this.idcommande = idcommande;
        this.iduser = iduser; 
        this.idproduit = idproduit; 
        this. quantite = quantite;
        this.totalHT = 0;
        this.totalTTC = 0;
        this.tvaCommande = (float) 1.2;
        this.statut = statut; 
        this.dateCommande = "";
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(float totalHT) {
        this.totalHT = totalHT;
    }

    public float getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(float totalTTC) {
        this.totalTTC = totalTTC;
    }

    public float getTvaCommande() {
        return tvaCommande;
    }

    public void setTvaCommande(float tvaCommande) {
        this.tvaCommande = tvaCommande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    

}
