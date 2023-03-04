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

import controleur.C_Professionnel;
import controleur.Professionnel;

public class PanelProfessionnel extends PanelPrincipal implements ActionListener {

	private JPanel panelForm = new JPanel();

	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JTextField txtNom = new JTextField();
	private JTextField txtNumeroSiret = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtCp = new JTextField();
	private JTextField txtTelephone = new JTextField();



	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelProfessionnel() {
		super();
		this.titre.setText("_____Gestion des Professionnels_______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(234, 176, 69));
		this.panelForm.setLayout(new GridLayout(9, 2));
		this.panelForm.add(new JLabel("Email : "));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Mot de passe : "));
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(new JLabel("Nom  : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Numero de Siret : "));
		this.panelForm.add(this.txtNumeroSiret);
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

		// rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource() == this.btEnregistrer) {
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
            String nom = this.txtNom.getText();
            String adresse = this.txtAdresse.getText();
            String ville = this.txtVille.getText();
            String cp = this.txtCp.getText();
            int telephone =  Integer.parseInt(this.txtTelephone.getText());
            int numeroSiret = Integer.parseInt(this.txtNumeroSiret.getText());


            // instancier un Professionnel
            Professionnel unProfessionnel = new Professionnel(email, mdp, nom, adresse, ville, cp, telephone, numeroSiret) ;
            // on en l'enregistre dans la base de données
            C_Professionnel.insertProfessionnel(unProfessionnel);
            		
			JOptionPane.showMessageDialog(this, "Professionnel inséré avec succés !");
			this.viderChamps();
		}

	}

    public void viderChamps() {
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtNom.setText("");
		this.txtNumeroSiret.setText("");
		this.txtAdresse.setText("");
		this.txtVille.setText("");
		this.txtCp.setText("");
		this.txtTelephone.setText("");
	}

}
