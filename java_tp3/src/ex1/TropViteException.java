package ex1;

public class TropViteException extends Exception {

    public TropViteException(int entier){
        super("C'est une exception de type TropViteException. Vitesse en cause : " + entier);
    }
}
