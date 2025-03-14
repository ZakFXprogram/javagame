package geiffel.fr;

import java.util.ArrayList;
import java.util.List;

public class Marché {
    private String nom;
    private List<Arme> lesArmesAVendre;
    private List<Armure> lesArmuresAVendre;

    public Marché(String nom) {
        this.nom = nom;
        this.lesArmesAVendre = new ArrayList<>();
        this.lesArmuresAVendre = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Armure> getLesArmuresAVendre() {
        return lesArmuresAVendre;
    }

    public List<Arme> getLesArmesAVendre() {
        return lesArmesAVendre;
    }

    public void setLesArmesAVendre(List<Arme> lesArmesAVendre) {
        this.lesArmesAVendre = lesArmesAVendre;
    }

    public void setLesArmuresAVendre(List<Armure> lesArmuresAVendre) {
        this.lesArmuresAVendre = lesArmuresAVendre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Arme acheterArme(int indexArme){
        Arme armeAchetee = lesArmesAVendre.get(indexArme);
        lesArmesAVendre.remove(indexArme);
        return armeAchetee;
    }
    //J'ai crée sa en plus car comment on veut vendre alors qu'on peut y ajouter des arme
    public void ajouterArme(Arme arme) {
        lesArmesAVendre.add(arme);
    }

    public void ajouterArmure(Armure armure) {
        lesArmuresAVendre.add(armure);
    }
}

