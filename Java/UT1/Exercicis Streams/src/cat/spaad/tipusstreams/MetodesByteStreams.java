package cat.spaad.tipusstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MetodesByteStreams {
    public static void llegeixBytes(String origen) throws IOException {
        try (FileInputStream in = new FileInputStream(origen)){
            int c;
            while((c = in.read()) != -1){
                IO.println((char) c);
            }
        }
    }


    public static void escriuBytes(String desti, byte[] dades) throws IOException{
        try (FileOutputStream out = new FileOutputStream(desti)){
            for (byte b : dades){
                out.write((byte) b);
            }
        }
    }
}
