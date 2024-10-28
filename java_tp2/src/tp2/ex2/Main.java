package tp2.ex2;

public class Main {
    public static void main(String[] args) {
        Ingenieur ing = new Ingenieur("nomIng","prenomIng","emailing@gmail.com",
                "0604862820",12000,"info");
        ing.calculerSalaire();

        Manager manager = new Manager("nomMan","prenomMan","emailman@gmail.com",
                "0604862820",12000,"info service");
        manager.calculerSalaire();

        System.out.println("Infos sur ingenieur :");
        System.out.println(ing.toString());

        System.out.println("Infos sur manager :");
        System.out.println(manager.toString());

    }
}
