package cat.spaad.tipusstreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class MetodesCharacterStreams {
    public static void llegeixCharacters(String origen) {
        try (FileReader in = new FileReader(origen)) {
            while (in.ready()) {
                char c = (char) in.read();
                IO.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void escriuCharacters(String desti, String dades) {
        try (FileWriter out = new FileWriter(desti)) {
            for (int i = 0; i < dades.length() - 1; i++) {
                out.write(dades.charAt(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}