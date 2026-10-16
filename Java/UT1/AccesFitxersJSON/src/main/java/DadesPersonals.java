import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class DadesPersonals {
    String nom;
    int edat;
    String correu;
    Adresa adresa;
    ArrayList<String> llenguatges;

    public DadesPersonals(String nom, int edat, String correu, Adresa adresa, ArrayList<String> llenguatges) {
        this.nom = nom;
        this.edat = edat;
        this.correu = correu;
        this.adresa = adresa;
        this.llenguatges = llenguatges;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public ArrayList<String> getLlenguatges() {
        return llenguatges;
    }

    public void setLlenguatges(ArrayList<String> llenguatges) {
        this.llenguatges = llenguatges;
    }



    @Override
    public String toString() {
        return "DadesPersonals{" +
                "nom='" + nom + '\'' +
                ", edat=" + edat +
                ", correu='" + correu + '\'' +
                ", adresa=" + adresa +
                ", llenguatges=" + llenguatges +
                '}';
    }
}
