package cat.paucasesnovescifp.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    static void main() {
        File arxiuPersona = new File("persona.json");
        File arxiuPersones = new File("empleats.json");
        try {
            lecturaMap(arxiuPersona);
            deserialitzacioPojo(arxiuPersona);
            llistaObjectes(arxiuPersones);
            filtratDInformacio(arxiuPersones);
            serialitzarPersona();
            guardarPersones();
            lecturaArbre(arxiuPersona);
            afegirModificarCamps(arxiuPersona);
            eliminarCamps(arxiuPersona);
            manipularArray(arxiuPersones);
            actualitzacioGeneral(arxiuPersones);
        } catch (IOException e) {
            IO.println(e.getMessage());
        }

    }

    static void lecturaMap(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> json = mapper.readValue(arxiu, Map.class);

        IO.println("Persona: " + json);
    }

    static void deserialitzacioPojo(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> json = mapper.readValue(arxiu, Map.class);

        Persona persona = new Persona((String) json.get("nom"), (Integer) json.get("edat"), (String) json.get("ciutat"));
        IO.println(persona);
    }

    static void llistaObjectes(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        TypeReference<List<Persona>> ref = new TypeReference<>() {};
        List<Persona> persones = mapper.readValue(arxiu, ref);

        for (Persona persona : persones){
            IO.println(persona);
        }
    }

    static void filtratDInformacio(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        TypeReference<List<Persona>> ref = new TypeReference<>() {};
        List<Persona> persones = mapper.readValue(arxiu, ref);
        List<Persona> personesMajors = new ArrayList<>();

        for (Persona persona : persones){
            if (persona.getEdat() > 30) {
                personesMajors.add(persona);
            }
        }
        File arxiuMajors30 = new File("empleatsMajors.json");

        mapper.enable(SerializationFeature.INDENT_OUTPUT).writeValue(arxiuMajors30, personesMajors);
    }

    static void serialitzarPersona() throws IOException{
        Persona persona = new Persona("Tomeu", 57, "Barcelona");
        ObjectMapper mapper = new ObjectMapper();

        File arxiuDesti = new File("novaPersona.json");

        mapper.writerWithDefaultPrettyPrinter().writeValue(arxiuDesti, persona);
    }

    static void guardarPersones() throws IOException{
        Persona persona = new Persona("Tomeu", 57, "Barcelona");
        Persona persona2 = new Persona("Andreu", 23, "Lleida");
        Persona persona3 = new Persona("Toni", 12, "Tarragona");
        List<Persona> persones = new ArrayList<>();
        persones.add(persona);
        persones.add(persona2);
        persones.add(persona3);

        ObjectMapper mapper = new ObjectMapper();

        File arxiuDesti = new File("llistaPersones.json");

        mapper.writerWithDefaultPrettyPrinter().writeValue(arxiuDesti, persones);
    }

    static void lecturaArbre(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(arxiu);

        IO.println(rootNode.get("nom").asText());
    }

    static void afegirModificarCamps(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(arxiu);

        if (rootNode.isObject()){
            ObjectNode objectNode = (ObjectNode) rootNode;
            objectNode.put("email", "a@gmail.com");
            objectNode.put("ciutat", "Alibaba");
            IO.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
        }

    }

    static void eliminarCamps(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(arxiu);

        if (rootNode.isObject()){
            ObjectNode objectNode = (ObjectNode) rootNode;
            objectNode.remove("edat");
            IO.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
        }
    }

    static void manipularArray(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(arxiu);

        if (rootNode.isArray()){
            ArrayNode arrayNode = (ArrayNode) rootNode;

            System.out.println();
            System.out.println("Afegir un usuari a l'array");
            ObjectNode novaPersona = mapper.createObjectNode();
            novaPersona.put("id", 234);
            novaPersona.put("name", "Marc");
            novaPersona.put("edat", 35);

            arrayNode.add(novaPersona);
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode));

            System.out.println();
            System.out.println("Modificar elements dins un array");
            for(JsonNode node : arrayNode){
                if(node.get("edat").asInt() == 11){
                    ObjectNode persona = (ObjectNode) node;
                    persona.put("ciutat", "Sa Pobla");
                }
            }
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode));

            System.out.println();
            System.out.println("Eliminar elements");
            File personesFiltrades = new File("empleatsFiltrats.json");

            Iterator<JsonNode> iterator = rootNode.elements();
            while (iterator.hasNext()){
                JsonNode node = iterator.next();

                if(node.get("edat").asInt() < 30) {
                    iterator.remove();
                }
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(personesFiltrades, rootNode);

        }
    }

    static void actualitzacioGeneral(File arxiu) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(arxiu);

        Iterator<JsonNode> iterator = rootNode.elements();
        while (iterator.hasNext()){
            JsonNode node = iterator.next();

            ObjectNode empleat = (ObjectNode) node;
            empleat.put("edat", empleat.get("edat").asInt() + 1);
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("empleatsActualitzats.json"), rootNode);
    }
}
