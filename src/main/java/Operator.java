import java.util.List;

public class Operator {

    int operatorID;
    String operatorLastName;
    static List<Operator> operators;


    public int getOperatorID() { return operatorID; }
    public String getOperatorLastName() { return operatorLastName; }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperatorID(int operatorID) { this.operatorID = operatorID; }
    public void setOperatorLastName(String operatorLastName) { this.operatorLastName = operatorLastName; }

    public String toString(){
        return "ID: " + operatorID + " - " + operatorLastName;
    }
}
