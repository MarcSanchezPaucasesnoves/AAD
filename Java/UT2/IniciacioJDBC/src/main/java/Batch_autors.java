import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_autors {
    public static void main(String[] args) {
        Connection con = null;
        Statement sentencia = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "test", "test");;
            sentencia = con.createStatement();

            sentencia.addBatch("INSERT INTO autors (ID_AUT, NOM_AUT, DNAIX_AUT, FK_NACIONALITAT) VALUES (1000, 'Jaume Ximenes', '1997-11-21', 'IRLANDESA')");
            sentencia.addBatch("INSERT INTO autors (ID_AUT, NOM_AUT, DNAIX_AUT, FK_NACIONALITAT) VALUES (1001, 'Antoni Villalonga', '1980-06-30', 'CATALANA')");
            sentencia.addBatch("INSERT INTO autors (ID_AUT, NOM_AUT, DNAIX_AUT, FK_NACIONALITAT) VALUES (1002, 'Mary Smith', '1989-02-05', 'ANGLESA')");

            int[] resultatsInserir = sentencia.executeBatch();
            System.out.println("S'han inserit en bloc " + resultatsInserir.length + " autors!");

            sentencia.addBatch("DELETE FROM autors WHERE ID_AUT = 1000");
            sentencia.addBatch("DELETE FROM autors WHERE ID_AUT = 1001");
            sentencia.addBatch("DELETE FROM autors WHERE ID_AUT = 1002");

            int[] resultatsEsborrar = sentencia.executeBatch();
            System.out.println("S'han esborrat en bloc " + resultatsEsborrar.length + " autors!");

        } catch (SQLException e) {
            System.out.println("NO CONNECTA!");
            e.printStackTrace();
        } finally {
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

