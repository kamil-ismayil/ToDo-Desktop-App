import java.sql.*;


public class ConDB {

    private static Connection con;

    public static Connection getConnection() throws SQLException {

        String db = "jdbc:postgresql://ec2-34-251-118-151.eu-west-1.compute.amazonaws.com:5432/d1s3fkge434rkv";
        String user = "fgwmzdhzngqkcq";
        String pass = "4efd9b17582b1148f35943d8093d808826779b9e996df15436e9aad7b2d378a1";


        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(""+db+"", ""+user+"", ""+pass+"");
            System.out.println("Getting Connection");

        }

        catch(Exception e) {
            e.printStackTrace();
            con.close();
        }

        System.out.println("Connected to DB");
        return con;

    }

}
