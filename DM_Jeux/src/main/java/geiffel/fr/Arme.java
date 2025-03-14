package geiffel.fr;

public class Arme {
    private String nom;
    private int atk;
    private double prix;

    // Constructeur
    public Arme(String nom, int atk, double prix) {
        this.nom = nom;
        this.atk = atk;
        this.prix = prix;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getAtk() {
        return atk;
    }

    public double getPrix() {
        return prix;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
