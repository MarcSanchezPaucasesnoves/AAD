import java.sql.*;

public class SentenciesPreparades_autors {
    static void main() {
        String actualitzarNomAutor = "UPDATE AUTORS SET NOM_AUT=? WHERE ID_AUT=?";

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "test", "test");
                PreparedStatement noms = con.prepareStatement(actualitzarNomAutor);
                Statement st = con.createStatement();
        ){
            int id = Integer.parseInt(IO.readln("Digues la id de l'usuari a modificar: "));
            String nouNom = IO.readln("Digues el nou nom a aplicar: ");
            noms.setString(1, nouNom);
            noms.setInt(2, id);
            int nFiles = noms.executeUpdate();
            IO.println("Files afectades: " + nFiles);

        } catch (SQLException e) {
            e.printStackTrace();
            IO.println("No connectat a la base de dades!!");
        }
    }
}
