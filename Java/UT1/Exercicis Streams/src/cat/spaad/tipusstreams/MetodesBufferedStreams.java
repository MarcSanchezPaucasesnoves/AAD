package cat.spaad.tipusstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class MetodesBufferedStreams {
    public static void llegeixLinia(String rutaFitxer){
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFitxer));){
            String linia;
            while((linia = br.readLine()) != null){
                IO.println(linia);
            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void escriuLinia(String desti, String[] dades){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(desti))){
            for (int i = 0; i < dades.length; i++) {
                bw.write(dades[i]);
                bw.newLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void inutil(String rutaFitxer){
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFitxer));){
            String linia;
            while((linia = br.readLine()) != null){

            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
