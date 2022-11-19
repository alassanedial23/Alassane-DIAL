import java.time.LocalDateTime;
import java.util.Date;

public class Tache {
    private int identifiant;
    private static int dernierId = 1;
    private String titre;
    private String etat;
    private LocalDateTime dateCreation;


    public Tache(String titre) {
        this.titre = titre;
        this.identifiant = dernierId;
        dernierId++;
        this.etat = "prevu";
        this.dateCreation = LocalDateTime.now();
    }

    public Tache(String titre, String etat) {
        this.titre = titre;
        this.etat = etat;
        this.identifiant = dernierId;
        dernierId++;
        this.dateCreation = LocalDateTime.now();
    }

    public Tache(String titre, String etat, LocalDateTime dateCreation) {
        this.titre = titre;
        this.etat = etat;
        this.identifiant = dernierId;
        dernierId++;
        this.dateCreation = dateCreation;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public static int getDernierId() {
        return dernierId;
    }

    public static void setDernierId(int dernierId) {
        Tache.dernierId = dernierId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String toString() {
        return "Tache {" +
                "identifiant='" + identifiant + '\'' + ",titre='" + titre + '\'' +
                ", etat='" + etat + '\'' +
                ", dateCreation='" + dateCreation +
                '}';
    }

}
