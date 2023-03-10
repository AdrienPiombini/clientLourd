package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Produit;
import controleur.Produit;
import controleur.Tableau;


public class PanelProduit extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
    private JTextField txtNomProduit = new JTextField();
    private JTextField txtPrixProduit = new JTextField();
	private JTextField txtQuantite = new JTextField(); 
	private JTextField txtDescription = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer= new JButton("Enregistrer");

	private JTable tableProduits;
	private Tableau unTableau;
	
	public PanelProduit ()
	{
		super (); 
		this.titre.setText("_____Gestion des Produits _____");
		//construction du Panel Form 
		this.panelForm.setBounds(20, 50, 300, 250);
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

		//construction de la JTable 
		String entetes[] = { "ID  produit", "Nom", "Prix", "Quantite" };
		Object[][] donnees = this.getDonnees();
		this.unTableau = new Tableau(donnees, entetes);
		this.tableProduits = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableProduits);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);
	
		//rendre le boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this );
	}        


	public Object[][] getDonnees() {
		ArrayList<Produit> lesProduits = C_Produit.selectAllProduits();
		Object[][] matrice = new Object[lesProduits.size()][4];
		int i = 0;
		for (Produit unProduit : lesProduits) {
			matrice[i][0] = unProduit.getIdProduit();
			matrice[i][1] = unProduit.getNomProduit();
			matrice[i][2] = unProduit.getPrixProduit();
			matrice[i][3] = unProduit.getQuantite();
			i++;
		}
		return matrice;
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