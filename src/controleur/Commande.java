package controleur;

public class Commande {
    private int idcommande, iduser, idproduit, quantite, nbArticle;
    private float totalHT, totalTTC, tvaCommande;
    private String statut, dateCommande, nomClient ;


    public Commande(int idcommande, int iduser, int idproduit, int quantite, String statut, String dateCommande, float tvaCommande, float totalHT, float totalTTC){
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

    public Commande(int idcommande, String nomClient, int nbArticle, String statut, String dateCommande, float tvaCommande, float totalHT, float totalTTC){
        this.idcommande = idcommande;
        this.nomClient = nomClient; 
        this.nbArticle = nbArticle; 
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

    public String getNomclient(){
        return nomClient;
    }

    public void setNomclient(String nomClient){
        this.nomClient = nomClient;
    }

    public int getNbarticle(){
        return nbArticle;
    }

    public void setNbarticle(int nbArticle){
        this.nbArticle = nbArticle;
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
