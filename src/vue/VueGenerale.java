package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueGenerale extends JFrame {

   private JPanel panelMenu = new JPanel();
   private JButton btProfil = new JButton("Profils");
   private JButton btUtilisateurs = new JButton("Utilisateurs");
   private JButton btInterventions = new JButton("Interventions");
   private JButton btCommandes = new JButton("Commandes");
   private JButton btStatistiques = new JButton("Statistiques");
   private JButton btProduits = new JButton("Produits");
   private JButton btQuitter = new JButton("Quitter");

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
        this.panelMenu.add(this.btUtilisateurs);
        this.panelMenu.add(this.btInterventions);
        this.panelMenu.add(this.btCommandes);
        this.panelMenu.add(this.btStatistiques);
        this.panelMenu.add(this.btProduits);
        this.panelMenu.add(this.btQuitter);

        this.add(this.panelMenu);

        this.setVisible(false);
    }

} 