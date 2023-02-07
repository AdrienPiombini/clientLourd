package vue;

import java.util.Scanner;

import controleur.Users;

public class VueUsers {
    public class VueUser {
        public static Users saisirUser() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Donner l'email User");
            String email = sc.next();
            System.out.println("Donner le mdp d'User");
            String mdp = sc.next();
            System.out.println("Donner le nom");
            String nom = sc.next();
            System.out.println("Donner le roles ");
            String roles = sc.next();
            System.out.println("Donner la datemdp ");
            String datemdp = sc.next();
            Users unUser = new Users(email, mdp, nom, roles, datemdp);
            return unUser;
        }
    
        public static void afficherUser(Users unUser) {
            System.out.println("ld User  : " + unUser.getIduser());
            System.out.println("email ntervention  : " + unUser.getEmail());
            System.out.println("mdp User : " + unUser.getMdp());
            System.out.println("nom  : " + unUser.getNom());
            System.out.println("roles  : " + unUser.getRoles());
            System.out.println("datemdp  : " + unUser.getDatemdp());
        }
    
        public static Users modifierUser(Users unUser) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ancien id User : " + unUser.getIduser());
            System.out.println("Donner le nouveau libelle ");
            unUser.setIduser(sc.nextInt());
    
            System.out.println("Ancien  email : " + unUser.getEmail());
            System.out.println("Donner le nouvel email  ");
            unUser.setEmail(sc.next());
    
            System.out.println("Ancien statut mdp : " + unUser.getMdp());
            System.out.println("Donner la nouvelle date ");
            unUser.setMdp(sc.next());
    
            System.out.println("Ancien nom  : " + unUser.getNom());
            System.out.println("Donner le nouveau prix HT");
            unUser.setNom(sc.next());
    
            System.out.println("Ancien roles : " + unUser.getRoles());
            System.out.println("Donner le nouveau roles ");
            unUser.setRoles(sc.next());
    
            System.out.println("Ancien datemdp  : " + unUser.getDatemdp());
            System.out.println("Donner le nouveau datemdp ");
            unUser.setDatemdp(sc.next());

    
            return unUser;
        }
    }
}


