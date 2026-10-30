import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    static void main() {
        Properties properties = new Properties();

        try (
                FileReader fr = new FileReader("src/main/resources/conexio.conf");
                ){
            properties.load(fr);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=test&password=test", properties);
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet res = st.executeQuery("SELECT ID_AUT, NOM_AUT FROM AUTORS ORDER BY NOM_AUT");
        ){
            res.absolute(5850);

            while(res.relative(2)) {
                IO.println(res.getInt("ID_AUT") + " " + res.getString("NOM_AUT"));
            }
        } catch (SQLException e) {
            IO.println(e.getMessage());
            IO.println(e.getErrorCode());
            IO.println(e.getSQLState());
        }


    }

}
