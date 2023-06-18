import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LabController {


    @FXML
    protected void onLab1ButtonClick() throws IOException {
        StackPane dialogStack = new StackPane();
        dialogStack.getChildren();
        FXMLLoader loader = new FXMLLoader(LabApplication.class.getResource("lab1.fxml"));
        Parent page = loader.load();
        Scene dialogScene = new Scene(page);
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Lab 1 - Hero");
        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait();

    }

    @FXML
    protected void onLab2ButtonClick() throws IOException {
        StackPane dialogStack = new StackPane();
        dialogStack.getChildren();
        FXMLLoader loader = new FXMLLoader(LabApplication.class.getResource("lab2.fxml"));
        Parent page = loader.load();
        Scene dialogScene = new Scene(page);
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Lab 2 - Matrix");
        dialogStage.setScene(dialogScene);
        dialogStage.show();

    }

    @FXML
    protected void onLab3ButtonClick() throws IOException {
        StackPane dialogStack = new StackPane();
        dialogStack.getChildren();
        FXMLLoader loader = new FXMLLoader(LabApplication.class.getResource("lab3.fxml"));
        Parent page = loader.load();
        Scene dialogScene = new Scene(page);
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Lab 3 - Translator");
        dialogStage.setScene(dialogScene);
        dialogStage.show();
    }

    @FXML
    protected void onLab4ButtonClick() throws IOException {
        StackPane dialogStack = new StackPane();
        dialogStack.getChildren();
        FXMLLoader loader = new FXMLLoader(LabApplication.class.getResource("lab4.fxml"));
        Parent page = loader.load();
        Scene dialogScene = new Scene(page);
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Lab 4 - Annotation");
        dialogStage.setScene(dialogScene);
        dialogStage.show();
    }

    @FXML
    protected void onLab5ButtonClick() throws IOException {
        StackPane dialogStack = new StackPane();
        dialogStack.getChildren();
        FXMLLoader loader = new FXMLLoader(LabApplication.class.getResource("lab5.fxml"));
        Parent page = loader.load();
        Scene dialogScene = new Scene(page);
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Lab 5 - Stream API");
        dialogStage.setScene(dialogScene);
        dialogStage.show();
    }
}