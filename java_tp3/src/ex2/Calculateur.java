package ex2;

class Calculateur {
    public Calculateur() {

    }


    public void testRacineCarree(int nombre) throws RacineCarreeException {
        if (nombre < 0) {
            throw new RacineCarreeException(nombre);
        } else {
            System.out.println("La racine carrée de " + nombre + " est calculable.");
        }
    }


    public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();

        try {
            System.out.println("Test avec -5 :");
            calculateur.testRacineCarree(-5);
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Test avec 25 :");
            calculateur.testRacineCarree(25);
        } catch (RacineCarreeException e) {
            e.printStackTrace();
        }
    }
}

