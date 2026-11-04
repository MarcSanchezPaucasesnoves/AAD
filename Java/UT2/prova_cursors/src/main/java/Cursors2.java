import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Cursors2 {

    public static void startCursors2(){
        Properties properties = new Properties();

        try (
                FileReader fr = new FileReader("src/main/resources/conexio.conf");
        ){
            properties.load(fr);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/negoci?user=test&password=test", properties);
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet res = st.executeQuery("SELECT CLIENT_COD, NOM, ADRECA, TELEFON FROM CLIENT ORDER BY CLIENT_COD");
        ){

            
        } catch (SQLException e) {
            IO.println(e.getMessage());
            IO.println(e.getErrorCode());
            IO.println(e.getSQLState());
        }
    }
}
