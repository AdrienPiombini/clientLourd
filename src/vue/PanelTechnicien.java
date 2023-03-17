package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



import controleur.C_Technicien;
import controleur.Tableau;
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

	private JTable tableTechniciens;
	private Tableau unTableau;

	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");

	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	public PanelTechnicien() {
		super();
		this.titre.setText("_____Gestion des Techniciens_______");

		// Construction du Panel Form
		this.panelForm.setBounds(20, 40, 300, 250);
		this.panelForm.setBackground(new Color(224, 224, 224));
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

		//construction de la JTable 
		String entetes[] = { "ID User", "Nom", "Prenom", "Email", "DateMdp", "Roles", "Diplome", "dateEmb", "dateDept" };
		Object[][] donnees = this.getDonnees("");
		this.unTableau = new Tableau(donnees, entetes);
		this.tableTechniciens = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableTechniciens);
		uneScroll.setBounds(360, 80, 460, 250);

		this.add(uneScroll);

		//implémentation de la suppression / modification d'une ligne
		this.tableTechniciens.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = tableTechniciens.getSelectedRow();
				String email = tableTechniciens.getValueAt(numLigne,3).toString();
				if(e.getClickCount() >= 2){
					int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cet user ?", "Suppression user", JOptionPane.YES_NO_OPTION);
					if(retour == 0){
						C_Technicien.deleteTechnicien(email);
						unTableau.deleteLigne(numLigne);
						JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
					}
				}else if(e.getClickCount()== 1){
					//on remplie les champs de modification 
					Technicien unTechnicien = C_Technicien.selectWhereTechnicien(email);
					txtEmail.setText(unTechnicien.getEmail());
					txtMdp.setText(unTechnicien.getMdp());
					txtPrenom.setText(unTechnicien.getPrenom());
					txtNom.setText(unTechnicien.getNom());
					txtDiplome.setText(unTechnicien.getDiplome());
					txtDateEmb.setText(unTechnicien.getDateEmb());
					txtDateDept.setText(unTechnicien.getDateDept());

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
		ArrayList<Technicien> lesTechniciens = C_Technicien.selectAllTechniciens(filtre);
		Object[][] matrice = new Object[lesTechniciens.size()][9];
		int i = 0;
		for (Technicien unTechnicien : lesTechniciens) {
			matrice[i][0] = unTechnicien.getIduser();
			matrice[i][1] = unTechnicien.getNom();
			matrice[i][2] = unTechnicien.getPrenom();
			matrice[i][3] = unTechnicien.getEmail();
			matrice[i][4] = unTechnicien.getDatemdp();
			matrice[i][5] = unTechnicien.getRoles();
			matrice[i][6] = unTechnicien.getDiplome();
			matrice[i][7] = unTechnicien.getDateEmb();
			matrice[i][8] = unTechnicien.getDateDept();

			i++;
		}
		return matrice;
	}
	
	public void viderChamps() {
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtDiplome.setText("");
		this.txtDateEmb.setText("");
		this.txtDateDept.setText("");
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
				// ajout du client dans le tableau
				unTechnicien = C_Technicien.selectWhereTechnicien(email);
				Object ligne[] = { unTechnicien.getIduser(), unTechnicien.getNom(), unTechnicien.getPrenom(),
					unTechnicien.getDatemdp(),unTechnicien.getEmail(), unTechnicien.getRoles(),
					unTechnicien.getDiplome(), unTechnicien.getDateEmb(), unTechnicien.getDateDept() };
				this.unTableau.insertLigne(ligne);
				JOptionPane.showMessageDialog(this, "Technicien inséré avec succés !");
				this.viderChamps();
            }			
			
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
            String nom = this.txtNom.getText();
            String prenom = this.txtPrenom.getText();
			String diplome = this.txtDiplome.getText();
            String dateEmb = this.txtDateEmb.getText();
            String dateDept = this.txtDateDept.getText();
			int numLigne = this.tableTechniciens.getSelectedRow(); 
			
			// instancier un client
			Technicien unTechnicien = new Technicien(email, mdp, nom, prenom, diplome, dateEmb, dateDept);
			// on le modifie dans la base de données
			C_Technicien.updateTechnicien(unTechnicien);
						//ID User", "Nom", "Prenom", "Email", "DateMdp", "Roles", "Diplome", "dateEmb", "dateDept"
			// ajout de l'Technicien dans le tableau
			unTechnicien = C_Technicien.selectWhereTechnicien(email);
			Object ligne[] = { unTechnicien.getIduser(), unTechnicien.getNom(), unTechnicien.getPrenom(),
				unTechnicien.getEmail(), unTechnicien.getDatemdp(),unTechnicien.getRoles(),
				unTechnicien.getDiplome(),unTechnicien.getDateEmb(),unTechnicien.getDateDept()};
			this.unTableau.updateLigne(numLigne, ligne);

			JOptionPane.showMessageDialog(this, "Technicien modifié avec succés !");
			this.viderChamps();
		}else if (e.getSource()==this.btFiltrer){
			String filtre = this.txtFiltre.getText();
			Object donnees[][] = this.getDonnees(filtre);
			//actualisation de l'affichage 
			this.unTableau.setDonnees(donnees);
		}

	}
}
