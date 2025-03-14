package geiffel.fr;

public class Armure {
    private String nom;
    private int def;
    private int poids;
    private double prix;

    // Constructeur
    public Armure(String nom, int def, int poids, double prix) {
        this.nom = nom;
        this.def = def;
        this.poids = poids;
        this.prix = prix;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getDef() {
        return def;
    }

    public int getPoids() {
        return poids;
    }

    public double getPrix() {
        return prix;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


}
