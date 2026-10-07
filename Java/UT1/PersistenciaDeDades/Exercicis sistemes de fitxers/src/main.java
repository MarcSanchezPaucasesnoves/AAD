import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class main {
    public static void main() {
        try {
            IO.println("Construeix un path a partir d'un String i mostra tota la informació possible d'aquest path per consola");
            Path ruta = Path.of("/Users/alumne");
            System.out.println(ruta);
            System.out.println("És una ruta absoluta: " + ruta.isAbsolute());
            System.out.println("Nombre d'elements: " + ruta.getNameCount());
            System.out.println("Ruta pare: " + ruta.getParent());
            System.out.println("No directori/arxiu: " + ruta.getFileName());

            IO.println();
            IO.println("Utilitza la classe Files per mostrar per consola tota la informació sobre un arxiu o directori del vostre sistema.");
            IO.println("File system: " + ruta.getFileSystem());
            IO.println("Nom: " + ruta.getFileName());
            IO.println("És un arxiu regular: " + Files.isRegularFile(ruta));
            IO.println("És un directori: " + Files.isDirectory(ruta));
            IO.println("És llegible: " + Files.isReadable(ruta));
            IO.println("Es pot escriure: " + Files.isWritable(ruta));
            IO.println("És executable: " + Files.isExecutable(ruta));
            IO.println("Tamany: " + Files.size(ruta));
            IO.println("Està ocult: " + Files.isHidden(ruta));

            IO.println();
            IO.println("Copia un fitxer entre dos directoris");
            Path fitxerA = Path.of("/Users/alumne/Downloads/a/hola.txt");
            Path directoriFitxerBA = Path.of("/Users/alumne/Downloads/b/hola.txt");
            // Files.copy(fitxerA, directoriFitxerBA, StandardCopyOption.REPLACE_EXISTING);

            IO.println();
            IO.println("Mou un fitxer a un altre directori");
            Path fitxerB = Path.of("/Users/alumne/Downloads/a/adios.txt");
            Path directoriFitxerBB = Path.of("/Users/alumne/Downloads/b/adios.txt");
            // Files.move(fitxerB, directoriFitxerBB, StandardCopyOption.REPLACE_EXISTING);

            IO.println();
            IO.println("Copia un directori sencer (només els arxius).");
            Path directoriB = Path.of("/Users/alumne/Downloads/b/");
            Path directoriC = Path.of("/Users/alumne/Downloads/c/");
            

            IO.println();
            IO.println("Mostra per consola el contingut d'un directori, inclosos els seus subdirectoris i els seus continguts.");

        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
        }


    }
}
