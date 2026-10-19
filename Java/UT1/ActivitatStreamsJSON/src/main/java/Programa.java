import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Programa {

    public static List<City> guardarCiutatsPojoEnArray(File arxiuCiutats){
        List<City> ciutats = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(new FileReader(arxiuCiutats));
                ){
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dades = linia.split(";");
                City ciutat = new City(
                        Integer.parseInt(dades[0]),
                        dades[1],
                        dades[2],
                        dades[3],
                        Integer.parseInt(dades[4])
                );
                ciutats.add(ciutat);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            return ciutats;
        }
    }

    public static void generarArxiuCiutats(File jsonCiutats, List<City> arrayCiutats){
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode rootNode = mapper.createObjectNode();

        ArrayNode arrayNode = mapper.createArrayNode();

        int recompteCiutats = 0;

        for (City ciutat : arrayCiutats){
            recompteCiutats++;
            rootNode.put("recompte", recompteCiutats);

            ObjectNode ciutatNode = mapper.createObjectNode();

            ciutatNode.put("id", ciutat.getIdentificador());
            ciutatNode.put("pais", ciutat.getPais());
            ciutatNode.put("nom", ciutat.getCiutat());
            ciutatNode.put("districte", ciutat.getDistricte());
            ciutatNode.put("poblacio", ciutat.getPoblacio());

            arrayNode.add(ciutatNode);
        }
        rootNode.put("ciutats", arrayNode);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonCiutats, rootNode);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void generarArxiuPaisos(File jsonPaisos, List<City> arrayCiutats){
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode rootNode = mapper.createObjectNode();

        ArrayNode arrayNodePaisos = mapper.createArrayNode();

        HashSet<String> paisos = new HashSet<>();

        for (City ciutat : arrayCiutats){
            paisos.add(ciutat.getPais());
        }

        rootNode.put("recompte", paisos.size());

        for (String pais : paisos){
            ObjectNode paisNode = mapper.createObjectNode();
            ArrayNode arrayNodeCiutats = mapper.createArrayNode();

            paisNode.put("nom", pais);

            for (City ciutat : arrayCiutats){
                if (ciutat.getPais().equals(pais)) {

                    ObjectNode ciutatNode = mapper.createObjectNode();
                    ciutatNode.put("id", ciutat.getIdentificador());
                    ciutatNode.put("nom", ciutat.getCiutat());
                    ciutatNode.put("districte", ciutat.getDistricte());
                    ciutatNode.put("poblacio", ciutat.getPoblacio());

                    arrayNodeCiutats.add(ciutatNode);
                }
            }

            paisNode.put("ciutats", arrayNodeCiutats);
            arrayNodePaisos.add(paisNode);
        }

        rootNode.put("paisos", arrayNodePaisos);

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonPaisos, rootNode);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void generarPaisosLlistaCiutats(File jsonPaisosLlistaCiutats, List<City> arrayCiutats){
        ObjectMapper mapper = new ObjectMapper();

        ArrayNode rootNode = mapper.createArrayNode();

        HashSet<String> paisos = new HashSet<>();

        for (City ciutat : arrayCiutats){
            paisos.add(ciutat.getPais());
        }


        for (String pais : paisos){
            int poblacio = 0;
            ObjectNode paisNode = mapper.createObjectNode();
            paisNode.put("nom", pais);

            ArrayNode arrayNodeCiutats = mapper.createArrayNode();

            for (City ciutat : arrayCiutats){

                if(pais.equals(ciutat.getPais())){
                    poblacio += ciutat.getPoblacio();
                    arrayNodeCiutats.add(ciutat.getCiutat());
                }

            }

            paisNode.put("ciutats", arrayNodeCiutats);
            paisNode.put("poblacio", poblacio);
            rootNode.add(paisNode);
        }

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonPaisosLlistaCiutats, rootNode);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
