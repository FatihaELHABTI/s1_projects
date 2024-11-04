package ex3;


public class Evaluateur {
    public Evaluateur() {

    }


    public void verifierNote(int note) throws NoteInvalideException {
        if (note < 0 || note >20) {
            throw new NoteInvalideException(note);
        } else {
            System.out.println("Votre note est " + note);
        }
    }


    public static void main(String[] args) {
        Evaluateur calculateur = new Evaluateur();

        try {
            System.out.println("Test avec -5 :");
            calculateur.verifierNote(15);
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Test avec 25 :");
            calculateur.verifierNote(25);
        } catch (NoteInvalideException e) {
            e.printStackTrace();
        }
    }
}
