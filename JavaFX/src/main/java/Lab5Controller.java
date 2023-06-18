
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lab5.StreamMethods;

import java.util.*;

public class Lab5Controller {

    @FXML
    public Button buttonLab5StreamAPI;
    public TextField lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    public TextArea resultFX;

    @FXML
    protected void onStartButtonClick() {

        try {
            String array = String.valueOf(lbl1.getText());
            List<Integer> task1 = readINT(array);
            resultFX.setText("TASK1 - Average:\n");
            int result1 = StreamMethods.getAverage(task1);
            resultFX.appendText(String.valueOf(result1 + "\n"));


            String array2 = String.valueOf(lbl2.getText());
            List<String> task2 = readString(array2);
            resultFX.appendText("TASK2 - _new_:\n");
            String result2 = StreamMethods.getNew(task2);
            resultFX.appendText(result2 + "\n");


            String array3 = String.valueOf(lbl3.getText());
            List<Integer> task3 = readINT(array);
            resultFX.appendText("TASK3 - Pow\n");
            List<Integer> result3 = StreamMethods.getPow(task3);
            resultFX.appendText(String.valueOf(result3 + "\n"));


            String array4 = String.valueOf(lbl4.getText());
            List<String> task4 = readString(array4);
            resultFX.appendText("TASK4 - Sort For Alphabet\n");
            String temp = task4.get(0);
            String temp1 = String.valueOf(temp.charAt(0));
            List<String> result4 = StreamMethods.getSortForAlphabet(task4, temp1);
            resultFX.appendText(String.valueOf(result4 + "\n"));


            String array5 = String.valueOf(lbl5.getText());
            List<String> task5 = readString(array5);
            resultFX.appendText("TASK5 - Last Element\n");
            try {
                String result5 = String.valueOf(StreamMethods.getLastElement(task5));
                resultFX.appendText(String.valueOf(result5 + "\n"));
            } catch (
                    NoSuchElementException e) {
                resultFX.appendText("Null");
            }

            String array6 = String.valueOf(lbl6.getText());
            List<Integer> task6 = readINT(array6);
            resultFX.appendText("TASK6 - Even Numbers\n");
            List<Integer> result6 = StreamMethods.getEvenNumbers(task6);
            resultFX.appendText(String.valueOf(result6 + "\n"));


            String array7 = String.valueOf(lbl7.getText());
            List<String> task7 = readString(array7);
            resultFX.appendText("TASK7 - Map\n");
            Map<String, String> result7 = StreamMethods.getMap(task7);
            resultFX.appendText(result7 + " " + "\n");

        } catch (NumberFormatException e) {
            resultFX.setText("There is no list");
        }
    }

    protected List<Integer> readINT(String array) {

        String[] words = array.split("[\s\\p{Punct}]");
        List<String> task = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            task.add(words[i]);
        }
        for (int i = 0; i < task.size(); i++) task.removeIf(n -> (n == " " | n == ""));
        List<Integer> task1 = new ArrayList<Integer>();
        for (int i = 0; i < task.size(); i++) {
            task1.add(Integer.parseInt(task.get(i)));
        }

        return task1;
    }

    protected List<String> readString(String array) {

        String[] words2 = array.split("[\s\\p{Punct}]");
        List<String> task2 = new ArrayList<String>();
        for (int i = 0; i < words2.length; i++) {
            task2.add(words2[i]);
        }
        for (int i = 0; i < task2.size(); i++) task2.removeIf(n -> (n == ""));
        return task2;
    }

    @FXML
    protected void StandVarClick() {

        lbl1.setText("1, 2, 3, 4, 5");
        lbl2.setText("dog, cat, mouse, horse, eagle");
        lbl3.setText("1, 2, 2, 3, 4, 4, 5");
        lbl4.setText("dog, date, desktop, d");
        lbl5.setText("1, 2, 3, 4, 5");
        lbl6.setText("1, 2, 3, 4, 5");
        lbl7.setText("1dog, 2cat, 3mouse, 4horse, 5eagle");
    }

    @FXML
    protected void ClearClick() {
        lbl1.setText("");
        lbl2.setText("");
        lbl3.setText("");
        lbl4.setText("");
        lbl5.setText("");
        lbl6.setText("");
        lbl7.setText("");
    }
}
