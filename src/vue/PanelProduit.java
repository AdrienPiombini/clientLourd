package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.C_Produit;
import controleur.Produit;


public class PanelProduit extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
    private JTextField txtNomProduit = new JTextField();
    private JTextField txtPrixProduit = new JTextField();
	private JTextField txtQuantite = new JTextField(); 
	private JTextField txtDescription = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer= new JButton("Enregistrer");
	
	public PanelProduit ()
	{
		super (); 
		this.titre.setText("_____Gestion des Produits _____");
		//construction du Panel Form 
		this.panelForm.setBounds(20, 60, 300, 250);
		this.panelForm.setBackground(new Color (234, 176, 69));
		this.panelForm.setLayout(new GridLayout(5,2));
        this.panelForm.add(new JLabel("Nom : ")); 
		this.panelForm.add(this.txtNomProduit);
        this.panelForm.add(new JLabel("Prix : ")); 
		this.panelForm.add(this.txtPrixProduit);
        this.panelForm.add(new JLabel("Description : ")); 
		this.panelForm.add(this.txtDescription);
        this.panelForm.add(new JLabel("quantité de produit : ")); 
		this.panelForm.add(this.txtQuantite);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		//ajout du panelform à au panelUsers
		this.add(this.panelForm);
	
		//rendre le boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this );
	}        
        
	public void viderChamps ()
	{
		this.txtNomProduit.setText(""); 
		this.txtPrixProduit.setText(""); 
		this.txtDescription.setText(""); 
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
            String nomProduit = this.txtNomProduit.getText();
			Float prixProduit = Float.parseFloat(this.txtPrixProduit.getText());
            String description = this.txtDescription.getText();
			int quantite = Integer.parseInt(this.txtQuantite.getText()); 
					
			//instancier un User 
			Produit unProduit = new Produit(nomProduit, prixProduit, description, quantite);
			//on l'enregistre dans la base de données 
			C_Produit.insertProduit(unProduit);
			JOptionPane.showMessageDialog(this, " Produit insérée avec succès !");
			this.viderChamps();
			
		}
		
	}

}