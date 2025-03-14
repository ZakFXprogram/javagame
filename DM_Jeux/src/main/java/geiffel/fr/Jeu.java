package geiffel.fr;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private Personnage lePersonnage;
    private List<Monstre> lesMonstres;
    private List<Marché> lesMarches;

    public Jeu(Personnage personnage) {
        this.lePersonnage = personnage;
        this.lesMonstres = new ArrayList<>();
        this.lesMarches = new ArrayList<>();
    }
    public void creerPersonnage() {
        Scanner scanner = new Scanner(System.in);//fonction scanner pour read la cmd line
        System.out.print("Entrez le nom de votre personnage : ");
        String nom = scanner.nextLine();
        this.lePersonnage = new Personnage(nom, 300, 1000, 1, null, null);
        System.out.println("Votre Personnage " + nom + " a été créer !");
    }
    public Monstre monstreAleatoire(){
        Random chxMonstre = new Random();
        int indexMonstre = chxMonstre.nextInt(lesMonstres.size());
        return lesMonstres.get(indexMonstre);

    }



    public boolean fuite(int seuilFuite) {
        if (lePersonnage == null) {
            return false;
        }
        return lePersonnage.fuite() >= seuilFuite;
    }
    public void combat(){
        while (lePersonnage.getPv() > 0) {
            Monstre monstreActuel = monstreAleatoire();  // Choisir un monstre au début du combat qui restera le meme
            System.out.println("Un fight commence contre " + monstreActuel.getNom() + "!");

            while (monstreActuel.getPv() > 0 && lePersonnage.getPv() > 0) {
                System.out.println("Choissisez -> zzz(a: Attaquer, f: Fuir)");
                Scanner scanner = new Scanner(System.in);
                String rep = scanner.nextLine();

                if (rep == "a") {

                    int degats = lePersonnage.attaquer() - monstreActuel.getDefense();
                    if (degats > 0) {
                        monstreActuel.setPv(monstreActuel.getPv() - degats);
                        System.out.println(lePersonnage.getNom() + "a infligé " + degats + " dégâts.");
                    }
                }
                if (rep == "f") {
                    if (fuite(50)) {
                        System.out.println(lePersonnage.getNom() + " a réussi à fuir !");
                        return;
                    }
                    else {
                        System.out.println(lePersonnage.getNom() + " n'a pas réussi à fuir.");
                    }
                }
                if (monstreActuel.getPv() <= 0) {
                    System.out.println(monstreActuel.getNom() + " est mort");
                    lePersonnage.ajouterOr(monstreActuel.getLoot());
                    System.out.println("Vous avez gagné " + monstreActuel.getLoot() + " pièces d'or.");
                }

                // Vérifier si le personnage a die
                if (lePersonnage.getPv() <= 0) {
                    System.out.println(lePersonnage.getNom() + " est mort. FINISHIM.");
                    break;
                }
            }
        }
    }
    public Marché marchéAleatoire(){
        Random random = new Random();
        int indexMarché = random.nextInt(lesMarches.size());
        return lesMarches.get(indexMarché);

    }

    public void achat() {
        Scanner scanner = new Scanner(System.in);
        Marché marche = lesMarches.get(new Random().nextInt(lesMarches.size()));

        System.out.println("Bienvenue au marché " + marche.getNom() + " !");

        while (true) {
            System.out.println("Que souhaitez-vous acheter ?");
            System.out.println("1. Armes");
            System.out.println("2. Armures");
            System.out.println("3. Quitter le marché");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            if (choix == 3) break;

            if (choix == 1) {
                List<Arme> armes = marche.getLesArmesAVendre();
                if (armes.isEmpty()) {
                    System.out.println("Aucune arme disponible.");
                    continue;
                }
                for (int i = 0; i < armes.size(); i++) {
                    System.out.println(i + ". " + armes.get(i).getNom() + " (ATK: " + armes.get(i).getAtk() + ", Prix: " + armes.get(i).getPrix() + ")");
                }
                System.out.print("Choisissez une arme (indice) : ");
                int indice = scanner.nextInt();
                if (indice >= 0 && indice < armes.size() && lePersonnage.getOr() >= armes.get(indice).getPrix()) {
                    lePersonnage.setOr(lePersonnage.getOr() - (int) armes.get(indice).getPrix());
                    lePersonnage.setArme(armes.get(indice));
                    System.out.println("Vous avez acheté " + armes.get(indice).getNom() + " !");
                } else {
                    System.out.println("Achat impossible.");
                }
            } else if (choix == 2) {
                List<Armure> armures = marche.getLesArmuresAVendre();
                if (armures.isEmpty()) {
                    System.out.println("Aucune armure disponible.");
                    continue;
                }
                for (int i = 0; i < armures.size(); i++) {
                    System.out.println(i + ". " + armures.get(i).getNom() + " (DEF: " + armures.get(i).getDef() + ", Prix: " + armures.get(i).getPrix() + ")");
                }
                System.out.print("Choisissez une armure (indice) : ");
                int indice = scanner.nextInt();
                if (indice >= 0 && indice < armures.size() && lePersonnage.getOr() >= armures.get(indice).getPrix()) {
                    lePersonnage.setOr(lePersonnage.getOr() - (int) armures.get(indice).getPrix());
                    lePersonnage.setArmure(armures.get(indice));
                    System.out.println("Vous avez acheté " + armures.get(indice).getNom() + " !");
                } else {
                    System.out.println("Achat impossible.");
                }
            } else {
                System.out.println("Choix invalide.");
            }
        }

    }
    public void rencontreAlea() {
        Random meeting = new Random();
        if (meeting.nextInt(2) == 0) {
            System.out.println("Un combat commence !");
            combat();
        } else {
            achat();
        }
    }
    public void jouer() {
        while (lePersonnage.getPv() > 0 && lePersonnage.getNiveau() < 10) {
            rencontreAlea();
            System.out.println("Voulez-vous continuer à jouer ? (oui/non)");
            Scanner scanner = new Scanner(System.in);
            if (scanner.next().equalsIgnoreCase("non"))
                break;
        }
        System.out.println("Fin du jeu.");
    }
}
