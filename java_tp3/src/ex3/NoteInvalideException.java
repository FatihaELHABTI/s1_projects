package ex3;

public class NoteInvalideException extends Exception{

    public NoteInvalideException(int nombre) {
        super("Exception de type NoteInvalideException. Note invalide : " + nombre);
    }
}
