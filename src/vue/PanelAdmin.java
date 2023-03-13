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
		Object[][] donnees = this.getDonnees();
		this.unTableau = new Tableau(donnees, entetes);
		this.tableAdmins = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableAdmins);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);

		// rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	public Object[][] getDonnees() {
		ArrayList<Admin> lesAdmins = C_Admin.selectAllAdmin();
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource() == this.btEnregistrer) {
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
				unAdmin.getDatemdp(), unAdmin.getMdp(),
				unAdmin.getEmail(), unAdmin.getRoles() };
			this.unTableau.insertLigne(ligne);

			JOptionPane.showMessageDialog(this, "Admin inséré avec succés !");
			this.viderChamps();
		}

	}
}
