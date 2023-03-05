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
import javax.swing.JTextField;

import controleur.C_Technicien;
import controleur.Technicien;

public class PanelTechnicien extends PanelPrincipal implements ActionListener {

	private JPanel panelForm = new JPanel();
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtDiplome = new JTextField();
	private JTextField txtDateEmb = new JTextField();
	private JTextField txtDateDept = new JTextField();


	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelTechnicien() {
		super();
		this.titre.setText("_____Gestion des Techniciens_______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(234, 176, 69));
		this.panelForm.setLayout(new GridLayout(8, 2));
		this.panelForm.add(new JLabel("Email Technicien : "));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Mot de passe Technicien : "));
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(new JLabel("Nom  : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prenom : "));
		this.panelForm.add(this.txtPrenom);
        this.panelForm.add(new JLabel("Diplôme : "));
		this.panelForm.add(this.txtDiplome);
        this.panelForm.add(new JLabel("Date Embauche : "));
		this.panelForm.add(this.txtDateEmb);
        this.panelForm.add(new JLabel("Date Depart : "));
		this.panelForm.add(this.txtDateDept);
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
		this.txtPrenom.setText("");
		this.txtDiplome.setText("");
		this.txtDateEmb.setText("");
		this.txtDateDept.setText("");

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
            String diplome = this.txtDiplome.getText();
            String dateEmb = this.txtDateEmb.getText();
            String dateDept = this.txtDateDept.getText();

            if (dateDept.equals("")){
                // instancier un technicien
			    Technicien unTechnicien = new Technicien(email, mdp,nom, prenom, diplome, dateEmb);
                // on en l'enregistre dans la base de données
			    C_Technicien.insertTechnicienCDI(unTechnicien);
            }else{
                // instancier un technicien
			    Technicien unTechnicien = new Technicien(email, mdp,nom, prenom, diplome, dateEmb, dateDept);
                // on en l'enregistre dans la base de données
			    C_Technicien.insertTechnicien(unTechnicien);
            }			
			JOptionPane.showMessageDialog(this, "Technicien inséré avec succés !");
			this.viderChamps();
		}

	}
}