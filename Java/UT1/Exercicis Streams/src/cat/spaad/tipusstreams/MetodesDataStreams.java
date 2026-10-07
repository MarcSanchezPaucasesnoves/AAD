package cat.spaad.tipusstreams;

import java.io.*;

public class MetodesDataStreams {
    public static void escriuArray(String desti, double[] dades){
        try (DataOutputStream data = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(desti)));){
            data.writeInt(dades.length);
            for (double d : dades){
                data.writeDouble(d);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static double[] llegeixArray(String origen) throws IOException{
        try (DataInputStream data = new DataInputStream(new FileInputStream(origen))){
            int numLinies = data.readInt();
            double[] dades = new double[numLinies];
            for (int i = 0; i < numLinies; i++) {
                dades[i] = data.readDouble();
                System.out.println(dades[i]);
            }
            return dades;
        }
    }


}
