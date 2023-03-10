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



	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelParticulier() {
		super();
		this.titre.setText("_____Gestion des Particuliers_______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(234, 176, 69));
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
		Object[][] donnees = this.getDonnees();
		this.unTableau = new Tableau(donnees, entetes);
		this.tableParticuliers = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableParticuliers);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);

		// rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	public Object[][] getDonnees() {
		ArrayList<Particulier> lesParticuliers = C_Particulier.selectAllParticulier();
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
            String prenom = this.txtPrenom.getText();


            // instancier un Particulier
            Particulier unParticulier = new Particulier(email, mdp, nom, adresse, ville, cp, telephone, prenom) ;
            // on en l'enregistre dans la base de données
            C_Particulier.insertParticulier(unParticulier);
            		
			JOptionPane.showMessageDialog(this, "Particulier inséré avec succés !");
			this.viderChamps();
		}

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
	}

}
