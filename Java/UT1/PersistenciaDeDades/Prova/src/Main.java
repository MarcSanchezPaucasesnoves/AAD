import java.nio.file.Path;

class main {
    static void main(){

        Path ruta = Path.of("/Users/alumne");
        System.out.println(ruta);
        System.out.println("És una ruta absoluta: " + ruta.isAbsolute());
        System.out.println("Nombre d'elements: " + ruta.getNameCount());
        System.out.println("Ruta pare: " + ruta.getParent());
        System.out.println("No directori/arxiu: " + ruta.getFileName());
    }
}