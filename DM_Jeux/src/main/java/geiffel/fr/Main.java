package geiffel.fr;



public class Main {
    public static void main(String[] args) {
         Arme Poing= new Arme("Poing", 20, 0);
         Armure Habits = new Armure("Habits", 1, 0, 0);
         Personnage ZL1 = new Personnage("ZL1",300,10000,1,Poing,Habits);
         Monstre Bukar = new Monstre("Bukar",100,22121,Poing,Habits,21222,50);
         Marché Bagdad = new Marché("BatataLand");
         Jeu Naruto = new Jeu(ZL1);
         //J'ai pas réussi à le lancer je sais meme pas si le jeu marche

    }

}