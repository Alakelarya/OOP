
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static lab1.CallLab1.callLab1;


public class Lab1Controller {
    @FXML
    public TextField lbl, resultFX;
    @FXML
    public Button buttonLab1Start;

    @FXML
    protected void onStartButtonClick(){

        int choice = 1;
        String result;

        try {
            choice = Integer.parseInt(String.valueOf(lbl.getText()));
            result = callLab1(choice);
        }
        catch(RuntimeException e){
            result = "Hero stands still";
        }
        resultFX.setText(result + "\n");



    }
}


