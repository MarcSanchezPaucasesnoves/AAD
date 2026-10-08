package cat.paucasesnovescifp.dades;

import java.io.Serializable;
import java.time.LocalDate;

public class Empleat implements Serializable {
    private int numero;
    private String nom;
    private String cognoms;
    private LocalDate alta;
    private String categoria;
    private int salari;

    public Empleat(int numero, String nom, String cognoms, LocalDate alta, String categoria, int salari) {
        this.numero = numero;
        this.nom = nom;
        this.cognoms = cognoms;
        this.alta = alta;
        this.categoria = categoria;
        this.salari = salari;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public LocalDate getAlta() {
        return alta;
    }

    public void setAlta(LocalDate alta) {
        this.alta = alta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getSalari() {
        return salari;
    }

    public void setSalari(int salari) {
        this.salari = salari;
    }

    @Override
    public String toString() {
        return "Empleat{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", cognoms='" + cognoms + '\'' +
                ", alta=" + alta +
                ", categoria='" + categoria + '\'' +
                ", salari=" + salari +
                '}';
    }
}