package cat.spaad.iniciacio;

import cat.spaad.auxiliar.Cronometre;
import cat.spaad.tipusstreams.*;

import java.io.IOException;
import java.nio.file.Path;

public class IniciacioStreams {

    public static void provesByte(){
        try {
            // MetodesByteStreams.llegeixBytes("Himne dels pirates UTF-8.txt");


            byte[] arr = {72,111,108,97,32,114,97,100,105,111,108,97,33,33,33};
            MetodesByteStreams.escriuBytes("generat.txt", arr);
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void provesCharacter(){
        MetodesCharacterStreams.llegeixCharacters("generat.txt");
    }

    public static void provesBuffered(){
        MetodesBufferedStreams.llegeixLinia("generat.txt");
    }

    public static void provesData(){
        // MetodesDataStreams.escriuArray(ruta);
        // MetodesDataStreams.llegeixArray(ruta);

    }
    public static void provesComparacions(){
        IO.println("Llegint amb CharacterStreams:");
        Cronometre crono = new Cronometre();
        crono.inicia();
        MetodesCharacterStreams.inutil("Shakespeare.txt");
        crono.atura();
        IO.println(crono.mostra());
        crono.inicia();
        IO.println("Llegint amb BufferedStreams:");
        crono.inicia();
        MetodesBufferedStreams.inutil("Shakespeare.txt");
        crono.atura();
        IO.println(crono.mostra());
    }

    public static void main() {
        // provesByte();
        // provesCharacter();
        // provesBuffered();
        // provesData();
        // TraduirBinari.imprimirBinariAString("numeros.dat");
        provesComparacions();
    }

}
