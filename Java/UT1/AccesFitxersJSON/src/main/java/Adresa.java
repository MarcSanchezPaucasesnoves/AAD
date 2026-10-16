public class Adresa {
    String carrer;
    int numero;
    String ciutat;
    String pais;

    public Adresa(String carrer, int numero, String ciutat, String pais) {
        this.carrer = carrer;
        this.numero = numero;
        this.ciutat = ciutat;
        this.pais = pais;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "carrer='" + carrer + '\'' +
                ", numero=" + numero +
                ", ciutat='" + ciutat + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
