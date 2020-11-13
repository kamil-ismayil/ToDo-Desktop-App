import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MainMenu {

    Connection con;
    PreparedStatement getCustomers, getOperator, getTasks;


    public void placeOrderClicked (MouseEvent mouseEvent) throws IOException, SQLException {

        ResultSet customerRS = getCustomers();
        ResultSet operatorRS = getOperators();
        Customer.customers = new ArrayList<>();
        Operator.operators = new ArrayList<>();


      if(customerRS.next() && operatorRS.next()) {
          while (customerRS.next()) {

              populateCustomerList(customerRS);

          }
          while (operatorRS.next()) {

              populateOperatorList(operatorRS);
          }



          System.out.println("Going to Create Order");
          SceneSwitch.replaceScene(SceneSwitch.createOrderFXML, SceneSwitch.createOrderTitle, mouseEvent);

     }

      else {
          System.out.println("No available info");
      }



    }

    public void registerEmployeeClicked (MouseEvent mouseEvent) throws IOException{

        System.out.println("Going to Create Operator");
        SceneSwitch.replaceScene(SceneSwitch.registerOperatorFXML, SceneSwitch.registerOperatorTitle, mouseEvent);
    }

    public void registerCustomerClicked (MouseEvent mouseEvent) throws IOException {

        System.out.println("Going to Create Customer");
        SceneSwitch.replaceScene(SceneSwitch.registerCustomerFXML, SceneSwitch.registerCustomerTitle, mouseEvent);

    }

    public void logOutButtonClicked (MouseEvent mouseEvent) throws IOException {

        System.out.println("Logging out");
        SceneSwitch.replaceScene(SceneSwitch.loginFXML, SceneSwitch.loginTitle, mouseEvent);

    }

    public void taskButton (MouseEvent mouseEvent) throws IOException, SQLException {

        ResultSet rs = getDBTasks();
        Task.tasks = new ArrayList<>();

        if(rs.next()) {


            while (rs.next()) {

                populateTaskList(rs);

            }

        }

        System.out.println("Task overview");
        SceneSwitch.replaceScene(SceneSwitch.taskOverviewFXML, SceneSwitch. taskOverviewTitle, mouseEvent);
    }



    public void populateCustomerList(ResultSet resultSet) throws SQLException {

        Customer customer = new Customer();
        customer.setName(resultSet.getString("FirstName"));
        customer.setCustomerID(resultSet.getInt("CustomerID"));
        Customer.customers.add(customer);
        System.out.println(customer.getCustomerID() + " " + customer.getName() + " added to CustomerList");


    }

    public void populateOperatorList(ResultSet resultSet) throws SQLException {

        Operator operator = new Operator();
        operator.setOperatorID(resultSet.getInt("OperatorID"));
        operator.setOperatorLastName(resultSet.getString("LastName"));
        Operator.operators.add(operator);
        System.out.println(operator.getOperatorID() + " " + operator.getOperatorLastName() + " added to OperatorList");

    }

    public void populateTaskList(ResultSet resultset) throws SQLException{

        Task task = new Task();
        task.setCustomerID(resultset.getInt("CustomerID"));
        task.setOperatorID(resultset.getInt("OperatorID"));
        task.setDescription(resultset.getString("Description"));
        task.setStatus(resultset.getString("Status"));
        task.setStartDate(resultset.getDate("Startdate"));

        Task.tasks.add(task);
        System.out.println(task + "added to TaskList");

    }


    public ResultSet getCustomers() throws SQLException {

        con = ConDB.getConnection();
        con.setAutoCommit(false);

        getCustomers = con.prepareStatement("SELECT * FROM public.\"Customer\"");
        System.out.println("Customers received");
        return getCustomers.executeQuery();

    }

    public ResultSet getOperators() throws SQLException {

        con = ConDB.getConnection();
        con.setAutoCommit(false);

        getOperator = con.prepareStatement("SELECT * From public.\"Operator\"");
        System.out.println("Available Operators received");
        return getOperator.executeQuery();


    }

    public ResultSet getDBTasks() throws SQLException {

        con = ConDB.getConnection();
        con.setAutoCommit(false);

        getTasks = con.prepareStatement("SELECT * FROM public.\"Task\"");
        System.out.println("Task received");
        return getTasks.executeQuery();

    }

}
