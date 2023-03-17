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

import controleur.C_Admin;
import controleur.Tableau;
import controleur.Admin;

public class PanelAdmin extends PanelPrincipal implements ActionListener {

	private JPanel panelForm = new JPanel();

	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();

	private JTable tableAdmins;
	private Tableau unTableau;

	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");

	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelAdmin() {
		super();
		this.titre.setText("_____Gestion DES ADMIN_______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(224, 224, 224));
		this.panelForm.setLayout(new GridLayout(5, 2));
		this.panelForm.add(new JLabel("Email Admin : "));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Mot de passe Admin : "));
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(new JLabel("Nom  : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prenom : "));
		this.panelForm.add(this.txtPrenom);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		// ajout du panelform au panel Clients
		this.add(this.panelForm);

		//construction de la JTable 
		String entetes[] = { "ID User", "Nom", "Prenom", "Email", "DateMdp", "Roles" };
		Object[][] donnees = this.getDonnees("");
		this.unTableau = new Tableau(donnees, entetes);
		this.tableAdmins = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableAdmins);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);

		//implémentation de la suppression / modification d'une ligne
		this.tableAdmins.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = tableAdmins.getSelectedRow();
				String email = tableAdmins.getValueAt(numLigne,3).toString();
				if(e.getClickCount() >= 2){
					int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cet user ?", "Suppression user", JOptionPane.YES_NO_OPTION);
					if(retour == 0){
						C_Admin.deleteAdmin(email);
						unTableau.deleteLigne(numLigne);
						JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
					}
				}else if(e.getClickCount()== 1){
					//on remplie les champs de modification 
					Admin unAdmin = C_Admin.selectWhereAdmin(email);
					txtEmail.setText(unAdmin.getEmail());
					txtMdp.setText(unAdmin.getMdp());
					txtPrenom.setText(unAdmin.getPrenom());
					txtNom.setText(unAdmin.getNom());
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
		ArrayList<Admin> lesAdmins = C_Admin.selectAllAdmin(filtre);
		Object[][] matrice = new Object[lesAdmins.size()][6];
		int i = 0;
		for (Admin unAdmin : lesAdmins) {
			matrice[i][0] = unAdmin.getIduser();
			matrice[i][1] = unAdmin.getNom();
			matrice[i][2] = unAdmin.getPrenom();
			matrice[i][3] = unAdmin.getEmail();
			matrice[i][4] = unAdmin.getDatemdp();
			matrice[i][5] = unAdmin.getRoles();
			i++;
		}
		return matrice;
	}

	public void viderChamps() {
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		btEnregistrer.setText("Enregistrer");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
            String nom = this.txtNom.getText();
            String prenom = this.txtPrenom.getText();
			
			// instancier un client
			Admin unAdmin = new Admin(email, mdp,nom, prenom);
			// on en l'enregistre dans la base de données
			C_Admin.insertAdmin(unAdmin);

			// ajout de l'admin dans le tableau
			unAdmin = C_Admin.selectWhereAdmin(email);
			Object ligne[] = { unAdmin.getIduser(), unAdmin.getNom(), unAdmin.getPrenom(),
				unAdmin.getEmail(), unAdmin.getDatemdp(),unAdmin.getRoles() };
			this.unTableau.insertLigne(ligne);

			JOptionPane.showMessageDialog(this, "Admin inséré avec succés !");
			this.viderChamps();
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
            String nom = this.txtNom.getText();
            String prenom = this.txtPrenom.getText();
			int numLigne = this.tableAdmins.getSelectedRow(); 
			
			// instancier un client
			Admin unAdmin = new Admin(email, mdp, nom, prenom);
			// on le modifie dans la base de données
			C_Admin.updateAdmin(unAdmin);

			// ajout de l'admin dans le tableau
			unAdmin = C_Admin.selectWhereAdmin(email);
			Object ligne[] = { unAdmin.getIduser(), unAdmin.getNom(), unAdmin.getPrenom(),
				unAdmin.getEmail(), unAdmin.getDatemdp(),unAdmin.getRoles() };
			this.unTableau.updateLigne(numLigne, ligne);

			JOptionPane.showMessageDialog(this, "Admin modifié avec succés !");
			this.viderChamps();
		}else if (e.getSource()==this.btFiltrer){
			String filtre = this.txtFiltre.getText();
			Object donnees[][] = this.getDonnees(filtre);
			//actualisation de l'affichage 
			this.unTableau.setDonnees(donnees);
		}

	}
}
