package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Particulier;
import controleur.Particulier;
import controleur.Tableau;

public class PanelParticulier extends PanelPrincipal implements ActionListener {

	private JPanel panelForm = new JPanel();

	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtCp = new JTextField();
	private JTextField txtTelephone = new JTextField();

	private JTable tableParticuliers;
	private Tableau unTableau;

	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");



	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelParticulier() {
		super();
		this.titre.setText("_____Gestion des Particuliers_______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(224, 224, 224));
		this.panelForm.setLayout(new GridLayout(9, 2));
		this.panelForm.add(new JLabel("Email Particulier : "));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Mot de passe Particulier : "));
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(new JLabel("Nom  : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prenom : "));
		this.panelForm.add(this.txtPrenom);
        this.panelForm.add(new JLabel("Adresse : "));
		this.panelForm.add(this.txtAdresse);
        this.panelForm.add(new JLabel("Ville : "));
		this.panelForm.add(this.txtVille);
        this.panelForm.add(new JLabel("Code postal : "));
		this.panelForm.add(this.txtCp);
        this.panelForm.add(new JLabel("Telephone : "));
		this.panelForm.add(this.txtTelephone);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);

		// ajout du panelform au panel Clients
		this.add(this.panelForm);

		//construction de la JTable 
		String entetes[] = { "ID User", "Nom", "Prenom", "Email", "DateMdp", "Roles" , "typeclient", "adresse", "ville", "cp", "telephone"};
		Object[][] donnees = this.getDonnees("");
		this.unTableau = new Tableau(donnees, entetes);
		this.tableParticuliers = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableParticuliers);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);

		//implémentation de la suppression / modification d'une ligne
		this.tableParticuliers.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = tableParticuliers.getSelectedRow();
				String email = tableParticuliers.getValueAt(numLigne,3).toString();
				if(e.getClickCount() >= 2){
					int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cet user ?", "Suppression user", JOptionPane.YES_NO_OPTION);
					if(retour == 0){
						C_Particulier.deleteParticulier(email);
						unTableau.deleteLigne(numLigne);
						JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
					}
				}else if(e.getClickCount()== 1){
					//on remplie les champs de modification 
					Particulier unParticulier = C_Particulier.selectWhereParticulier(email);
					txtEmail.setText(unParticulier.getEmail());
					txtMdp.setText(unParticulier.getMdp());
					txtPrenom.setText(unParticulier.getPrenom());
					txtNom.setText(unParticulier.getNom());
					txtAdresse.setText(unParticulier.getAdresse());
					txtVille.setText(unParticulier.getVille());
					txtCp.setText(unParticulier.getCp());
					txtTelephone.setText(String.valueOf(unParticulier.getTelephone()));

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

		// rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFiltrer.addActionListener(this);

	}

	public Object[][] getDonnees(String filtre) {
		ArrayList<Particulier> lesParticuliers = C_Particulier.selectAllParticulier(filtre);
		Object[][] matrice = new Object[lesParticuliers.size()][11];
		int i = 0;
		for (Particulier unParticulier : lesParticuliers) {
			matrice[i][0] = unParticulier.getIduser();
			matrice[i][1] = unParticulier.getNom();
			matrice[i][2] = unParticulier.getPrenom();
			matrice[i][3] = unParticulier.getEmail();
			matrice[i][4] = unParticulier.getDatemdp();
			matrice[i][5] = unParticulier.getRoles();
			matrice[i][6] = unParticulier.getTypeclient();
			matrice[i][7] = unParticulier.getAdresse();
			matrice[i][8] = unParticulier.getVille();
			matrice[i][9] = unParticulier.getCp();
			matrice[i][10] = unParticulier.getTelephone();
			i++;
		}
		return matrice;
	}

	public void viderChamps() {
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtAdresse.setText("");
		this.txtVille.setText("");
		this.txtCp.setText("");
		this.txtTelephone.setText("");
		btEnregistrer.setText("Enregistrer");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource()== this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
            String nom = this.txtNom.getText();
            String adresse = this.txtAdresse.getText();
            String ville = this.txtVille.getText();
            String cp = this.txtCp.getText();
            int telephone =  Integer.parseInt(this.txtTelephone.getText());
            String prenom = this.txtPrenom.getText();


            // instancier un Particulier
            Particulier unParticulier = new Particulier(email, mdp, nom, adresse, ville, cp, telephone, prenom) ;
            // on en l'enregistre dans la base de données
            C_Particulier.insertParticulier(unParticulier);

			// ajout du client dans le tableau
			unParticulier = C_Particulier.selectWhereParticulier(email);
			Object ligne[] = { unParticulier.getIduser(), unParticulier.getNom(), unParticulier.getPrenom(),
				unParticulier.getEmail(), unParticulier.getDatemdp(), unParticulier.getRoles(), unParticulier.getTypeclient(), unParticulier.getAdresse(),
				unParticulier.getVille(), unParticulier.getCp(), unParticulier.getTelephone() };
			this.unTableau.insertLigne(ligne);
            		
			JOptionPane.showMessageDialog(this, "Particulier inséré avec succés !");
			this.viderChamps();
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
            String nom = this.txtNom.getText();
            String prenom = this.txtPrenom.getText();
			String adresse = this.txtAdresse.getText();
			String ville = this.txtVille.getText();
			String cp = this.txtCp.getText();
			int telephone = Integer.parseInt(txtTelephone.getText());
			int numLigne = this.tableParticuliers.getSelectedRow(); 
			
			// instancier un client
			Particulier unParticulier = new Particulier(email, mdp, nom, adresse, ville, cp, telephone, prenom);
			// on le modifie dans la base de données
			C_Particulier.updateParticulier(unParticulier);

			// ajout de l'Particulier dans le tableau
			unParticulier = C_Particulier.selectWhereParticulier(email);
			Object ligne[] = { unParticulier.getIduser(), unParticulier.getNom(), unParticulier.getPrenom(),
				unParticulier.getEmail(), unParticulier.getDatemdp(), unParticulier.getRoles(),
				unParticulier.getTypeclient(), unParticulier.getAdresse(), unParticulier.getVille(),
				unParticulier.getCp(), unParticulier.getTelephone(), };
			this.unTableau.updateLigne(numLigne, ligne);

			JOptionPane.showMessageDialog(this, "Particulier modifié avec succés !");
			this.viderChamps();
		}else if (e.getSource()==this.btFiltrer){
			String filtre = this.txtFiltre.getText();
			Object donnees[][] = this.getDonnees(filtre);
			//actualisation de l'affichage 
			this.unTableau.setDonnees(donnees);
		}

	}

}
