import java.io.File;
import java.util.List;

public class Main {
    static void main() {
        File arxiuCiutats = new File("src/main/resources/cities.txt");
        File jsonCiutats = new File("src/main/resources/ciutats.json");
        File jsonPaisos = new File("src/main/resources/paisos.json");
        File jsonPaisosLlistaCiutats = new File("src/main/resources/paisos_llista_ciutats.json");

        List<City> arrayCiutats = Programa.guardarCiutatsPojoEnArray(arxiuCiutats);

        Programa.generarArxiuCiutats(jsonCiutats, arrayCiutats);

        Programa.generarArxiuPaisos(jsonPaisos, arrayCiutats);

        Programa.generarPaisosLlistaCiutats(jsonPaisosLlistaCiutats, arrayCiutats);
    }
}
