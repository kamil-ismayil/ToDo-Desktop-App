import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;


public class TaskOverview {



    ObservableList<Task> taskOL = FXCollections.observableArrayList(Task.tasks);


    @FXML
    TableView<Task> TV;

    @FXML
    TableColumn<Task, Integer> customerTab;

    @FXML
    TableColumn<Task, Integer> operatorTab;

    @FXML
    TableColumn<Task, String> descriptionTab;

    @FXML
    TableColumn<Task, String> statusTab;
    @FXML
    TableColumn<Task, Date> dateTab;



    @FXML
    public void initialize() throws SQLException {


        customerTab.setCellValueFactory(new PropertyValueFactory<Task, Integer>("customerID"));
        operatorTab.setCellValueFactory(new PropertyValueFactory<Task, Integer>("operatorID"));
        descriptionTab.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
        statusTab.setCellValueFactory(new PropertyValueFactory<Task, String>("status"));
        dateTab.setCellValueFactory(new PropertyValueFactory<Task, Date>("startDate"));

        TV.setItems(taskOL);



    }





    public void goBackButtonClicked(MouseEvent mouseEvent) throws IOException {

        System.out.println("Going back to Main Menu");
        SceneSwitch.replaceScene(SceneSwitch.mainMenuFXML, SceneSwitch.mainMenuTitle, mouseEvent);

    }


}
