import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class MySQL{
    private static Connection con = null;
    private static String dbHost = "ni126463_1.vweb09.nitrado.net"; // Hostname
    private static String dbPort = "3306";      // Port -- Standard: 3306
    private static String dbName = "ni126463_1sql1";   // Datenbankname
    private static String dbUser = "ni126463_1sql1";     // Datenbankuser
    private static String dbPass = "01032015";      // Datenbankpasswort
    private int übertragung;
    private String[] übertragungN;
    private String[] übertragungN2;

    public MySQL(){
        //System.out.println('\u000C');
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.

            // Verbindung zur JDBC-Datenbank herstellen.
            con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"?"+"user="+dbUser+"&"+"password="+dbPass);

        } catch (ClassNotFoundException e) {
            System.out.println("Treiber nicht gefunden");
        } catch (SQLException e) {
            System.out.println("Verbindung nicht moglich");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    private static Connection getInstance(){
        if(con == null) {
            new MySQL();
        }
        return con;
    }

    public int loginCheck(String nameA, String pwA)
    {
        //System.out.println('\u000C');
        con = getInstance();

        if(con != null){
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = con.createStatement();

                // Daten laden
                String sql =
                    "SELECT * FROM login WHERE Name='"+nameA+"' AND Passwort='"+pwA+"'";

                ResultSet result = query.executeQuery(sql);
                if(!result.next()) 
                {
                    //System.out.println("Falscher Name oder falsches Passwort!");
                    übertragung = 00;
                }
                else
                {
                    String name = result.getString("Name");
                    String pw = result.getString("Passwort");
                    int admin = result.getInt("Admin");    

                    if(admin==1) übertragung=11;
                    else übertragung=10;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return übertragung;
    }

    public String[] gebeNamen(String name)
    {
        //System.out.println('\u000C');
        con = getInstance();
        übertragungN = new String[100];

        if(con != null){
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = con.createStatement();

                // Daten laden
                String sql =
                    "SELECT * FROM login WHERE Name!='"+name+"'";

                ResultSet result = query.executeQuery(sql);
                
                int i=0;
                
                while(result.next())
                {
                    übertragungN[i] = result.getString("Name");  
                    i++;
                }
                übertragungN2 = java.util.Arrays.copyOfRange(übertragungN, 0, i);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return übertragungN2;
    }

    //Gebe Tabelle in die Konsole aus
    public void printNameList(){
        con = getInstance();

        if(con != null){
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = con.createStatement();

                // Tabelle anzeigen
                String sql =
                    "SELECT * FROM login";
                ResultSet result = query.executeQuery(sql);

                // Ergebnisstabelle durchforsten
                while (result.next()) {
                    String name = result.getString("Name");
                    String pw = result.getString("Passwort");
                    int admin = result.getInt("Admin");     
                    String info = name + ", " + pw + ", " + admin;

                    System.out.println(info);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
