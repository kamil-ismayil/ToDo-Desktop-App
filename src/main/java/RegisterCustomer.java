import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.*;

public class RegisterCustomer {


    @FXML
    TextField customerName, customerAddress, customerEmail, customerPhone;


    private PreparedStatement createCustomer;
    private Connection con = null;

    public void addCustomer(MouseEvent mouseEvent) throws SQLException {
        con = ConDB.getConnection();
        con.setAutoCommit(false);

        String cName = customerName.getText();
        String cAdress = customerAddress.getText();
        String cEmail = customerEmail.getText();
        String cPhone = customerPhone.getText();


        try {
            createCustomer = con.prepareStatement("INSERT INTO \"Customer\"(\"FirstName\", \"Adress\", \"Email\", \"Phone\") values(?, ?, ?, ?);");

            createCustomer.setString(1, cName);
            createCustomer.setString(2, cAdress);
            createCustomer.setString(3, cEmail);
            createCustomer.setString(4, cPhone);

            createCustomer.executeUpdate();
            con.commit();
            createCustomer.close();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void goBackButton(MouseEvent mouseEvent) throws IOException {

        System.out.println("Going back to Main Menu");
        SceneSwitch.replaceScene(SceneSwitch.mainMenuFXML, SceneSwitch.mainMenuTitle, mouseEvent);

    }
}
