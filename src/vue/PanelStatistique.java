package vue;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.C_Commande;
import controleur.C_Intervention;
import controleur.Commande;
import controleur.Intervention;
import controleur.Tableau;

public class PanelStatistique extends PanelPrincipal {

    private JTable tableauStatCommande, tableauStatIntervention ;
    public static Tableau unTableauCommande, unTableauInvervention;
    private  static int totalCommande, commandeAnnulee, commandeArchivee, commandeValidee, commandeEnCours = 0; 
    private static int totalIntervention, interAnnulee, interArchivee, interValide, interEnAttente = 0; 
    public static Object [] ligneStatCommande = {totalCommande, commandeAnnulee, commandeArchivee, commandeValidee, commandeEnCours };
    public static Object [] ligneStatIntervention = { totalIntervention, interAnnulee, interArchivee, interValide, interEnAttente};

    
    public  PanelStatistique(){
        super();
		this.titre.setText("_____STATISTIQUE DE FILELEC _____");

            this.add(new JLabel("Commande")).setBounds(400, 50, 100, 20);
        	//construction de la JTable 
            String entetesCommande[] = { "Nb total commande", "Nb annulée", "Nb Archivée", "Nb Validée", "Nb en cours" };
            Object[][] donneesCommande = PanelStatistique.getDonneesCommande();
            PanelStatistique.unTableauCommande = new Tableau(donneesCommande, entetesCommande);
            this.tableauStatCommande = new JTable(PanelStatistique.unTableauCommande);
            JScrollPane uneScrollCommande = new JScrollPane(this.tableauStatCommande);
            uneScrollCommande.setBounds(360, 80, 460, 40);
            this.add(uneScrollCommande);

            this.add(new JLabel("Intervention")).setBounds(400, 130, 100, 20);
        	//construction de la JTable 
            String entetesIntervention[] = { "Nb total intervnetion", "Nb annulée", "Nb Archivée", "Nb Validée", "Nb en attente" };
            Object[][] donneesIntervention = PanelStatistique.getDonneesIntervention();
            PanelStatistique.unTableauInvervention = new Tableau(donneesIntervention, entetesIntervention);
            this.tableauStatIntervention = new JTable(PanelStatistique.unTableauInvervention);
            JScrollPane uneScrollIntervention = new JScrollPane(this.tableauStatIntervention);
            uneScrollIntervention.setBounds(360, 150, 460, 40);
            this.add(uneScrollIntervention);
    }

    public static Object[][] getDonneesCommande() {
		ArrayList<Commande> lesCommandes = C_Commande.selectAllCommandes("");
        totalCommande = 0; commandeAnnulee = 0; commandeArchivee = 0;  commandeValidee = 0; commandeEnCours = 0; 
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
            for (int i = 0; i < 5; i++) {
                ligneStatCommande[i] = matrice[0][i];
            }
		return matrice;
	}

    public  static Object[][] getDonneesIntervention() {
		ArrayList<Intervention> lesInterventions = C_Intervention.selectAllInterventions("");
         totalIntervention = 0; interAnnulee = 0;  interArchivee = 0;  interValide = 0; interEnAttente = 0; 
        for(Intervention uneIntervention : lesInterventions){
            switch (uneIntervention.getStatut()){
                case ("Annulée"): interAnnulee ++; break;
                case ("Archivée"): interArchivee ++; break;
                case ("Validée"): interValide ++; break;
                case ("En attente"): interEnAttente ++; break;
            }
            totalIntervention ++;
        }
		Object[][] matrice = new Object[1][5];
			matrice[0][0] = totalIntervention;
			matrice[0][1] = interAnnulee;
			matrice[0][2] = interArchivee;
			matrice[0][3] = interValide;
			matrice[0][4] = interEnAttente;
            for (int i = 0; i < 5; i++) {
                ligneStatIntervention[i] = matrice[0][i];
            }
		return matrice;
	}
}
