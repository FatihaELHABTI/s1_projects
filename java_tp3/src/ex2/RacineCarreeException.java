package ex2;

class RacineCarreeException extends Exception {
    public RacineCarreeException(int nombre) {
        super("C'est une exception de type RacineCarreeException. Nombre négatif : " + nombre);
    }
}

