import java.util.Scanner;

public class GestionTache {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        GestionnaireTache gestTache = new GestionnaireTache(0);
        System.out.println("-------------------------------------------------");
        System.out.println("| Bienvenu dans notre application de TODO LIST   |");
        System.out.println("-------------------------------------------------");
        System.out.println("          Ajouter Tache       ");
        System.out.println("Donnez le nombre de tache à ajouter :");
        Scanner n = new Scanner(System.in);
        int nbreTache = n.nextInt();
        if (nbreTache <= 0) {
            System.out.println("le nombre de taches ne peut pas etre négatif ou null");
        } else {
            gestTache.setNombreTache(nbreTache);
            GestionnaireTache gestTache1 = new GestionnaireTache(gestTache.getNombreTache());
            gestTache.setTaches(gestTache1.getTaches());
            for (int i = 0; i < nbreTache; i++) {
                System.out.println("Donnez le titre de la tache numero " + i);
                Scanner tit = new Scanner(System.in);
                String titre = tit.next();
                System.out.println("Donnez l'etat de la tache numero " + i);
                Scanner etatS = new Scanner(System.in);
                String etat = etatS.nextLine();
                boolean ajout = gestTache.Ajouter(new Tache(titre,etat));
                if (ajout) {
                    System.out.println("Tache ajoutee avec success.");
                } else {
                    System.out.println("Erreur! Tache n'est pas ajoutee.");
                }
            }
        }
        int response;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println(" -Tapez 1 pour modifier \n -Tapez 2 pour supprimer \n "
                    + "-Tapez 3 pour lister les taches \n -Tapez 4 pour lister en fonction de l'etat ");
            Scanner t = new Scanner(System.in);
            int tache = t.nextInt();
            if (tache == 1) {
                System.out.println("------------------------------------------------------");
                System.out.println("|                Modification                          |");
                System.out.println("------------------------------------------------------");
                if (gestTache.getTaches().length == 0) {
                    System.out.println("Il n'y a pas de taches à modifier");
                } else {
                    System.out.println("Donnez l'identifiant de la tache à modifier :");
                    Scanner iden = new Scanner(System.in);
                    int id = iden.nextInt();
                    for (int i = 0; i < gestTache.getTaches().length; i++) {
                        if (id == gestTache.getTaches()[i].getIdentifiant()) {
                            System.out.println("Donnez le nouveau titre de la tache :");
                            String title = iden.next();
                            System.out.println("Donnez le nouveau etat de la tache :");
                            String etat = iden.next();
                            Tache testTache2 = new Tache(title, etat);
                            testTache2.setIdentifiant(id);
                            boolean modifTache = gestTache.Modifier(testTache2);
                            if (modifTache) {
                                System.out.println("Modification reussie");
                            } else {
                                System.out.println("Echec de la modification");
                            }
                        }
                    }
                }
            } else if (tache == 2) {
                System.out.println("-------------------------------------------------");
                System.out.println("|             Suppression                        |");
                System.out.println("-------------------------------------------------");
                System.out.println("Donnez l'identifiant de la tache à supprimer :");
                Scanner s = new Scanner(System.in);
                int sup = s.nextInt();
                boolean supTache = gestTache.supprimer(sup);
                if (supTache) {
                    System.out.println("Suppression reussie");
                } else {
                    System.out.println("Echec de la suppression");
                }
            } else if (tache == 3) {
                System.out.println("------------------------------------------");
                if (gestTache.getTaches().length == 0) {
                    System.out.println("Erreur! il n'y a pas de tache à ajouter.");
                } else {
                    for (int i = 0; i < gestTache.getTaches().length; i++) {
                        System.out.println("Liste des taches");
                        System.out.println(gestTache.lister()[i].toString());
                    }
                }
            } else if (tache == 4) {
                System.out.println("------------------------------------------");
                System.out.println("Donnez l'etat des taches que vous voulez lister");
                Scanner e = new Scanner(System.in);
                String eta = e.next();
                System.out.println("Liste des taches par etat");
                for (int i = 0; i < gestTache.lister(eta).length; i++) {

                    System.out.println(gestTache.lister(eta)[i].toString());
                }
            }
            System.out.println("-------------------------------------------------");
            System.out.println("|                 Terminer                       |");
            System.out.println("-------------------------------------------------");
            System.out.println("Tapez 1 pour continuer ou 0 pour quitter");
            Scanner r = new Scanner(System.in);
            response = r.nextInt();
        } while (response == 1);
        System.out.println("Au revoir!!!");
    }

}
