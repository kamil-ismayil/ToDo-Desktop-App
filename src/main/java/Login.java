import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.*;

public class Login {

    String username, pw;
    Connection con;
    private PreparedStatement getAdmin;

    @FXML
    TextField unInput;

    @FXML
    PasswordField pwInput;



    public void loginButtonClicked (MouseEvent mouseEvent) throws IOException, SQLException {

        username = unInput.getText();
        pw = pwInput.getText();


        if(validateUser(username, pw).next()) {

            System.out.println("Logging into Main Menu");
            SceneSwitch.replaceScene(SceneSwitch.mainMenuFXML, SceneSwitch.mainMenuTitle, mouseEvent);

        } else {

            System.out.println("Unable to login");

        }



    }


    public void closeButtonClicked (){

        System.out.println("Exiting Program");
        System.exit(0);
        Platform.exit();
    }

    public ResultSet validateUser (String username, String pw) throws SQLException {

        con = ConDB.getConnection();
        con.setAutoCommit(false);

        //Fix this later with connection to DB-tables
        getAdmin = con.prepareStatement("SELECT * FROM public.\"Admins\" WHERE \"LastName\" = ? AND \"AdminPassword\" = ?");
        getAdmin.setString(1, username);
        getAdmin.setString(2, pw);
        System.out.println("Query Executed");
        ResultSet rs = getAdmin.executeQuery();
        if( rs.next())
        System.out.println("Ok");
        return getAdmin.executeQuery();


    }




}
