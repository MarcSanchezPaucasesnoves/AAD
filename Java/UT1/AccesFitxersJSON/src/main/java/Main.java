public class Main {
    static void main(){
        try {
            Lectura.llegirJSON();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
