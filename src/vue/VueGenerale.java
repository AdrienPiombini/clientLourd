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
   private JButton btUtilisateurs = new JButton("Utilisateurs");
   private JButton btInterventions = new JButton("Interventions");
   private JButton btCommandes = new JButton("Commandes");
   private JButton btStatistiques = new JButton("Statistiques");
   private JButton btProduits = new JButton("Produits");
   private JButton btQuitter = new JButton("Quitter");
   private String[] typeUsers = {"Utilisateurs","admin", "technicien", "professionnel", "particulier"}; 
   private JComboBox<String> choixUsers = new JComboBox<String>(typeUsers);


   // listes des panel
   private PanelAdmin unPanelAdmin = new PanelAdmin();
   private PanelTechnicien unPanelTechnicien = new PanelTechnicien();
   private PanelParticulier unPanelParticulier = new PanelParticulier();
   private PanelProfessionnel unPanelProfessionnel = new PanelProfessionnel();
   private PanelIntervention unPanelIntervention = new PanelIntervention();
   private PanelCommande unPanelCommande = new PanelCommande();
   private PanelProduit unPanelProduit= new PanelProduit();
   private PanelProfil unPanelProfil= new PanelProfil();
   private PanelStatistique unPanelStatistique = new PanelStatistique();
   
    public VueGenerale(){
        this.setTitle("Gestion du site Filelec");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setBounds(100,100,1400,900);
        //Centrer la fenêtre par rapport à l'écran 
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color (224, 224, 224));
        this.setLayout(null);

        this.panelMenu.setBounds(0,0,800,30);
        this.panelMenu.setBackground(new Color(224, 224, 224));
        this.panelMenu.setLayout(new GridLayout(1,6));
        this.panelMenu.add(this.btProfil);
        this.panelMenu.add(this.choixUsers);
        this.panelMenu.add(this.btInterventions);
        this.panelMenu.add(this.btCommandes);
        this.panelMenu.add(this.btStatistiques);
        this.panelMenu.add(this.btProduits);
        this.panelMenu.add(this.btQuitter);
        
        
        this.add(this.panelMenu);

        // rendres les boutons écoutables
		this.btProfil.addActionListener(this);
		this.btUtilisateurs.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btCommandes.addActionListener(this);
        this.btStatistiques.addActionListener(this);
		this.btProduits.addActionListener(this);
		this.btQuitter.addActionListener(this);
        this.choixUsers.addActionListener(this);

		// ajout des Panels dans la fenetre
		this.add(this.unPanelAdmin);
		this.add(this.unPanelTechnicien);
		this.add(this.unPanelParticulier);
		this.add(this.unPanelProfessionnel);
        this.add(this.unPanelIntervention);
        this.add(this.unPanelCommande);
        this.add(this.unPanelProduit);
        this.add(this.unPanelProfil);
        this.add(this.unPanelStatistique);



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
        }else if (e.getSource()==this.choixUsers){
            if (this.choixUsers.getSelectedItem()=="admin"){
                this.afficherPanel(1);
            }else if(this.choixUsers.getSelectedItem()=="technicien"){
                this.afficherPanel(2);
            }else if(this.choixUsers.getSelectedItem()=="particulier"){
                this.afficherPanel(3);
            }else if(this.choixUsers.getSelectedItem()=="professionnel"){
                this.afficherPanel(4);
            }
        }else if (e.getSource()==this.btInterventions){
            this.afficherPanel(5);
        }else if(e.getSource()==this.btCommandes){
            this.afficherPanel(6);
        }else if(e.getSource()==this.btProduits){
            this.afficherPanel(7);
        }else if(e.getSource()==this.btProfil){
            this.afficherPanel(8);
        }else if(e.getSource()==this.btStatistiques){
            this.afficherPanel(9);
        }

    }

    public void afficherPanel(int numero){
        this.unPanelAdmin.setVisible(false);
        this.unPanelTechnicien.setVisible(false);
        this.unPanelParticulier.setVisible(false);
        this.unPanelProfessionnel.setVisible(false);
        this.unPanelIntervention.setVisible(false);
        this.unPanelCommande.setVisible(false);
        this.unPanelProduit.setVisible(false);
        this.unPanelProfil.setVisible(false);
        this.unPanelStatistique.setVisible(false);

		switch (numero) {
		    case 1: this.unPanelAdmin.setVisible(true); break;
		    case 2: this.unPanelTechnicien.setVisible(true); break;
            case 3: this.unPanelParticulier.setVisible(true); break;
            case 4: this.unPanelProfessionnel.setVisible(true); break;
            case 5: this.unPanelIntervention.setVisible(true); break;
            case 6: this.unPanelCommande.setVisible(true); break;
            case 7: this.unPanelProduit.setVisible(true); break;
            case 8: this.unPanelProfil.setVisible(true); break;
            case 9 : this.unPanelStatistique.setVisible(true); break;

		}
    }



} 