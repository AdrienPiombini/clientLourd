package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Produit;
import controleur.Produit;
import controleur.Tableau;


public class PanelProduit extends PanelPrincipal implements ActionListener{
	private JPanel panelForm = new JPanel(); 
    private JTextField txtNomProduit = new JTextField();
    private JTextField txtPrixProduit = new JTextField();
	private JTextField txtQuantite = new JTextField(); 
	private JTextField txtDescription = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer= new JButton("Enregistrer");

	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");

	private JTable tableProduits;
	private Tableau unTableau;

	private String[] typeTVA = {"20%","15%","5%"};
	private JComboBox<String> cbxTVA = new JComboBox<String>(typeTVA); 
	private JPanel panelTotalCA = new JPanel();
	private JTextField txtTotalCA = new JTextField();
	private Float totalCA = (float) 0;
	
	public PanelProduit (){
		super (); 
		this.titre.setText("_____Gestion des Produits _____");
		//construction du Panel Form 
		this.panelForm.setBounds(20, 50, 300, 250);
		this.panelForm.setBackground(new Color (224, 224, 224));
		this.panelForm.setLayout(new GridLayout(6,2));
        this.panelForm.add(new JLabel("Nom : ")); 
		this.panelForm.add(this.txtNomProduit);
        this.panelForm.add(new JLabel("Prix : ")); 
		this.panelForm.add(this.txtPrixProduit);
        this.panelForm.add(new JLabel("Description : ")); 
		this.panelForm.add(this.txtDescription);
        this.panelForm.add(new JLabel("quantité de produit : ")); 
		this.panelForm.add(this.txtQuantite);
        this.panelForm.add(new JLabel("taux tva : ")); 
		this.panelForm.add(this.cbxTVA);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		//ajout du panelform à au panelUsers
		this.add(this.panelForm);

		//construction de la JTable 
		String entetes[] = { "ID  produit", "Nom", "Prix", "Quantite" };
		Object[][] donnees = this.getDonnees("");
		this.unTableau = new Tableau(donnees, entetes);
		this.tableProduits = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableProduits);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);

		//implémentation de la suppression / modification d'une ligne
		this.tableProduits.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = tableProduits.getSelectedRow();
				int idProduit = Integer.parseInt(tableProduits.getValueAt(numLigne, 0).toString());
				if(e.getClickCount() >= 2){
					int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer ce produit ?", "Suppression produit", JOptionPane.YES_NO_OPTION);
					if(retour == 0){
						C_Produit.deleteProduit(idProduit);
						unTableau.deleteLigne(numLigne);
						JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
						 calculCA("");
					}
				}else if(e.getClickCount()== 1){
					//on remplie les champs de modification 
					Produit unProduit = C_Produit.selectWhereProduit(idProduit);
					txtDescription.setText(unProduit.getDescription());
					txtNomProduit.setText(tableProduits.getValueAt(numLigne,1).toString()); 
					txtPrixProduit.setText(tableProduits.getValueAt(numLigne,2).toString()); 
					txtQuantite.setText(tableProduits.getValueAt(numLigne,3).toString()); 
			
					btEnregistrer.setText("Modifier");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

		});


		//placement du panel Filtre
		this.panelFiltre.setBounds(400, 40, 300, 20);
		this.panelFiltre.setBackground(new Color (224, 224, 224));
		this.panelFiltre.setLayout(new GridLayout(1,3));
		this.panelFiltre.add(new JLabel("Filtrer par :"));
		this.panelFiltre.add(this.txtFiltre);
		this.panelFiltre.add(this.btFiltrer);
		this.add(this.panelFiltre);

		//placement du panel Filtre
		this.panelTotalCA.setBounds(400, 350, 300, 20);
		this.panelTotalCA.setBackground(new Color (224, 224, 224));
		this.panelTotalCA.setLayout(new GridLayout(1,3));
		this.panelTotalCA.add(new JLabel("Total CA :"));
		this.panelTotalCA.add(this.txtTotalCA);
		this.add(this.panelTotalCA);

		this.txtTotalCA.setText(totalCA.toString());
	
		//rendre le boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this );
		this.btFiltrer.addActionListener(this);
	}        


	public Object[][] getDonnees(String filtre) {
		ArrayList<Produit> lesProduits = C_Produit.selectAllProduits(filtre);
		Object[][] matrice = new Object[lesProduits.size()][4];
		int i = 0;
		for (Produit unProduit : lesProduits) {
			matrice[i][0] = unProduit.getIdProduit();
			matrice[i][1] = unProduit.getNomProduit();
			matrice[i][2] = unProduit.getPrixProduit();
			matrice[i][3] = unProduit.getQuantite();
			i++;
			totalCA = totalCA + unProduit.getQuantite() * unProduit.getPrixProduit();

		}
		return matrice;
	}

	public void calculCA(String filtre){
		ArrayList<Produit> lesProduits = C_Produit.selectAllProduits(filtre);
		totalCA = (float) 0;
		for (Produit unProduit : lesProduits) {
		totalCA = totalCA + unProduit.getQuantite() * unProduit.getPrixProduit();
		}
		this.txtTotalCA.setText(totalCA.toString());
	}
        
	public void viderChamps ()
	{
		this.txtNomProduit.setText(""); 
		this.txtPrixProduit.setText(""); 
		this.txtDescription.setText(""); 
		this.txtQuantite.setText(""); 
		btEnregistrer.setText("Enregistrer");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps();

		}else if (e.getSource()== this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")){
            String nomProduit = this.txtNomProduit.getText();
			Float prixProduit = Float.parseFloat(this.txtPrixProduit.getText());
            String description = this.txtDescription.getText();
			int quantite = Integer.parseInt(this.txtQuantite.getText()); 
			
			//instancier un User 
			Produit unProduit = new Produit(nomProduit, prixProduit, description, quantite);
			//on l'enregistre dans la base de données 
			C_Produit.insertProduit(unProduit);
			// ajout du client dans le tableau
			unProduit = C_Produit.selectWhereProduit(nomProduit);
			Object ligne[] = { unProduit.getIdProduit(), unProduit.getNomProduit(), unProduit.getPrixProduit(),
				unProduit.getQuantite()};
			this.unTableau.insertLigne(ligne);

			JOptionPane.showMessageDialog(this, " Produit insérée avec succès !");
			this.viderChamps();
			calculCA("");
			
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")){
			String nomProduit = this.txtNomProduit.getText();
			Float prixProduit = Float.parseFloat(this.txtPrixProduit.getText());
            String description = this.txtDescription.getText();
			int quantite = Integer.parseInt(this.txtQuantite.getText()); 
			int numLigne = this.tableProduits.getSelectedRow(); 
			int idProduit = Integer.parseInt(this.tableProduits.getValueAt(numLigne, 0).toString());
			
			// instancier un client
			Produit unProduit = new Produit(idProduit, nomProduit, prixProduit, description, quantite);
			// on le modifie dans la base de données
			C_Produit.updateProduit(unProduit);

			// ajout de l'Produit dans le tableau
			unProduit = C_Produit.selectWhereProduit(idProduit);
			Object ligne[] = { unProduit.getIdProduit(), unProduit.getNomProduit(), unProduit.getPrixProduit(),
				unProduit.getQuantite()};
			this.unTableau.updateLigne(numLigne, ligne);

			JOptionPane.showMessageDialog(this, "Produit modifié avec succés !");
			this.viderChamps();
			calculCA("");

		}else if (e.getSource()==this.btFiltrer){
			String filtre = this.txtFiltre.getText();
			Object donnees[][] = this.getDonnees(filtre);
			//actualisation de l'affichage 
			this.unTableau.setDonnees(donnees);
		}
		
	}

}