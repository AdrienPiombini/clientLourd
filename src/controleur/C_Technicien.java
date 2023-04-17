package controleur;

import java.util.ArrayList;

import modele.ModeleTechnicien;

public class C_Technicien {
	public static void insertTechnicien (Technicien unTechnicien) 
	{
		// insérer le Technicien dans la BDD
		ModeleTechnicien.insertTechnicien(unTechnicien);
		System.out.println("Insertion réussie du Technicien.");
	}

	public static void insertTechnicienCDI (Technicien unTechnicien) 
	{
		// insérer le Technicien dans la BDD
		ModeleTechnicien.insertTechnicienCDI(unTechnicien);
		System.out.println("Insertion réussie du Technicien.");
	}
	
	public static void deleteTechnicien(String email)
	{
		ModeleTechnicien.deleteTechnicien(email);
	}
	
	public static void updateTechnicien (Technicien unTechnicien) 
	{
		ModeleTechnicien.updateTechnicien(unTechnicien);
	}
	
	public static ArrayList<Technicien> selectAllTechniciens(String filtre){
		return ModeleTechnicien.selectAllTechnicien(filtre); 
	}
	public static Technicien selectWhereTechnicien(String email){
		return ModeleTechnicien.selectWhereTechnicien(email);
	}
}
