package cat.paucasesnovescifp.main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class CRUD {
    static void main(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File("empleats.json"));
            llistarEmpleats(rootNode);
            afegirEmpleat(rootNode, "asdk", 20, "Fili");
            modificarEmpleat(rootNode, 1, "Mauro", 12, "Melilla");
            eliminarEmpleat(rootNode, 0);
            llistarEmpleats(rootNode);
            guardarCanvis(mapper, rootNode);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }

    private static void llistarEmpleats(JsonNode rootNode){
        Iterator<JsonNode> iterator = rootNode.elements();

        for (int i = 0; iterator.hasNext(); i++) {
            JsonNode node = iterator.next();
            System.out.println("Persona nº" + i);
            IO.println(node);
        }
    }

    private static void afegirEmpleat(JsonNode rootNode, String nom, int edat, String ciutat){
        ObjectMapper mapper = new ObjectMapper();

        ArrayNode arrayNode = (ArrayNode) rootNode;

        ObjectNode novaPersona = mapper.createObjectNode();
        novaPersona.put("nom", nom);
        novaPersona.put("edat", edat);
        novaPersona.put("ciutat", ciutat);

        arrayNode.add(novaPersona);
    }

    private static void modificarEmpleat(JsonNode rootNode, int nUsuari, String nom, int edat, String ciutat){

        Iterator<JsonNode> iterator = rootNode.elements();

        for (int i = 0; iterator.hasNext(); i++) {
            JsonNode node = iterator.next();
            if (nUsuari == i){
                ObjectNode persona = (ObjectNode) node;
                persona.put("nom", nom);
                persona.put("edat", edat);
                persona.put("ciutat", ciutat);
            }
        }
    }

    private static void eliminarEmpleat(JsonNode rootNode, int nUsuari){
        Iterator<JsonNode> iterator = rootNode.elements();

        for (int i = 0; iterator.hasNext(); i++) {
            JsonNode node = iterator.next();
            if (nUsuari == i){
                iterator.remove();
            }
        }
    }

    private static void guardarCanvis(ObjectMapper mapper, JsonNode rootNode) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("empleatsCRUD.json"), rootNode);
    }
}
