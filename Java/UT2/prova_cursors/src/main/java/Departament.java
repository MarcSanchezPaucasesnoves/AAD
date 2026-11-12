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
}