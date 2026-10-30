import java.sql.*;

public class Modifica_autors {
    static void main() {
        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "test", "test");
                Statement st = con.createStatement();

        ){
            int filesAfectadesInsert = st.executeUpdate("INSERT INTO AUTORS (ID_AUT, NOM_AUT, DNAIX_AUT, FK_NACIONALITAT) VALUES(1139, 'Olívia Riutort', '2007-10-01', 'POLACA')");
            IO.println("Files afectades al afegir un autor: " + filesAfectadesInsert);
            int filesAfectadesUpdate = st.executeUpdate("UPDATE AUTORS SET NOM_AUT = 'Arnau Codina' WHERE ID_AUT = 1139");
            IO.println("Files afectades al actualitzar un autor: " + filesAfectadesUpdate);
            int filesAfectadesDelete = st.executeUpdate("DELETE FROM AUTORS WHERE ID_AUT = 1139");
            IO.println("Files afectades al eliminar un autor: " + filesAfectadesUpdate);

        } catch (SQLException e) {
            e.printStackTrace();
            IO.println("No connectat a la base de dades!!");
        }
    }
}
