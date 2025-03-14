package geiffel.fr;

public class Monstre {
    private String nom;
    private int pv;
    private int or;
    private Arme arme;
    private Armure armure;
    private int loot;
    private int seuilFuite;

    // Constructeur
    public Monstre(String nom, int pv, int or, Arme arme, Armure armure, int loot, int seuilFuite) {
        this.nom = nom;
        this.pv = pv;
        this.or = or;
        this.arme = arme;
        this.armure = armure;
        this.loot = loot;
        this.seuilFuite = Math.min(Math.max(seuilFuite, 0), 100); //JE SAVAIS PAS COMMENT DEFINIR DANS LE CONSTRUCTEUR CETTE ATTRIBUT J'AI DU UTILISER CHAT GPT pour cela
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

    public Arme getArme() {
        return arme;
    }

    public Armure getArmure() {
        return armure;
    }

    public int getLoot() {
        return loot;
    }

    public int getSeuilFuite() {
        return seuilFuite;
    }
    public int attaquer(){
        if (getArme()==null){
            return 0;

        }
        return arme.getAtk();

    }
    public int getDefense(){
        if (getArmure() == null) {
            return 0;
        }
        return armure.getDef();
    }

    public void prendreDegat(int quantiteDegats) {
        this.pv = this.pv - quantiteDegats;
        System.out.println("Vous avez pris :"+ quantiteDegats+"degat(s)");
        if (this.pv <= 0) {
            this.pv = 0; // Empeche le pv dans le négatif car pas logique
            System.out.println("Le monstre est mort !");
        }

    }
    public boolean estVivant(){
        if (this.pv > 0 ){
            return true;
        }
        return false;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void setArmure(Armure armure) {
        this.armure = armure;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public void setSeuilFuite(int seuilFuite) {
        this.seuilFuite = seuilFuite;
    }
    public void ajouterOr(int prix) {
        this.or += prix;

    }


}
