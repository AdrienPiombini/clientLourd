package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Filelec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueGenerale extends JFrame implements ActionListener {

   private JPanel panelMenu = new JPanel();
   private JButton btProfil = new JButton("Profils");
   //private JButton btUtilisateurs = new JButton("Utilisateurs");
   private JButton btInterventions = new JButton("Interventions");
   private JButton btCommandes = new JButton("Commandes");
   private JButton btStatistiques = new JButton("Statistiques");
   private JButton btProduits = new JButton("Produits");
   private JButton btQuitter = new JButton("Quitter");
   //private JComboBox<JButton> choixUsers = new JComboBox<JButton>();

   // Création des boutons
JButton btUtilisateurs = new JButton("Utilisateurs");
JButton btClients = new JButton("Clients");
JButton btFournisseurs = new JButton("Fournisseurs");

// Ajout des boutons à la JComboBox
JComboBox<JButton> choixUsers = new JComboBox<JButton>();
choixUsers.addItem(btUtilisateurs);
choixUsers.addItem(btClients);
choixUsers.addItem(btFournisseurs);


   // listes des panel
   private PanelUsers unPanelUsers = new PanelUsers();

    public VueGenerale(){
        this.setTitle("Gestion du site Filelec");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(100,100,900,500);
        this.getContentPane().setBackground(new Color (234, 176, 69));
        this.setLayout(null);

        this.panelMenu.setBounds(50,20,800,30);
        this.panelMenu.setBackground(new Color(234,176,69));
        this.panelMenu.setLayout(new GridLayout(1,6));
        this.panelMenu.add(this.btProfil);
        this.panelMenu.add(this.choixUsers);
        this.panelMenu.add(this.btInterventions);
        this.panelMenu.add(this.btCommandes);
        this.panelMenu.add(this.btStatistiques);
        this.panelMenu.add(this.btProduits);
        this.panelMenu.add(this.btQuitter);
        
        this.add(this.panelMenu);

        this.choixUsers.addItem(this.btUtilisateurs); 


        // rendres les boutons écoutables
		this.btProfil.addActionListener(this);
		this.btUtilisateurs.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btCommandes.addActionListener(this);
        this.btStatistiques.addActionListener(this);
		this.btProduits.addActionListener(this);
		this.btQuitter.addActionListener(this);

		// ajout des Panels dans la fenetre
		this.add(this.unPanelUsers);

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btQuitter) {
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ? ",
					"Quitter l'application", JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				Filelec2.rendreVisibleVueGenerale(false);
				Filelec2.rendreVisibleVueConnexion(true);
			}
        }else if (e.getSource()==this.btUtilisateurs){
            this.afficherPanel(1);
        }
    }

    public void afficherPanel(int numero){
        this.unPanelUsers.setVisible(false);
		switch (numero) {
		case 1:
			this.unPanelUsers.setVisible(true); break;
		}
    }



} 