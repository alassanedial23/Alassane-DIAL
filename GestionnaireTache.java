public class GestionnaireTache {
    private Tache taches[];
    private int nombreTache;
    private static int index = 0;

    public GestionnaireTache(int nombreMax) {
        this.nombreTache = nombreMax;
        this.taches = new Tache[nombreTache];
    }

    public Tache[] getTaches() {
        return taches;
    }

    public int getNombreTache() {
        return nombreTache;
    }

    public void setNombreTache(int nombreTache) {
        this.nombreTache = nombreTache;
    }

    public void setTaches(Tache[] taches) {
        this.taches = taches;
    }

    public boolean Ajouter(Tache tache) {
        if (this.index < this.taches.length) {
            taches[index] = tache;
            index++;
            return true;
        } else {
            return false;
        }

    }

    public boolean Modifier(Tache tache) {
        boolean verif = false;
        for (int i = 0; i < taches.length; i++) {
            if (taches[i].getIdentifiant() == tache.getIdentifiant()) {
                taches[i].setTitre(tache.getTitre());
                taches[i].setEtat(tache.getEtat());
                taches[i].setDateCreation(tache.getDateCreation());
                verif = true;
            }

        }
        if (verif) {
            return true;
        } else {
            return false;
        }
    }

    public boolean supprimer(int id) {
        boolean verif = false;
        for (int i = 0; i < this.taches.length; i++) {
            if (id == taches[i].getIdentifiant()) {

                taches[i] = null;

                verif = true;
            }
        }
        if (verif) {
            return true;
        } else {
            return false;
        }
    }

    public Tache[] lister() {
        return taches;
    }

    public Tache[] lister(String etat) {
        Tache[] listeTache = new Tache[taches.length];
        int j = 0;
        for (int i = 0; i < taches.length; i++) {
            if (taches[i].getEtat().equals(etat)) {
                listeTache[j] = taches[i];
                j++;
            }
        }
        return listeTache;
    }
}
