import java.sql.*;

public class Mostra_autors {
    static void main() {
        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "test", "test");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM AUTORS");
                ){

            while(rs.next() ) {
                int codi = rs.getInt("ID_AUT");
                String nom = rs.getString("NOM_AUT");
                IO.println("Codi: " + codi + " Nom: " + nom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            IO.println("No connectat a la base de dades!!");
        }



    }
}
