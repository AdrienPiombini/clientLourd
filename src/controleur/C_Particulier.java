package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleParticulier;


public class C_Particulier {
    public static void insertParticulier(Particulier unParticulier) {
		ModeleParticulier.insertParticulier(unParticulier);
		System.out.println("Insertion réussie de l'Particulier.");
	}

	public static void deleteParticulier(String email) {
		ModeleParticulier.deleteParticulier(email);
	}

	public static void updateParticulier(Particulier unParticulier) {
		ModeleParticulier.updateParticulier(unParticulier);
	}

	public static ArrayList<Particulier> selectAllParticulier(String filtre) {
		return  ModeleParticulier.selectAllParticulier(filtre);
	}

	public static Particulier selectWhereParticulier(String email){
		return ModeleParticulier.selectWhereParticulier(email);
	}
}
