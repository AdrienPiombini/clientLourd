package controleur;

public class Intervention {
    private int idintervention, iduser, idtechnicien; 
    private String libelle, dateintervention, statut;
    private float prixHT, prixTTC;

    public Intervention(String libelle, String dateintervention, String statut, float prixHT, float prixTTC, int iduser, int idtechnicien){
        this.idintervention = 0;
        this.libelle  = libelle ;
        this.dateintervention = dateintervention; 
        this.statut = statut;
        this.prixHT = prixHT;
        this.prixTTC = prixTTC;
        this.iduser = iduser;
        this.idtechnicien = idtechnicien;
    }

    public int getIdintervention() {
        return idintervention;
    }

    public void setIdintervention(int idintervention) {
        this.idintervention = idintervention;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdtechnicien() {
        return idtechnicien;
    }

    public void setIdtechnicien(int idtechnicien) {
        this.idtechnicien = idtechnicien;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDateintervention() {
        return dateintervention;
    }

    public void setDateintervention(String dateintervention) {
        this.dateintervention = dateintervention;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public float getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(float prixTTC) {
        this.prixTTC = prixTTC;
    }

    
}
