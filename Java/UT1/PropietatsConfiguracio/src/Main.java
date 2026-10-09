import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

public class Main {
    static void main() {
        // 1. Implementa el mètode guardar Configuracio
        guardarConfiguracio("aa.txt", "server2", 23, "marc", true, LocalDateTime.now());

        // 2. Implementa el mètode carregarConfiguracio(String arxiu) que faci el següent
        carregarConfiguracio("arxiuProperties.props");

        // 3. Fer guardarPropietatsSistema
        guardarPropietatsSistema("propietatsSistema.prop");
    }

    private static void guardarConfiguracio(String arxiu, String server, int port, String user, boolean debugMode, LocalDateTime lastAccess){
        Properties properties = new Properties();
        properties.setProperty("arxiu", arxiu);
        properties.setProperty("server", server);
        properties.setProperty("port", String.valueOf(port));
        properties.setProperty("user", user);
        properties.setProperty("debugMode", String.valueOf(debugMode));
        properties.setProperty("lastAcess", String.valueOf(lastAccess));

        try (FileOutputStream fos = new FileOutputStream("arxiuProperties.props");){
            properties.store(fos, "Fitxer de configuracio");

        } catch (FileNotFoundException e){
            IO.println(e.getMessage());
        } catch (IOException e){
            IO.println(e.getMessage());
        } catch (Exception e){
            IO.println(e.getMessage());
        }

    }

    private static void carregarConfiguracio(String arxiu){
        Properties configuracio = new Properties();

        try (FileInputStream fis = new FileInputStream(arxiu);){
            configuracio.load(fis);

            String arxiuObtingut = configuracio.getProperty("arxiu");
            IO.println(arxiuObtingut);

            String server = configuracio.getProperty("server");
            IO.println(server);

            int port = Integer.parseInt(configuracio.getProperty("port"));
            IO.println(port);

            String user = configuracio.getProperty("user");
            IO.println(user);

            boolean debugMode = Boolean.parseBoolean(configuracio.getProperty("debugMode"));
            IO.println(debugMode);

            LocalDateTime lastAccess = LocalDateTime.parse(configuracio.getProperty("lastAccess"));
            IO.println(lastAccess);

        } catch (FileNotFoundException e){
            IO.println(e.getMessage());
        } catch (IOException e){
            IO.println(e.getMessage());
        } catch (Exception e){
            IO.println(e.getMessage());
        }
    }

    private static void guardarPropietatsSistema(String arxiu) {
        Properties propietatsSistema = System.getProperties();

        try (FileOutputStream fos = new FileOutputStream(arxiu);){
            propietatsSistema.store(fos, "Fitxer de configuracio");

        } catch (FileNotFoundException e){
            IO.println(e.getMessage());
        } catch (IOException e){
            IO.println(e.getMessage());
        } catch (Exception e){
            IO.println(e.getMessage());
        }
    }
}
