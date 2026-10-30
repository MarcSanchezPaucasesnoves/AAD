import java.sql.*;

public class Transaccions_autors {
    // EXERCICI NO ACABAT
    try (
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "test", "test");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM AUTORS");
                ){


    } catch (SQLException e) {
        e.printStackTrace();
        IO.println("No connectat a la base de dades!!");
    }
}
