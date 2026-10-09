package cat.paucasesnovescifp.main;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Main {
    static void main() {

    }

    static oid lecturaMap(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> json = mapper.readValue(arxiu, Map.class);

        IO.println("Persona: " + json);
    }
}
