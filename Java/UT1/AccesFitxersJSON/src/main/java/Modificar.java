import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Modificar {
    public static void afegirLlenguatgeIModificarCarrer() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        TypeReference<List<DadesPersonals>> ref = new TypeReference<List<DadesPersonals>>() {};
        List<DadesPersonals> dadesPersonals = mapper.readValue(Dades.fileDadesPersonals(), ref);

        for(DadesPersonals dades : dadesPersonals) {
            ArrayList<String> llenguatges = dades.getLlenguatges();
            llenguatges.add("C");
            dades.setLlenguatges(llenguatges);
            Adresa adresa = dades.getAdresa();
            adresa.setCarrer("Avinguda del riu");
            dades.setAdresa(adresa);
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/novesDades.json"), dadesPersonals);
    }
}
