package tp2.ex2;

public class Manager extends Employee{
    private String service;

    public Manager(String nom, String prenom, String email, String tel, double salaire, String service) {
        super(nom, prenom, email, tel, salaire);
        this.service = service;
    }

    @Override
    public double calculerSalaire() {
        setSalaire(getSalaire() + getSalaire()*0.20);
        return getSalaire() + getSalaire()*0.20;
    }

    @Override
    public String toString() {
        return " Manager{" + super.toString() +
                " ,service='" + service + '\'' +
                '}';
    }
}
