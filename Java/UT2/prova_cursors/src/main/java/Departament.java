import java.util.List;

public class Departament {
    int id;
    String lloc;
    List<Empleat> empleats;

    public Departament(int id, String lloc, List<Empleat> empleats) {
        this.id = id;
        this.lloc = lloc;
        this.empleats = empleats;
    }

    public void afegirEmpleat(Empleat empleat) {
        empleats.add(empleat);
    }

    public int getId() {
        return id;
    }

    public String getLloc() {
        return lloc;
    }

    public List<Empleat> getEmpleats() {
        return empleats;
    }
}