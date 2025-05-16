package Frontend;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    double colourscaling = 0;

   @FXML Button button1;
   @FXML Button button2;
   @FXML Button button3;
   @FXML Button button4;
   @FXML Button button5;
   @FXML Button button6;
   @FXML Button button7;
   @FXML Button button8;
   @FXML Button button9;
   @FXML Button button0;
   @FXML Button buttonPlus;
   @FXML Button buttonMinus;
   @FXML Button buttonMultiply;
   @FXML Button buttonDivide;
   @FXML Button buttonPercent;
   @FXML Button buttonEquals;
   @FXML Button buttonClear;
   @FXML Button buttonPower;
   @FXML Button buttonSqrt;
   @FXML Button buttonSin;
   @FXML Button buttonCos;
   @FXML Button buttonTan;
   @FXML Button buttonCosInv;
   @FXML Button buttonTanInv;
   @FXML Button buttonSinInv;
   @FXML Button buttonE;
   @FXML Button buttonAbs;
   @FXML Button buttonLN;
   @FXML Button buttonLeftBracket;
   @FXML Button buttonRightBracket;
   @FXML Button buttonBackspace;
   @FXML Button buttonDecimalPoint;

    // Main AnchorPane
    @FXML
    protected AnchorPane FullPane;


    Timeline timeline;
    String baseStyle = " -fx-background-color: #161a33;" +
            "    -fx-text-fill: white;" +
            "    -fx-background-radius: 32;";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupAnimation(button1);
        setupAnimation(button2);
        setupAnimation(button3);
        setupAnimation(button4);
        setupAnimation(button5);
        setupAnimation(button6);
        setupAnimation(button7);
        setupAnimation(button8);
        setupAnimation(button9);
        setupAnimation(button0);
        setupAnimation(buttonPlus);
        setupAnimation(buttonMinus);
        setupAnimation(buttonMultiply);
        setupAnimation(buttonDivide);
        setupAnimation(buttonPercent);
        setupAnimation(buttonEquals);
        setupAnimation(buttonClear);
        setupAnimation(buttonPower);
        setupAnimation(buttonSqrt);
        setupAnimation(buttonSin);
        setupAnimation(buttonCos);
        setupAnimation(buttonTan);
        setupAnimation(buttonCosInv);
        setupAnimation(buttonTanInv);
        setupAnimation(buttonSinInv);
        setupAnimation(buttonE);
        setupAnimation(buttonAbs);
        setupAnimation(buttonLN);
        setupAnimation(buttonLeftBracket);
        setupAnimation(buttonRightBracket);
        setupAnimation(buttonBackspace);
        setupAnimation(buttonDecimalPoint);
        setupAnimation(buttonEquals);
    }

    public void setupAnimation(Button button) {

        if (button == button0 || button == button1 || button == button2 || button == button3 || button == button4 || button == button5 || button == button6 || button == button7
            || button == button8 || button == button9 || button == button0 || button == buttonDecimalPoint) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(8), e -> updateNumberButtonStyle(button))
            );
            timeline.setCycleCount(Timeline.INDEFINITE);

            button.setOnMouseEntered(e -> timeline.play());
            button.setOnMouseExited(e -> {
                colourscaling = 0;
                timeline.stop();
                button.setStyle("");
            });
        }
        else if (button == buttonPlus || button == buttonMinus || button == buttonMultiply || button == buttonDivide
            || button == buttonPercent || button == buttonEquals || button == buttonCos || button == buttonTan || button == buttonCosInv || button == buttonTanInv
            || button == buttonSin || button == buttonSinInv || button == buttonE || button == buttonAbs || button == buttonLN || button == buttonLeftBracket
            || button == buttonRightBracket || button == buttonSqrt || button == buttonPower) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(8), e -> updateOtherButtonStyle(button))
            );
            timeline.setCycleCount(Timeline.INDEFINITE);

            button.setOnMouseEntered(e -> timeline.play());
            button.setOnMouseExited(e -> {
                colourscaling = 0;
                timeline.stop();
                button.setStyle("");
            });
        }
        else if (button == buttonClear || button == buttonBackspace) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(8), e -> updateExitButtonStyle(button))
            );
            timeline.setCycleCount(Timeline.INDEFINITE);

            button.setOnMouseEntered(e -> timeline.play());
            button.setOnMouseExited(e -> {
                colourscaling = 0;
                timeline.stop();
                button.setStyle("");
            });
        }

    }
    private void updateNumberButtonStyle(Button button) {
        // Your existing scaling logic
        if (colourscaling > 94) {
            colourscaling+= 0.465;
        }
        else if (colourscaling < 1.1) {
            colourscaling += 0.265;
        } else if (colourscaling < 5) {
            colourscaling += 0.465;
        } else {
            colourscaling+=2;
        }

        button.setStyle("-fx-background-radius: 32; " +
                "  -fx-background-color: linear-gradient(to top right, #083054 "+colourscaling+"%, transparent 0%);" +
                " -fx-text-fill: linear-gradient(to right, white "+colourscaling+"%, transparent 0%);");
    }


    private void updateOtherButtonStyle(Button button) {
        // Your existing scaling logic
        if (colourscaling > 94) {
            colourscaling+= 0.465;
        }
        else if (colourscaling < 1.1) {
            colourscaling += 0.265;
        } else if (colourscaling < 5) {
            colourscaling += 0.465;
        } else {
            colourscaling+=2;
        }

        button.setStyle("-fx-background-radius: 32; " +
                "  -fx-background-color: linear-gradient(to top right, #e531c4 "+colourscaling+"%, transparent 0%);" +
                " -fx-text-fill: linear-gradient(to right, black "+colourscaling+"%, transparent 0%);");
    }

    private void updateExitButtonStyle(Button button) {
        // Your existing scaling logic
        if (colourscaling > 94) {
            colourscaling+= 0.465;
        }
        else if (colourscaling < 1.1) {
            colourscaling += 0.265;
        } else if (colourscaling < 5) {
            colourscaling += 0.465;
        } else {
            colourscaling+=2;
        }

        button.setStyle("-fx-background-radius: 32; " +
                "  -fx-background-color: linear-gradient(to top right, #9b2915 "+colourscaling+"%, transparent 0%);" +
                " -fx-text-fill: linear-gradient(to right, white "+colourscaling+"%, transparent 0%);");
    }


    @FXML
    protected AnchorPane OptionsPane;
    @FXML
    protected GridPane gridPane;



    @FXML
    protected void loadOptions(ActionEvent event) {
//        OptionsPane.setVisible(true);
//        OptionsPane.translateYProperty().set(FullPane.getHeight());
//
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(OptionsPane.translateYProperty(), 0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
//        timeline.getKeyFrames().add(kf);
        System.out.println("hello world");
        gridPane.setOpacity(0.5); // REMEMBER TO SET IT BACK WHEN CALCULATING AGAIN

    }


}


