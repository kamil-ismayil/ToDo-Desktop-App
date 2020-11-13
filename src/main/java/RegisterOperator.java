import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.*;


public class RegisterOperator {

    @FXML
    TextField operatorName;

    @FXML
    TextField operatorLastName;

    @FXML
    TextField operatorPassword;

    @FXML
    TextField operatorUsername;

  private PreparedStatement createOperator;
    Connection con;

    public void addOperator(MouseEvent mouseEvent) throws SQLException {
        con = ConDB.getConnection();
        con.setAutoCommit(false);


        String oName = operatorName.getText();
        String oLastName = operatorLastName.getText();
        String oPassword = operatorPassword.getText();
        String oUsername = operatorUsername.getText();

        try {
            createOperator = con.prepareStatement("INSERT INTO public.\"Operator\"\n" +
                    "(\"FirstName\", \"LastName\", \"OperatorPassword\", \"Username\")\n" +
                    "VALUES(?, ?, ?, ?);");


            createOperator.setString(1, oName);
            createOperator.setString(2, oLastName);
            createOperator.setString(3, oPassword);
            createOperator.setString(4, oUsername);
            createOperator.executeUpdate();
            con.commit();
            createOperator.close();
        }catch (SQLException E) {

        }

    }
    public void goBackButtonClicked(MouseEvent mouseEvent) throws IOException {

        System.out.println("Going back to Main Menu");
        SceneSwitch.replaceScene(SceneSwitch.mainMenuFXML, SceneSwitch.mainMenuTitle, mouseEvent);

    }

}
