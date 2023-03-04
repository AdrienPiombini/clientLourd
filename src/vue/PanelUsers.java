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

import controleur.C_Users;
import controleur.Users;

public class PanelUsers extends PanelPrincipal implements ActionListener {

	private JPanel panelForm = new JPanel();

	private JTextField txtEmail = new JTextField();
	private JTextField txtMdp = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtRoles = new JTextField();

	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelUsers() {
		super();
		this.titre.setText("_____Gestion DES CLIENTS______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(234, 176, 69));
		this.panelForm.setLayout(new GridLayout(5, 2));
		this.panelForm.add(new JLabel("Email Client : "));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Mot de passe Client : "));
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(new JLabel("Nom  : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Roles : "));
		this.panelForm.add(this.txtRoles);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);

		// ajout du panelform au panel Clients
		this.add(this.panelForm);

		// rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	public void viderChamps() {
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtNom.setText("");
		this.txtRoles.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource() == this.btEnregistrer) {
			String email = this.txtEmail.getText();
			String mdp = this.txtMdp.getText();
            String nom = this.txtNom.getText();
            String roles = this.txtRoles.getText();
			
			
			// instancier un client
			Users unUser = new Users( email, mdp,nom, roles);
			// on en l'enregistre dans la base de données
			C_Users.insertUser(unUser);
			JOptionPane.showMessageDialog(this, "Client inséré avec succés !");
			this.viderChamps();
		}

	}
}
