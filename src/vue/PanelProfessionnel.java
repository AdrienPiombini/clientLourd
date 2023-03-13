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

import controleur.C_Professionnel;
import controleur.Professionnel;
import controleur.Tableau;

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
	private JTable tableProfessionnels;
	private Tableau unTableau;

	



	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelProfessionnel() {
		super();
		this.titre.setText("_____Gestion des Professionnels_______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(224, 224, 224));
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

		//construction de la JTable 
		String entetes[] = { "ID User", "Nom", "numerSiret", "Email", "DateMdp", "Roles", "typeclient", "adresse", "ville", "cp", "telephone" };
		Object[][] donnees = this.getDonnees();
		this.unTableau = new Tableau(donnees, entetes);
		this.tableProfessionnels = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableProfessionnels);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);

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

			// ajout du client dans le tableau
			unProfessionnel = C_Professionnel.selectWhereProfessionnel(email);
			Object ligne[] = { unProfessionnel.getIduser(), unProfessionnel.getNom(), unProfessionnel.getNumeroSiret(),
				unProfessionnel.getDatemdp(), unProfessionnel.getMdp(),
				unProfessionnel.getEmail(), unProfessionnel.getRoles(), unProfessionnel.getTypeclient(),
				unProfessionnel.getAdresse(), unProfessionnel.getVille(), unProfessionnel.getCp(), unProfessionnel.getTelephone() };
			this.unTableau.insertLigne(ligne);
            		
			JOptionPane.showMessageDialog(this, "Professionnel inséré avec succés !");
			this.viderChamps();
		}

	}

	public Object[][] getDonnees() {
		ArrayList<Professionnel> lesProfessionnels = C_Professionnel.selectAllProfessionnels();
		Object[][] matrice = new Object[lesProfessionnels.size()][11];
		int i = 0;
		for (Professionnel unProfessionnel : lesProfessionnels) {
			matrice[i][0] = unProfessionnel.getIduser();
			matrice[i][1] = unProfessionnel.getNom();
			matrice[i][2] = unProfessionnel.getNumeroSiret();
			matrice[i][3] = unProfessionnel.getEmail();
			matrice[i][4] = unProfessionnel.getDatemdp();
			matrice[i][5] = unProfessionnel.getRoles();
			matrice[i][6] = unProfessionnel.getTypeclient();
			matrice[i][7] = unProfessionnel.getAdresse();
			matrice[i][8] = unProfessionnel.getVille();
			matrice[i][9] = unProfessionnel.getCp();
			matrice[i][10] = unProfessionnel.getTelephone();
			i++;
		}
		return matrice;
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
