package controleur;

import java.util.ArrayList;
import modele.ModeleIntervention;


public class C_Intervention {
	public static void insertIntervention(Intervention uneIntervention){
		ModeleIntervention.insertIntervention(uneIntervention);
		System.out.println("Insertion réussie du Intervention.");
	}

	public static void deleteIntervention(int idIntervention) {
		ModeleIntervention.deleteIntervention(idIntervention);
	}

	public static void updateIntervention(Intervention uneIntervention) {
		ModeleIntervention.updateIntervention(uneIntervention);
	}

	public static ArrayList<Intervention> selectAllInterventions(String filtre) {
		return  ModeleIntervention.selectAllIntervention(filtre);	
	}

	public static Intervention selectWhereIntervention(int idIntervention){
		return ModeleIntervention.selectWhereIntervention(idIntervention);
	}

	public static Intervention selectWhereIntervention(String dateintervention, int idclient, int idtechnicien){
		return ModeleIntervention.selectWhereIntervention(dateintervention, idclient, idtechnicien);
	}
}
