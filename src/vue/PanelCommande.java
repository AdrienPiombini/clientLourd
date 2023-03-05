package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.C_Users;
import controleur.C_Commande;
import controleur.C_Produit;
import controleur.Users;
import controleur.Commande;
import controleur.Produit;

public class PanelCommande extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
	private int derniereCommande = C_Commande.selectDerniereCommande();; 
	private JTextField txtQuantite = new JTextField(); 
	private JTextField txtIdCommande = new JTextField(Integer.toString(derniereCommande)); 
    private String[] typeStatut = {"en cours","validée","annulée","archivée"};
	private JComboBox<String> cbxStatut = new JComboBox<String>(typeStatut); 
	private JComboBox<String> cbxIdUser = new JComboBox<String>(); 
	private JComboBox<String> cbxIdProduit = new JComboBox<String>(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer= new JButton("Enregistrer");
	
	public PanelCommande ()
	{
		super (); 
		this.titre.setText("_____Gestion des Commandes _____");
		//construction du Panel Form 
		this.panelForm.setBounds(20, 60, 300, 250);
		this.panelForm.setBackground(new Color (234, 176, 69));
		this.panelForm.setLayout(new GridLayout(8,2));
        this.panelForm.add(new JLabel("Id commande : ")); 
		this.panelForm.add(this.txtIdCommande);
        this.panelForm.add(new JLabel("quantité de produit : ")); 
		this.panelForm.add(this.txtQuantite);
		this.panelForm.add(new JLabel("Le Client : ")); 
		this.panelForm.add(this.cbxIdUser);
		this.panelForm.add(new JLabel("Le produit : ")); 
		this.panelForm.add(this.cbxIdProduit);
        this.panelForm.add(new JLabel("Le statut : ")); 
		this.panelForm.add(this.cbxStatut);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		//ajout du panelform à au panelUsers
		this.add(this.panelForm);
		
		//remplir les CBX IdUser et IdProduit 
		this.remplirCBX (); 
		
		//rendre le boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this );
	}
	public void remplirCBX ()
	{
		//supprimer ou vider le CBX idUser 
		this.cbxIdUser.removeAllItems();
		//récupérer de la base de données tous les Users 
		ArrayList<Users> lesUsers = C_Users.selectAllUser(); 
		//parcourir lesUsers et remplir le CBX 
		for(Users unUser : lesUsers)
		{
			this.cbxIdUser.addItem(unUser.getIduser()+"-"+unUser.getNom());
		}

		//supprimer ou vider le CBX idProduit 
		this.cbxIdProduit.removeAllItems();
		//récupérer de la base de données tous les Produits 
		ArrayList<Produit> lesProduits = C_Produit.selectAllProduits(); 
		//parcourir lesProduits et remplir le CBX 
		for(Produit unProduit : lesProduits)
		{
			this.cbxIdProduit.addItem(unProduit.getIdProduit()+"-"+unProduit.getNomProduit());
		}
        
        
	}

	public void viderChamps ()
	{
		this.txtQuantite.setText(""); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps();
		}
		else if (e.getSource() == this.btEnregistrer)
		{
			int idCommande = Integer.parseInt(this.txtIdCommande.getText());
			int quantite = Integer.parseInt(this.txtQuantite.getText()); 
			//récuperer les id User et Produits
			String chaine = this.cbxIdUser.getSelectedItem().toString(); 
			String tab [] = chaine.split("-"); //explode de PHP 
			int idUser = Integer.parseInt(tab[0]);
			chaine = this.cbxIdProduit.getSelectedItem().toString(); 
			tab = chaine.split("-"); //explode de PHP 
			int idProduit = Integer.parseInt(tab[0]);
            String statut = this.cbxStatut.getSelectedItem().toString(); 
			
			//instancier un User 
			Commande uneCommande = new Commande(idCommande, idUser, idProduit, quantite, statut);
			//on l'enregistre dans la base de données 
			C_Commande.insertPanier(uneCommande);
			JOptionPane.showMessageDialog(this, " Commande insérée avec succès !");
			this.viderChamps();
			
		}
		
	}

}