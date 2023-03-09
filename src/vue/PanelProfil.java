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
	private Admin unA;

	public PanelProfil() {
		super();
		this.titre.setText("_______ MON PROFIL _______");
		// construction du Panel Form
		this.panelForm.setBounds(350, 50, 300, 240);
		this.panelForm.setBackground(new Color(234, 176, 69));
		this.panelForm.setLayout(new GridLayout(7, 2));
		this.panelForm.add(new JLabel("Nom Admin : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prénom Admin : "));
		this.panelForm.add(this.txtPrenom);
		this.panelForm.add(new JLabel("Email Admin : "));
		this.panelForm.add(this.txtEmail);
        this.panelForm.add(new JLabel("Roles: "));
		this.panelForm.add(this.txtRole);
		this.panelForm.add(new JLabel("MDP Admin : "));
		this.panelForm.add(this.txtMdp);
        this.panelForm.add(new JLabel("DATE MDP: "));
		this.panelForm.add(this.txtDateMdp)
        ;
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		// ajout du panelform à au panelClients
		this.add(this.panelForm);
		this.panelForm.setVisible(false);

		// installation du TextArea
		this.txtInfos.setBounds(50, 80, 200, 180);
		this.txtInfos.setBackground(new Color(234, 176, 69));

		this.unA = VueConnexion.getAdminConnecte();
		this.txtInfos.setText("___________ INFOS PERSONNELLES _________\n\n" 
                + "NOM: " + unA.getNom()
				+ "\n\n" + "PRENOM : " + unA.getPrenom()
                + "\n\n" + "EMAIL : " + unA.getEmail()
				+ "\n\n" + "MDP: " + unA.getMdp()
                + "\n\n" + "dateMdp: " + unA.getDatemdp()
                + "\n\n" + "Role: " + unA.getRoles()
                + "\n");

		this.add(this.txtInfos);

		// remplir les infos dans le formualaire
		this.txtNom.setText(this.unA.getNom());
		this.txtPrenom.setText(this.unA.getPrenom());
		this.txtEmail.setText(this.unA.getEmail());
		this.txtEmail.setText(this.unA.getRoles());
		this.txtMdp.setText(this.unA.getMdp());
		this.txtEmail.setText(this.unA.getDatemdp());

		this.btModifier.setBounds(80, 260, 100, 20);
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
			this.unA = new Admin(unA.getIduser(),email, mdp, nom, role, datemdp, prenom);
			// on l'enregistre dans la base de données
			C_Admin.updateAdmin(this.unA);

			JOptionPane.showMessageDialog(this, " Modification de votre profil faite avec succès !");

			this.txtInfos.setText("___________ INFOS PERSONNELLES _________\n\n" + "NOM: " + unA.getNom()
				+ "\n\n" + "PRENOM  " + unA.getPrenom() + "\n\n" + "DATE MDP : "+ unA.getDatemdp()
                + "\n\n" + "ROLES : "+ unA.getRoles()
                + "\n\n" + "EMAIL " + unA.getEmail() + "\n");
		}

	}
}