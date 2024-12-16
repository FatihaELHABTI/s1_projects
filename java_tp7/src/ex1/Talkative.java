package ex1;

public class Talkative implements Runnable{

    private static int attribut;

    public Talkative(int entier){
        Talkative.attribut = entier;
    }

    @Override
    public void run() {
        for(int i=0 ; i<2 ; i++){
            System.out.println( attribut);
        }
    }
}
