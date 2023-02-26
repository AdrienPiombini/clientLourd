package controleur ; 

import vue.VueConnexion;

public class Filelec2{
    private static VueConnexion uneVueConnexion;
    public static void main(String[] args){
        uneVueConnexion = new VueConnexion();
    }

    public static void rendreVisibleVueConnexion(boolean action){
        uneVueConnexion.setVisible(action);
    }

}