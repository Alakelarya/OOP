
import lab2.AgTooLarge;
import lab2.ArrayMethods;
import lab2.FileNotFound;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab2Controller {

    @FXML
    public Button buttonLab2OK;
    public TextField lbl;
    public TextArea resultFX;


    @FXML
    protected void onStartButtonClick() {

        Logger logger = Logger.getLogger("Logger");

        try {

            int size = 0;

            size = getSizeArray();

            String result;

            double array[][] =new double[size][size];

            resultFX.setText("Array:" + "\n");
            ArrayMethods.randomArray(array);
            result = ArrayMethods.print(array);
            resultFX.appendText(result + "\n");


            double arrayRotate[][] = new double[size][size];

            arrayRotate = ArrayMethods.rotate(array);

            resultFX.appendText("Rotate 90:" + "\n");
            ArrayMethods.print(arrayRotate);
            resultFX.appendText(result + "\n");
            resultFX.appendText("Division 90:" + "\n");
            ArrayMethods.divSum(arrayRotate);
            ArrayMethods.print(arrayRotate);
            result = ArrayMethods.print(arrayRotate);
            resultFX.appendText(result + "\n");
            resultFX.appendText("Rotate 180:" + "\n");
            ArrayMethods.print(arrayRotate);
            result = ArrayMethods.print(arrayRotate);
            resultFX.appendText(result + "\n");
            resultFX.appendText("Division 180:" + "\n");
            ArrayMethods.divSum(arrayRotate);
            ArrayMethods.print(arrayRotate);
            result = ArrayMethods.print(arrayRotate);
            resultFX.appendText(result + "\n");
            resultFX.appendText("Rotate 270:" + "\n");
            ArrayMethods.print(arrayRotate);
            resultFX.appendText(result + "\n");
            resultFX.appendText("Division 270:" + "\n");
            ArrayMethods.divSum(arrayRotate);
            result = ArrayMethods.print(arrayRotate);
            resultFX.appendText(result + "\n");
        } catch (OutOfMemoryError e) {
            logger.log(Level.SEVERE, "Out of Memory");
            resultFX.setText("Can't create. Try again");
        }


    }
    protected int getSizeArray(){
        String path= lbl.getText();
        int size =0;

        File file = new File(path);
        if(!file.canRead() || !file.exists()){
            throw new FileNotFound();
        }

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
            }
            if (size > 1000000 || size < 2) {
                throw new AgTooLarge();
            }

        } catch (IOException | AgTooLarge | FileNotFound e) {
            resultFX.setText("Can't create. Try again");
        }
        return size;
    }


}
