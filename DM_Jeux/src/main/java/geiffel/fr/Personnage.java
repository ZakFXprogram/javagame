package geiffel.fr;
import java.util.Random;
public class Personnage {
    private String nom;
    private int pv;
    private int or;
    private int niveau;
    private Arme arme;
    private Armure armure;

    // Constructeur
    public Personnage(String nom, int pv, int or, int niveau, Arme arme, Armure armure) {
        this.nom = nom;
        this.pv = pv;
        this.or = or;
        this.niveau = niveau;
        this.arme = arme;
        this.armure = armure;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getOr() {
        return or;
    }

    public int getNiveau() {
        return niveau;
    }

    public Arme getArme() {
        return arme;
    }

    public Armure getArmure() {
        return armure;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void setArmure(Armure armure) {
        this.armure = armure;
    }

    public int attaquer() {
        return arme.getAtk();
    }

    public int getDefense() {
        return armure.getDef();
    }

    public void prendreDegats(int quantiteDegats) {
        this.pv -= quantiteDegats;
        if (this.pv == 0) {
            System.out.println("Vous êtes mort ! GAME OVER");
        }
    }

    public boolean estVivant() {
        if (this.pv > 0) {
            return true;
        }
        return false;
    }

    public int fuite() {
        Random chx = new Random();
        int chance = chx.nextInt(101);
        int poidsArmure = 0;

        if (armure != null) {
            poidsArmure = armure.getPoids();
        }

        int resultatFuite = chance - poidsArmure;

        if (resultatFuite < 0) {
            return 0;
        }
        return resultatFuite;
    }
    public void ajouterOr(int prix) {
        this.or += prix;

    }

}

