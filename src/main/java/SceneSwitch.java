import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class SceneSwitch {

    //Title
    public static final String loginTitle = "Login";
    public static final String mainMenuTitle = "Main Menu";
    public static final String createOrderTitle = "Create Order";
    public static final String registerOperatorTitle = "Register Operator";
    public static final String registerCustomerTitle = "Register Customer";
    public static final String taskOverviewTitle = "Task's Overview";



    //Fxml
    public static final String loginFXML = "login.fxml";
    public static final String mainMenuFXML = "mainmenu.fxml";
    public static final String createOrderFXML = "createorder.fxml";
    public static final String registerOperatorFXML = "registeroperator.fxml";
    public static final String registerCustomerFXML = "registercustomer.fxml";
    public static final String taskOverviewFXML = "taskoverview.fxml";




    public static URL getRes(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResource(fileName);
    }

    public static FXMLLoader getLoader(String fxmlpath) {
        return new FXMLLoader(getRes(fxmlpath));
    }


    static void replaceScene(String fxmlPath, String windowTitle, MouseEvent mouseEvent) throws IOException {

        Stage stage = (Stage) ((Node) mouseEvent.getSource())
                .getScene()
                .getWindow();

        FXMLLoader loader = getLoader(fxmlPath);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle(windowTitle);
        stage.show();
        stage.toFront();

    }



}
