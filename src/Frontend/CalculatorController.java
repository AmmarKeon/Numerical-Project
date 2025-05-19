package Frontend;

import Backend.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    double colourscaling = 0;

//   @FXML Button button1;
//   @FXML Button button2;
//   @FXML Button button3;
//   @FXML Button button4;
//   @FXML Button button5;
//   @FXML Button button6;
//   @FXML Button button7;
//   @FXML Button button8;
//   @FXML Button button9;
//   @FXML Button button0;
//   @FXML Button buttonPlus;
//   @FXML Button buttonMinus;
//   @FXML Button buttonMultiply;
//   @FXML Button buttonDivide;
//   @FXML Button buttonPercent;
//   @FXML Button buttonEquals;
//   @FXML Button buttonClear;
//   @FXML Button buttonPower;
//   @FXML Button buttonSqrt;
//   @FXML Button buttonSin;
//   @FXML Button buttonCos;
//   @FXML Button buttonTan;
//   @FXML Button buttonCosInv;
//   @FXML Button buttonTanInv;
//   @FXML Button buttonSinInv;
//   @FXML Button buttonE;
//   @FXML Button buttonAbs;
//   @FXML Button buttonLN;
//   @FXML Button buttonLeftBracket;
//   @FXML Button buttonRightBracket;
//   @FXML Button buttonBackspace;
//   @FXML Button buttonDecimalPoint;





    @FXML
    private AnchorPane BisectionPane;

    @FXML
    private AnchorPane DiffPane;

    @FXML
    private AnchorPane FalsePositionPane;

    @FXML
    private Button FixedPointBTN1;

    @FXML
    private Button FixedPointBTN2;

    @FXML
    private Label FixedPointLabel;

    @FXML
    private AnchorPane FixedPointPane;

    @FXML
    private AnchorPane FullPane;

    @FXML
    private AnchorPane IntegPane;

    @FXML
    private AnchorPane LagrangePane;

    @FXML
    private AnchorPane LinearPane;

    @FXML
    private Button MainBisectionBTN;

    @FXML
    private Button MainDiffBTN;

    @FXML
    private Button MainFalseBTN;

    @FXML
    private Button MainFixedBTN;

    @FXML
    private Button MainIntegBTN;

    @FXML
    private Button MainLagrangeBTN;

    @FXML
    private Button MainLinearBTN;

    @FXML
    private Button MainNewtonBTN;

    @FXML
    private Button MainNewtonDivBTN;

    @FXML
    private Button MainNonLinearBTN;

    @FXML
    private AnchorPane MainOptionsPane;

    @FXML
    private AnchorPane NewtonDivPane;

    @FXML
    private AnchorPane NewtonPane;

    @FXML
    private AnchorPane NonLinearPane;




    Timeline timeline;
    String baseStyle = " -fx-background-color: #161a33;" +
            "    -fx-text-fill: white;" +
            "    -fx-background-radius: 32;";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        setupAnimation(button1);
//        setupAnimation(button2);
//        setupAnimation(button3);
//        setupAnimation(button4);
//        setupAnimation(button5);
//        setupAnimation(button6);
//        setupAnimation(button7);
//        setupAnimation(button8);
//        setupAnimation(button9);
//        setupAnimation(button0);
//        setupAnimation(buttonPlus);
//        setupAnimation(buttonMinus);
//        setupAnimation(buttonMultiply);
//        setupAnimation(buttonDivide);
//        setupAnimation(buttonPercent);
//        setupAnimation(buttonEquals);
//        setupAnimation(buttonClear);
//        setupAnimation(buttonPower);
//        setupAnimation(buttonSqrt);
//        setupAnimation(buttonSin);
//        setupAnimation(buttonCos);
//        setupAnimation(buttonTan);
//        setupAnimation(buttonCosInv);
//        setupAnimation(buttonTanInv);
//        setupAnimation(buttonSinInv);
//        setupAnimation(buttonE);
//        setupAnimation(buttonAbs);
//        setupAnimation(buttonLN);
//        setupAnimation(buttonLeftBracket);
//        setupAnimation(buttonRightBracket);
//        setupAnimation(buttonBackspace);
//        setupAnimation(buttonDecimalPoint);
//        setupAnimation(buttonEquals);

        setupAnimation(MainFixedBTN);
        setupAnimation(MainBisectionBTN);
        setupAnimation(MainDiffBTN);
        setupAnimation(MainFalseBTN);
        setupAnimation(MainNonLinearBTN);
        setupAnimation(MainNewtonBTN);
        setupAnimation(MainNewtonDivBTN);
        setupAnimation(MainLagrangeBTN);
        setupAnimation(MainLinearBTN);
        setupAnimation(MainIntegBTN);
    }


    public void setupAnimation(Button button) {


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

//    public void setupAnimation(Button button) {
//
//        if (button == button0 || button == button1 || button == button2 || button == button3 || button == button4 || button == button5 || button == button6 || button == button7
//            || button == button8 || button == button9 || button == button0 || button == buttonDecimalPoint) {
//            Timeline timeline = new Timeline(
//                    new KeyFrame(Duration.millis(8), e -> updateNumberButtonStyle(button))
//            );
//            timeline.setCycleCount(Timeline.INDEFINITE);
//
//            button.setOnMouseEntered(e -> timeline.play());
//            button.setOnMouseExited(e -> {
//                colourscaling = 0;
//                timeline.stop();
//                button.setStyle("");
//            });
//        }
//        else if (button == buttonPlus || button == buttonMinus || button == buttonMultiply || button == buttonDivide
//            || button == buttonPercent || button == buttonEquals || button == buttonCos || button == buttonTan || button == buttonCosInv || button == buttonTanInv
//            || button == buttonSin || button == buttonSinInv || button == buttonE || button == buttonAbs || button == buttonLN || button == buttonLeftBracket
//            || button == buttonRightBracket || button == buttonSqrt || button == buttonPower) {
//            Timeline timeline = new Timeline(
//                    new KeyFrame(Duration.millis(8), e -> updateOtherButtonStyle(button))
//            );
//            timeline.setCycleCount(Timeline.INDEFINITE);
//
//            button.setOnMouseEntered(e -> timeline.play());
//            button.setOnMouseExited(e -> {
//                colourscaling = 0;
//                timeline.stop();
//                button.setStyle("");
//            });
//        }
//        else if (button == buttonClear || button == buttonBackspace) {
//            Timeline timeline = new Timeline(
//                    new KeyFrame(Duration.millis(8), e -> updateExitButtonStyle(button))
//            );
//            timeline.setCycleCount(Timeline.INDEFINITE);
//
//            button.setOnMouseEntered(e -> timeline.play());
//            button.setOnMouseExited(e -> {
//                colourscaling = 0;
//                timeline.stop();
//                button.setStyle("");
//            });
//        }
//
//    }
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
//        System.out.println("hello world");
//        gridPane.setOpacity(0.5); // REMEMBER TO SET IT BACK WHEN CALCULATING AGAIN

    }



    public void FixedPointOptions(ActionEvent event) {
        if (event.getSource() == FixedPointBTN1) {
            FixedPointLabel.setText(FixedPoint.FixedPoint1(1));
        } else if (event.getSource() == FixedPointBTN2) {
            FixedPointLabel.setText(FixedPoint.FixedPoint2(Math.PI));
        }
    }


    @FXML
    private TextField BisectionATXT;

    @FXML
    private TextField BisectionBTXT;

    @FXML
    private Label BisectionLabel;
    public void BisectionOptions(ActionEvent event) {
        if (BisectionATXT != null && BisectionBTXT != null ) {
            BisectionLabel.setText(Bisection.BisectionMethod1(Double.parseDouble(BisectionATXT.getText()), Double.parseDouble(BisectionBTXT.getText())));
        } else {
            Bisection.BisectionMethod1(1, 2);
        }
    }



    @FXML
    private TextField FalseATXT;

    @FXML
    private TextField FalseBTXT;

    @FXML
    private Label FalsePositionLabel;

    public void FalsePosition(ActionEvent event) {
        if (FalseATXT != null && FalseBTXT != null ) {
            FalsePositionLabel.setText(FalsePosition.FalsePosition(Double.parseDouble(FalseATXT.getText()), Double.parseDouble(FalseBTXT.getText())));
        } else {
            FalsePosition.FalsePosition(1, 2);
        }

    }


    @FXML
    private TextField SecantATXT;

    @FXML
    private TextField SecantBTXT;

    @FXML
    private Label SecantLabel;

    public void Secant(ActionEvent event) {
        SecantLabel.setText(Secant.Secant(Double.parseDouble(SecantATXT.getText()), Double.parseDouble(SecantBTXT.getText())));
    }



    @FXML
    private Label LinearLabel;
    @FXML
    private TextField X11TXT;
    @FXML
    private TextField X12TXT;
    @FXML
    private TextField X13TXT;
    @FXML
    private TextField X21TXT;
    @FXML
    private TextField X22TXT;
    @FXML
    private TextField X23TXT;
    @FXML
    private TextField X31TXT;
    @FXML
    private TextField X32TXT;
    @FXML
    private TextField X33TXT;
    @FXML
    private TextField X14TXT;
    @FXML
    private TextField X24TXT;
    @FXML
    private TextField X34TXT;


    public void Jacobi() {
        double X1_0 = 0, X2_0 = 0, X3_0 = 0; // Initial guess
        double tolerance = 1e-14;
            LinearLabel.setText(tt.Jacobi(Double.parseDouble(X11TXT.getText()), Double.parseDouble(X12TXT.getText()), Double.parseDouble(X13TXT.getText()), Double.parseDouble(X14TXT.getText()),
                    Double.parseDouble(X21TXT.getText()), Double.parseDouble(X22TXT.getText()), Double.parseDouble(X23TXT.getText()), Double.parseDouble(X24TXT.getText()),
                            Double.parseDouble(X31TXT.getText()), Double.parseDouble(X32TXT.getText()), Double.parseDouble(X33TXT.getText()), Double.parseDouble(X34TXT.getText()),
                    X1_0, X2_0, X3_0, tolerance));
    }

















    @FXML
    private AnchorPane SecantPane;
    @FXML
    private Button MainSecantBTN;



    public void SwitchScenes(ActionEvent event) {
        if (event.getSource() == MainFixedBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(true);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        } else if (event.getSource() == MainBisectionBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(true);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        } else if (event.getSource() == MainFalseBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(true);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        } else if (event.getSource() == MainNewtonBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(true);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        } else if (event.getSource() == MainSecantBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(true);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        }
        else if (event.getSource() == MainLinearBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(true);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        }
        else if (event.getSource() == MainNonLinearBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(true);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        }
        else if (event.getSource() == MainLagrangeBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(true);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        }
        else if (event.getSource() == NewtonDivPane) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(true);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        }
        else if (event.getSource() == MainDiffBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(true);
            IntegPane.setVisible(false);
        }
        else if (event.getSource() == MainIntegBTN) {
            MainOptionsPane.setVisible(false);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(true);
        }
         else {
            MainOptionsPane.setVisible(true);
            FixedPointPane.setVisible(false);
            BisectionPane.setVisible(false);
            FalsePositionPane.setVisible(false);
            NewtonPane.setVisible(false);
            SecantPane.setVisible(false);
            LinearPane.setVisible(false);
            NonLinearPane.setVisible(false);
            LagrangePane.setVisible(false);
            NewtonDivPane.setVisible(false);
            DiffPane.setVisible(false);
            IntegPane.setVisible(false);
        }
    }


}


