package vue;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.C_Commande;
import controleur.Commande;
import controleur.Tableau;

public class PanelStatistique extends PanelPrincipal {

    private JTable tableauStatCommande;
    private Tableau unTableauCommande;
    private  int totalCommande, commandeAnnulee, commandeArchivee, commandeValidee, commandeEnCours = 0; 
    
    public PanelStatistique(){
        super();
		this.titre.setText("_____STATISTIQUE DE FILELEC _____");

        	//construction de la JTable 
            String entetes[] = { "Nb total commande", "Nb annulée", "Nb Archivée", "Nb Validée", "Nb en cours" };
            Object[][] donnees = this.getDonnees();
            this.unTableauCommande = new Tableau(donnees, entetes);
            this.tableauStatCommande = new JTable(this.unTableauCommande);
            JScrollPane uneScroll = new JScrollPane(this.tableauStatCommande);
            uneScroll.setBounds(360, 80, 460, 40);
            this.add(uneScroll);
    }

    public Object[][] getDonnees() {
		ArrayList<Commande> lesCommandes = C_Commande.selectAllCommandes("");
        for(Commande uneCommande : lesCommandes){
            switch (uneCommande.getStatut()){
                case ("annulée"): commandeAnnulee ++; break;
                case ("archivée"): commandeArchivee ++; break;
                case ("validée"): commandeValidee ++; break;
                case ("en cours"): commandeEnCours ++; break;
            }
            totalCommande ++;
        }
		Object[][] matrice = new Object[1][5];
			matrice[0][0] = totalCommande;
			matrice[0][1] = commandeAnnulee;
			matrice[0][2] = commandeArchivee;
			matrice[0][3] = commandeValidee;
			matrice[0][4] = commandeEnCours;
		return matrice;
	}
}
