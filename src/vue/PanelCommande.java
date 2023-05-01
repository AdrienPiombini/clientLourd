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

import controleur.C_Users;
import controleur.C_Commande;
import controleur.C_Produit;
import controleur.Users;
import controleur.Commande;
import controleur.Produit;
import controleur.Tableau;

public class PanelCommande extends PanelPrincipal implements ActionListener{
	private JPanel panelForm = new JPanel(); 

	//private int derniereCommande = C_Commande.selectDerniereCommande();; 
	//private JTextField txtNbArticle = new JTextField(); 
	//private JTextField txtIdCommande = new JTextField(Integer.toString(derniereCommande)); 

    private String[] typeStatut = {"statut de la commande","en cours","validée","annulée","archivée"};
	private JComboBox<String> cbxStatut = new JComboBox<String>(typeStatut); 
	private JComboBox<String> cbxIdUser = new JComboBox<String>(); 
	private JComboBox<String> cbxIdProduit = new JComboBox<String>(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btModifier= new JButton("Modifier");
	private JButton btSupprimer= new JButton("Supprimer");

	
	private JTable tableCommandes;
	private Tableau unTableau;
	
	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");

	private int numeroCommande; 
	private String nomClient;
	private JLabel labelNomClient = new JLabel("nom client : " + nomClient);
	private JLabel labelNumCommande = new JLabel("id de la commande : " + numeroCommande);


	public PanelCommande (){
		super (); 
		this.titre.setText("_____Gestion des Commandes _____");
		//construction du Panel Form 
		this.panelForm.setBounds(10, 60, 400, 80);
		this.panelForm.setBackground(new Color (224, 224, 224));
		this.panelForm.setLayout(new GridLayout(3,2));
		this.panelForm.add(this.labelNomClient) ;
		this.panelForm.add(labelNumCommande);
        this.panelForm.add(new JLabel("Le statut : ")); 
		this.panelForm.add(this.cbxStatut);
		this.panelForm.add(this.btModifier);
		this.panelForm.add(this.btSupprimer);

		//construction de la JTable 
		String entetes[] = { "ID Commande", "Nom Client", "Nb Article", "statut", "dateComande", "tvaCommande", "totalHT", "totalTTC"}; 
		Object[][] donnees = this.getDonnees("");
		this.unTableau = new Tableau(donnees, entetes);
		this.tableCommandes = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableCommandes);
		uneScroll.setBounds(500, 60, 560, 250);

		//ajout du panelform à au panelUsers
		this.add(this.panelForm);
		//this.panelForm.setVisible(false);
		this.panelForm.setVisible(true);
		//ajout de la la jtable contenant la scrollbar
		this.add(uneScroll);
		//remplir les CBX IdUser et IdProduit 
		this.remplirCBX (); 
		
		//placement du panel Filtre
		this.panelFiltre.setBounds(500, 40, 300, 20);
		this.panelFiltre.setBackground(new Color (224, 224, 224));
		this.panelFiltre.setLayout(new GridLayout(1,3));
		this.panelFiltre.add(new JLabel("Filtrer par :"));
		this.panelFiltre.add(this.txtFiltre);
		this.panelFiltre.add(this.btFiltrer);
		this.add(this.panelFiltre);
		
		//rendre le boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btFiltrer.addActionListener(this);

		//implémentation de la suppression / modification d'une ligne
		this.tableCommandes.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = tableCommandes.getSelectedRow();
				int idCommande = Integer.parseInt(tableCommandes.getValueAt(numLigne,0).toString());
				if(e.getClickCount() >= 2){
					int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cette commande ?", "Suppression commande", JOptionPane.YES_NO_OPTION);
					if(retour == 0){
						C_Commande.deleteCommande(idCommande);
						unTableau.deleteLigne(numLigne);
						PanelStatistique.getDonneesCommande();
						PanelStatistique.unTableauCommande.updateLigne(0, PanelStatistique.ligneStatCommande);
						JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
					}
				}else if(e.getClickCount()== 1){
					Commande uneCommande = C_Commande.selectWhereUneCommande(idCommande);
					cbxStatut.setSelectedItem(uneCommande.getStatut());
					nomClient = uneCommande.getNomclient();
					numeroCommande = uneCommande.getIdcommande();
					labelNomClient.setText("nom client : " + nomClient);
					labelNumCommande.setText("id de la commande : " + numeroCommande);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});

	}

	public void remplirCBX (){
		//supprimer ou vider le CBX idUser 
		this.cbxIdUser.removeAllItems();
		//récupérer de la base de données tous les Users 
		ArrayList<Users> lesUsers = C_Users.selectAllUser(); 
		//parcourir lesUsers et remplir le CBX 
		for(Users unUser : lesUsers){
			this.cbxIdUser.addItem(unUser.getIduser()+"-"+unUser.getNom());
		}
		//supprimer ou vider le CBX idProduit 
		this.cbxIdProduit.removeAllItems();
		//récupérer de la base de données tous les Produits 
		ArrayList<Produit> lesProduits = C_Produit.selectAllProduits(""); 
		//parcourir lesProduits et remplir le CBX 
		for(Produit unProduit : lesProduits){
			this.cbxIdProduit.addItem(unProduit.getIdProduit()+"-"+unProduit.getNomProduit());
		}   
	}

	public Object[][] getDonnees(String filtre) {
		ArrayList<Commande> lesCommandes = C_Commande.selectAllCommandes(filtre);
		Object[][] matrice = new Object[lesCommandes.size()][8];
		int i = 0;
		for (Commande uneCommande : lesCommandes) {
			matrice[i][0] = uneCommande.getIdcommande();
			matrice[i][1] = uneCommande.getNomclient();
			matrice[i][2] = uneCommande.getNbarticle();
			matrice[i][3] = uneCommande.getStatut();
			matrice[i][4] = uneCommande.getDateCommande();
			matrice[i][5] = uneCommande.getTvaCommande();
			matrice[i][6] = uneCommande.getTotalHT() ;
			matrice[i][7] = uneCommande.getTotalTTC() ;
			i++;
		}
		return matrice;
	}

	public void viderChamps (){
		this.txtFiltre.setText(""); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btModifier){
			if(numeroCommande != 0){
				int numLigne = this.tableCommandes.getSelectedRow();
				int idCommande = Integer.parseInt(this.tableCommandes.getValueAt(numLigne, 0).toString());
				String nomClient = this.tableCommandes.getValueAt(numLigne, 1).toString(); 
				int nbArticle = Integer.parseInt(this.tableCommandes.getValueAt(numLigne, 2).toString()); 
				String statut = this.cbxStatut.getSelectedItem().toString(); 
				String dateCommande = this.tableCommandes.getValueAt(numLigne, 4).toString(); 
				float tvaCommande = (float) 1.2; 
				float totalHT = Float.parseFloat(this.tableCommandes.getValueAt(numLigne,6).toString()); 
				float totalTTC = Float.parseFloat(this.tableCommandes.getValueAt(numLigne,7).toString()); 
				//instancier une commande
				Commande uneCommande = new Commande(idCommande, nomClient, nbArticle, statut, dateCommande, tvaCommande, totalHT, totalTTC);
				//on la modoifie dans la base de données 
				C_Commande.updateCommande(uneCommande);
				uneCommande = C_Commande.selectWhereUneCommande(idCommande);
				Object ligne[] = { uneCommande.getIdcommande(), uneCommande.getNomclient(), uneCommande.getNbarticle(),
					uneCommande.getStatut(), uneCommande.getDateCommande(), uneCommande.getTvaCommande(),
					uneCommande.getTotalHT(), uneCommande.getTotalTTC()};
				this.unTableau.updateLigne(numLigne, ligne);
				PanelStatistique.getDonneesCommande();
				PanelStatistique.unTableauCommande.updateLigne(0, PanelStatistique.ligneStatCommande);
				JOptionPane.showMessageDialog(this, "Commande modifié avec succés !");
				this.viderChamps();	
			}else{
			JOptionPane.showMessageDialog(this, "Selectionner une commande  !");
			}

		}else if (e.getSource()==this.btFiltrer){
			String filtre = this.txtFiltre.getText();
			Object donnees[][] = this.getDonnees(filtre);
			//actualisation de l'affichage 
			this.unTableau.setDonnees(donnees);
				
		}else if (e.getSource()==this.btSupprimer){
			if(numeroCommande != 0){
				int numLigne = 0;
				Object unTableau[][] = this.getDonnees("");
				 for (int i = 0; i < unTableau.length; i++) {
					if (unTableau[i][0].equals(numeroCommande)) {
						numLigne = i;
						break;
					}
				 }
				int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cette commande ?", "Suppression commande", JOptionPane.YES_NO_OPTION);
				if(retour == 0){
					C_Commande.deleteCommande(numeroCommande);
					this.unTableau.deleteLigne(numLigne);
					PanelStatistique.getDonneesCommande();
					PanelStatistique.unTableauCommande.updateLigne(0, PanelStatistique.ligneStatCommande);
					JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Selectionner une commande  !");
			}
		}
	}


}
