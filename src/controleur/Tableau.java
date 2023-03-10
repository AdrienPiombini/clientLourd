package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel {
	private Object[][] donnees;
	private String entetes[];

	public Tableau(Object[][] donnees, String entetes[]) {
		this.donnees = donnees;
		this.entetes = entetes;
	}

	@Override
	public int getRowCount() {
		return this.donnees.length;
	}

	@Override
	public int getColumnCount() {
		return this.entetes.length;
	}

	@Override
	public Object getValueAt(int ligne, int colonne) {
		return this.donnees[ligne][colonne];
	}

	@Override
	public String getColumnName(int colonne) {
		return this.entetes[colonne];
	}

	// ajouter une ligneà a la matrice des données

	public void insertLigne(Object ligne[]) {
		Object matrice[][] = new Object[this.donnees.length + 1][this.entetes.length];
		for (int i = 0; i < this.donnees.length; i++) {
			matrice[i] = this.donnees[i];
		}
		matrice[this.donnees.length] = ligne;
		this.donnees = matrice; // recopie de matrices.
		this.fireTableDataChanged();
	}

	// supprimer une ligne identifé par un indice/numero
	public void deleteLigne(int numLigne) {

	}

	// remplacer une ligne identique par un numero avec une nouvelle ligne
	public void updateLigne(int numLigne, Object[] ligne) {

	}

}
