package tp2.ex2;

public abstract class Employee {
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private double salaire;

    public Employee() {
    }

    public Employee(String nom, String prenom, String email, String tel, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.salaire = salaire;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public abstract double calculerSalaire();

    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", salaire=" + salaire;
    }
}
