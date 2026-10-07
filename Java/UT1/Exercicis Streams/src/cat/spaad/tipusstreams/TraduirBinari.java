package cat.spaad.tipusstreams;

import java.io.*;

public class TraduirBinari {
    public static void imprimirBinariAString(String ruta){
        int nombre = 0;
        try (DataInputStream texte = new DataInputStream(new BufferedInputStream(new FileInputStream(ruta)))){

            while(true) {
                nombre += texte.readInt();
            }
        } catch (EOFException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            IO.println(nombre);
        }
    }
}
