package controleur;

import java.sql.Date;


public class Users {
    protected int iduser ;
    protected String email, mdp, nom, roles, datemdp;


    public Users(int iduser, String email, String mdp, String nom, String roles, String datemdp ){
        this.iduser = iduser;
        this.email = email; 
        this.mdp = mdp;
        this.nom = nom; 
        this.roles = roles; 
        this.datemdp = datemdp;
    }

    public Users( String email, String mdp, String nom, String roles, String datemdp ){
        this.iduser = 0;
        this.email = email; 
        this.mdp = mdp;
        this.nom = nom; 
        this.roles = roles; 
        this.datemdp = datemdp;
    }

    public Users( String email, String mdp, String nom, String roles ){
        this.iduser = 0;
        this.email = email; 
        this.mdp = mdp;
        this.nom = nom; 
        this.roles = roles; 
        this.datemdp = "";
    }

    public Users(){
        this.iduser = 0;
        this.email = ""; 
        this.mdp = "";
        this.nom = ""; 
        this.roles = ""; 
        this.datemdp = "";
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDatemdp() {
        return datemdp;
    }

    public void setDatemdp(String datemdp) {
        this.datemdp = datemdp;
    }

    
}