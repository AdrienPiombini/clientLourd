package controleur;
import java.util.ArrayList;
import modele.ModeleProfessionnel;

public class C_Professionnel {

	public static void insertProfessionnel (Professionnel unProfessionnel) 
	{
		ModeleProfessionnel.insertProfessionnel(unProfessionnel);
		System.out.println("Insertion réussie du Professionnel.");
	}
	
	public static void deleteProfessionnel(String email)
	{
		ModeleProfessionnel.deleteProfessionnel(email);

	}
	
	public static void updateProfessionnel (Professionnel unProfessionnel) 
	{
		ModeleProfessionnel.updateProfessionnel(unProfessionnel);
	}
	
	public static ArrayList<Professionnel> selectAllProfessionnels(String filtre){
	return  ModeleProfessionnel.selectAllProfessionnel(filtre);
	}

	public static Professionnel selectWhereProfessionnel(String email){
		return ModeleProfessionnel.selectWhereProfessionnel(email);
	}
	
}
