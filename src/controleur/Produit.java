package controleur;

public class Produit {
	
	private int idProduit, quantite;
	private String nomProduit, description;
	private float prixProduit;
	
	public Produit (int idProduit, String nomProduit, float prixProduit, String description, int quantite)
	{
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.description = description;
		this.quantite = quantite;
	}
	
	public Produit (String nomProduit, float prixProduit, String description, int quantite)
	{
		this.idProduit = 0;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.description = description;
		this.quantite = quantite;
	}
	
	public Produit () {
		this.idProduit = 0;
		this.nomProduit = "";
		this.prixProduit = 0;
		this.description = "";
		this.quantite = 0;
	}
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}
	
}
