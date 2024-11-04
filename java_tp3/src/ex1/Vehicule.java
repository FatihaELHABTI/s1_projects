package ex1;

public class Vehicule {

    public Vehicule(){

    }

    public void testVitesse(int entier) throws TropViteException {
        if(entier > 90) throw new TropViteException(entier);
    }

    public static void main(String[] args){

        Vehicule vehicule = new Vehicule();
        try {

            System.out.println("Test avec une vitesse de 80 km/h :");
            vehicule.testVitesse(80);
            System.out.println("Pas d'exception pour 80 km/h");

            System.out.println("Test avec une vitesse de 100 km/h :");
            vehicule.testVitesse(100);
        } catch (TropViteException e) {
            e.printStackTrace();
            //e.getMessage();
        }

    }
}
