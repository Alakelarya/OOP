
import lab3.Translation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;

public class Lab3Controller {
    @FXML
    public Button buttonLab3Translate;
    public TextField lbl, lbl_dictionary, resultFX;

    @FXML
    protected void onStartButtonClick() {
        String sentence = String.valueOf(lbl.getText());

        String pathDictionary = lbl_dictionary.getText();

        ArrayList<String> sentenceForTranslate;
        HashMap<String, String> dictionary;
        ArrayList<String> translation;
        String result = "";


        sentenceForTranslate = Translation.readSentenceForTranslate(sentence);
        dictionary = Translation.readDictionary(pathDictionary);
        translation = Translation.translateSentence(sentenceForTranslate, dictionary);




        for (int i = 0; i < translation.size(); i++) {
            result += translation.get(i) + " ";
        }
        resultFX.setText(result);
    }

}
