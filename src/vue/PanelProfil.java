package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.C_Admin;
import controleur.Admin;

public class PanelProfil extends PanelPrincipal implements ActionListener {
	private JPanel panelForm = new JPanel();

	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtEmail = new JTextField();        
	private JTextField txtRole = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtDateMdp = new JTextField();

	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	// textArea : pour les infos du Admin
	private JTextArea txtInfos = new JTextArea();

	private JButton btModifier = new JButton("Modifier");
	private Admin unAdmin;

	public PanelProfil() {
		super();
		this.titre.setText("_______ MON PROFIL _______");
		// construction du Panel Form
		this.panelForm.setBounds(350, 50, 300, 340);
		this.panelForm.setBackground(new Color(224, 224, 224));
		this.panelForm.setLayout(new GridLayout(7, 2));
		this.panelForm.add(new JLabel("Nom : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prénom : "));
		this.panelForm.add(this.txtPrenom);
		this.panelForm.add(new JLabel("Email : "));
		this.panelForm.add(this.txtEmail);
        this.panelForm.add(new JLabel("Roles: "));
		this.panelForm.add(this.txtRole);
		this.panelForm.add(new JLabel("MDP : "));
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		// ajout du panelform à au panelClients
		this.add(this.panelForm);
		this.panelForm.setVisible(false);

		// installation du TextArea
		this.txtInfos.setBounds(50, 80, 250, 280 );
		this.txtInfos.setBackground(new Color(224, 224, 224));

		this.unAdmin = VueConnexion.getAdmin();
		this.txtInfos.setText("___________ INFOS PERSONNELLES _________\n\n" 
                + "NOM: " + unAdmin.getNom()
				+ "\n\n" + "PRENOM : " + unAdmin.getPrenom()
                + "\n\n" + "EMAIL : " + unAdmin.getEmail()
                + "\n\n" + "dateMdp: " + unAdmin.getDatemdp()
                + "\n\n" + "Role: " + unAdmin.getRoles()
                + "\n");

		this.add(this.txtInfos);

		// remplir les infos dans le formulaire
		this.txtNom.setText(this.unAdmin.getNom());
		this.txtPrenom.setText(this.unAdmin.getPrenom());
		this.txtEmail.setText(this.unAdmin.getEmail());
		this.txtMdp.setText(this.unAdmin.getMdp());
		this.txtRole.setText(this.unAdmin.getRoles());

		this.btModifier.setBounds(80, 360, 100, 20);
		this.add(this.btModifier);

		// rendre le boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btModifier.addActionListener(this);
	}

	public void viderChamps() {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btModifier) {
			if (this.panelForm.isVisible()) {
				this.panelForm.setVisible(false);
			} else {
				this.panelForm.setVisible(true);
			}
		} else if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource() == this.btEnregistrer) {
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String role = this.txtRole.getText();
			String email = this.txtEmail.getText();
			String mdp = new String(this.txtMdp.getPassword());
			String datemdp = this.txtDateMdp.getText();
			// instancier un Admin
			unAdmin = new Admin(unAdmin.getIduser(),email, mdp, nom, role, datemdp, prenom);
			// on l'enregistre dans la base de données
			C_Admin.updateAdmin(unAdmin);

			JOptionPane.showMessageDialog(this, " Modification de votre profil faite avec succès !");

			this.txtInfos.setText("___________ INFOS PERSONNELLES _________\n\n" + "NOM: " + unAdmin.getNom()
				+ "\n\n" + "PRENOM  " + unAdmin.getPrenom()
				+ "\n\n" + "EMAIL " + unAdmin.getEmail()
				+ "\n\n" + "dateMdp: " + unAdmin.getDatemdp()
                + "\n\n" + "ROLES : "+ unAdmin.getRoles() + "\n");
		}

	}
}