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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Client;
import controleur.C_Intervention;
import controleur.C_Technicien;
import controleur.Client;
import controleur.Intervention;
import controleur.Tableau;
import controleur.Technicien;

public class PanelIntervention extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
		 
	private JTextField txtLibelle = new JTextField(); 
	private JTextField txtDateIntervention = new JTextField(); 
	private JTextField txtPrixHT = new JTextField();
	private JTextField txtPrixTTC = new JTextField();
    private String[] typeStatut = {"En attente","Validée","Annulée","Archivée"};
	private JComboBox<String> cbxStatut = new JComboBox<String>(typeStatut); 
	private JComboBox<String> cbxIdClient = new JComboBox<String>(); 
	private JComboBox<String> cbxIdTechnicien = new JComboBox<String>(); 
	private JTable tableInterventions;
	private Tableau unTableau;
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer= new JButton("Enregistrer");
	
	public PanelIntervention ()
	{
		super (); 
		this.titre.setText("_____Gestion des Interventions _____");
		//construction du Panel Form 
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color (224, 224, 224));
		this.panelForm.setLayout(new GridLayout(8,2));
		this.panelForm.add(new JLabel("Libelle : ")); 
		this.panelForm.add(this.txtLibelle);
		this.panelForm.add(new JLabel("Date Intervention : ")); 
		this.panelForm.add(this.txtDateIntervention);
		this.panelForm.add(new JLabel("Statut : ")); 
        this.panelForm.add(this.cbxStatut);
		this.panelForm.add(new JLabel("Prix HT : ")); 
		this.panelForm.add(this.txtPrixHT);
        this.panelForm.add(new JLabel("Prix TTC : ")); 
		this.panelForm.add(this.txtPrixTTC);
		this.panelForm.add(new JLabel("Le Client : ")); 
		this.panelForm.add(this.cbxIdClient);
		this.panelForm.add(new JLabel("Le Technicien : ")); 
		this.panelForm.add(this.cbxIdTechnicien);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		//ajout du panelform à au panelClients
		this.add(this.panelForm);
		//construction de la JTable 
		String entetes[] = { "IDintervention", "Libelle", "Date Intervention", "Statut", "PrixHT", "PrixTTC" , "iduser", "idtechnicien",};
		Object[][] donnees = this.getDonnees();
		this.unTableau = new Tableau(donnees, entetes);
		this.tableInterventions = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableInterventions);
		uneScroll.setBounds(360, 80, 460, 250);
		this.add(uneScroll);

		
		//remplir les CBX Idclient et Idtechnicien 
		this.remplirCBX (); 
		
		//rendre le boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this );
	}
	public void remplirCBX ()
	{
		//supprimer ou vider le CBX idclient 
		this.cbxIdClient.removeAllItems();
		//récupérer de la base de données tous les clients 
		ArrayList<Client> lesClients = C_Client.selectAllClient(); 
		//parcourir lesClients et remplir le CBX 
		for(Client unClient : lesClients)
		{
			this.cbxIdClient.addItem(unClient.getIduser()+"-"+unClient.getNom());
		}

		//supprimer ou vider le CBX idtechnicien 
		this.cbxIdTechnicien.removeAllItems();
		//récupérer de la base de données tous les techniciens 
		ArrayList<Technicien> lesTechniciens = C_Technicien.selectAllTechniciens(); 
		//parcourir lesTechniciens et remplir le CBX 
		for(Technicien unTechnicien : lesTechniciens)
		{
			this.cbxIdTechnicien.addItem(unTechnicien.getIduser()+"-"+unTechnicien.getNom());
		}
	}

	public Object[][] getDonnees() {
		ArrayList<Intervention> lesInterventions = C_Intervention.selectAllInterventions();
		Object[][] matrice = new Object[lesInterventions.size()][8];
		int i = 0;
		for (Intervention unIntervention : lesInterventions) {
			matrice[i][0] = unIntervention.getIdintervention();
			matrice[i][1] = unIntervention.getLibelle();
			matrice[i][2] = unIntervention.getDateintervention();
			matrice[i][3] = unIntervention.getStatut();
			matrice[i][4] = unIntervention.getPrixHT();
			matrice[i][5] = unIntervention.getPrixTTC();
			matrice[i][6] = unIntervention.getIduser();
			matrice[i][7] = unIntervention.getIdtechnicien();
			i++;
		}
		return matrice;
	}

	public void viderChamps ()
	{
		this.txtLibelle.setText(""); 
		this.txtDateIntervention.setText("");
		this.txtPrixHT.setText("");
		this.txtPrixTTC.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps();
		}
		else if (e.getSource() == this.btEnregistrer)
		{
			String libelle = this.txtLibelle.getText(); 
			String dateintervention = this.txtDateIntervention.getText(); 
			float prixHT = Float.parseFloat(this.txtPrixHT.getText()); 
			float prixTTC = Float.parseFloat(this.txtPrixTTC.getText()); 
			//récuperer les id client, technicien et techniciens
			String chaine = this.cbxIdClient.getSelectedItem().toString(); 
			String tab [] = chaine.split("-"); //explode de PHP 
			int idclient = Integer.parseInt(tab[0]);
			chaine = this.cbxIdTechnicien.getSelectedItem().toString(); 
			tab = chaine.split("-"); //explode de PHP 
			int idtechnicien = Integer.parseInt(tab[0]);
            chaine = this.cbxStatut.getSelectedItem().toString();
            tab = chaine.split("-");
            String statut = tab[0]; 
			
			//instancier un client 
			Intervention uneIntervention = new Intervention(libelle, dateintervention, statut, prixHT, prixTTC, idclient, idtechnicien);
			//on l'enregistre dans la base de données 
			C_Intervention.insertIntervention(uneIntervention);
			// ajout de l'intervention dans le tableau
			uneIntervention = C_Intervention.selectWhereIntervention(dateintervention, idclient, idtechnicien);
			Object ligne[] = { uneIntervention.getIdintervention(), uneIntervention.getLibelle(), uneIntervention.getDateintervention(),
				uneIntervention.getStatut(), uneIntervention.getPrixHT(), uneIntervention.getPrixTTC(), uneIntervention.getIduser(),
				uneIntervention.getIdtechnicien()};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this, " Intervention insérée avec succès !");
			this.viderChamps();
			
		}
		
	}

}