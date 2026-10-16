import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Lectura {
    public static void llegirJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> json = mapper.readValue(Dades.fileDadesPersonals(), Map.class);

        DadesPersonals dadesPersonals = mapper.readValue(Dades.fileDadesPersonals(), DadesPersonals.class);
        System.out.println("Dades personals: \n\t" + dadesPersonals);
    }
}
