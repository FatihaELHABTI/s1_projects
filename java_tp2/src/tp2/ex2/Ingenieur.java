package tp2.ex2;

public class Ingenieur extends Employee {
    private String specialite;


    public Ingenieur(String nom, String prenom, String email, String tel, double salaire, String specialite) {
        super(nom, prenom, email, tel, salaire);
        this.specialite = specialite;
    }

    @Override
    public double calculerSalaire() {
        setSalaire(getSalaire() + getSalaire()*0.15);
        return getSalaire()   ;
    }

    @Override
    public String toString() {
        return "Ingenieur{ " + super.toString() +
                " ,specialite='" + specialite + '\'' +
                '}';
    }
}
