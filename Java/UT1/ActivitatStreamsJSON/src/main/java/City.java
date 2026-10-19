public class City {
    int identificador;
    String pais;
    String ciutat;
    String districte;
    int poblacio;

    public City(int identificador, String pais, String ciutat, String districte, int poblacio) {
        this.identificador = identificador;
        this.pais = pais;
        this.ciutat = ciutat;
        this.districte = districte;
        this.poblacio = poblacio;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getDistricte() {
        return districte;
    }

    public void setDistricte(String districte) {
        this.districte = districte;
    }

    public int getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(int poblacio) {
        this.poblacio = poblacio;
    }


}
