package ex1;

public class Main {
    public static void main(String[] args) {
        Talkative t1 = new Talkative(1);
        Talkative t2 = new Talkative(2);
        Talkative t3 = new Talkative(3);
        Talkative t4 = new Talkative(4);
        Talkative t5 = new Talkative(5);
        Talkative t6 = new Talkative(6);
        Talkative t7 = new Talkative(7);
        Talkative t8 = new Talkative(8);
        Talkative t9 = new Talkative(9);
        Talkative t10 = new Talkative(10);

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
        new Thread(t5).start();
        new Thread(t6).start();
        new Thread(t7).start();
        new Thread(t8).start();
        new Thread(t9).start();
        new Thread(t10).start();



    }
}
