
import lab4.Annotation;
import lab4.MethodsForCalculation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Lab4Controller {
    @FXML
    public Button buttonLab4Annotation;
    public TextArea resultFX;

    @FXML
    protected void onStartButtonClick() {
        resultFX.setWrapText(true);
        resultFX.setText("Annotation:");

        MethodsForCalculation example = new MethodsForCalculation(5);

        for (Method method : MethodsForCalculation.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Annotation.class) ) {
                Annotation callMethods = method.getAnnotation(Annotation.class);
                method.setAccessible(true);
                for (int i = 0; i < callMethods.value(); i++) {
                    try {
                        if(Modifier.isPublic(method.getModifiers())){
                            continue;
                        }
                        String result = (String) method.invoke(example, example);
                        resultFX.appendText("\n" + result);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}