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
import java.util.ArrayList;
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
        setupAnimation(FixedPointBTN1);
        setupAnimation(FixedPointBTN2);
        setupAnimation(MainSecantBTN);
        setupAnimation(LagrangeXBTN);
        setupAnimation(LagrangeFXBTN);
        setupAnimation(LagrangeXnBTN);
        setupAnimation(MainTrapBTN);
        setupAnimation(MainSimpBTN);
        setupAnimation(MainRomBTN);
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

    private void updateNumberButtonStyle(Button button) {
        // Your existing scaling logic
        if (colourscaling > 94) {
            colourscaling += 0.465;
        } else if (colourscaling < 1.1) {
            colourscaling += 0.265;
        } else if (colourscaling < 5) {
            colourscaling += 0.465;
        } else {
            colourscaling += 2;
        }

        button.setStyle("-fx-background-radius: 32; " +
                "  -fx-background-color: linear-gradient(to top right, #083054 " + colourscaling + "%, transparent 0%);" +
                " -fx-text-fill: linear-gradient(to right, white " + colourscaling + "%, transparent 0%);");
    }


    private void updateOtherButtonStyle(Button button) {
        // Your existing scaling logic
        if (colourscaling > 94) {
            colourscaling += 0.465;
        } else if (colourscaling < 1.1) {
            colourscaling += 0.265;
        } else if (colourscaling < 5) {
            colourscaling += 0.465;
        } else {
            colourscaling += 2;
        }

        button.setStyle("-fx-background-radius: 32; " +
                "  -fx-background-color: linear-gradient(to top right, #e531c4 " + colourscaling + "%, transparent 0%);" +
                " -fx-text-fill: linear-gradient(to right, black " + colourscaling + "%, transparent 0%);");
    }

    private void updateExitButtonStyle(Button button) {
        // Your existing scaling logic
        if (colourscaling > 94) {
            colourscaling += 0.465;
        } else if (colourscaling < 1.1) {
            colourscaling += 0.265;
        } else if (colourscaling < 5) {
            colourscaling += 0.465;
        } else {
            colourscaling += 2;
        }

        button.setStyle("-fx-background-radius: 32; " +
                "  -fx-background-color: linear-gradient(to top right, #9b2915 " + colourscaling + "%, transparent 0%);" +
                " -fx-text-fill: linear-gradient(to right, white " + colourscaling + "%, transparent 0%);");
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
        if (BisectionATXT != null && BisectionBTXT != null) {
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
        if (FalseATXT != null && FalseBTXT != null) {
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
    private Label NewtonLabel;
    @FXML
    private TextField NewtonTXT;

    public void Newton() {
        NewtonLabel.setText(Newton.newtonRaphson(Double.parseDouble(NewtonTXT.getText())));
    }

    static ArrayList<Double> LagrangeXlist;
    static ArrayList<Double> LagrangeFXlist;

    @FXML
    private AnchorPane LagrangeListsPane;
    @FXML
    private TextField LagrangeSizeTXT;
    @FXML
    private Label LagrangeLabel;

    static int size;

    public void LagrangeSize() {
        if (LagrangeSizeTXT.getText() != null) {
            size = Integer.parseInt(LagrangeSizeTXT.getText());
            LagrangeXlist = new ArrayList<>();
            LagrangeFXlist = new ArrayList<>();
            LagrangeListsPane.setVisible(true);
            lagrangeString += "Lagrange Table size = " +size+"\n";
            LagrangeLabel.setText(lagrangeString);

        } else {
            LagrangeLabel.setText("Please Enter a Correct Size");
        }
    }

    @FXML
    Button LagrangeXBTN;
    @FXML
    Button LagrangeFXBTN;
    @FXML
    TextField LagrangeXTXT;
    @FXML
    TextField LagrangeFXTXT;
    @FXML
    TextField LagrangeXnTXT;
    @FXML
    Button LagrangeXnBTN;

    static double Xn;

    static String lagrangeString = "";

    public void applyLagrange(ActionEvent event) {
        if (event.getSource() == LagrangeXBTN) {
            if (LagrangeXTXT.getText() != null) {
//                if (LagrangeXlist.size() >= size) {
                LagrangeXlist.add(Double.parseDouble(LagrangeXTXT.getText()));
                lagrangeString += "Lagrange X" + LagrangeXlist.size() + " = " + LagrangeXTXT.getText() +"\n";
                LagrangeLabel.setText(lagrangeString);

//                } else {
//                    LagrangeLabel.setText("you have filled the X table,\n Please fill the F(x) table");
//
//                }
            } else {
                LagrangeLabel.setText("Please Enter a correct value in X");
            }
        } else if (event.getSource() == LagrangeFXBTN) {
            if (LagrangeFXTXT.getText() != null) {
//                if (LagrangeFXlist.size() >= size) {
                LagrangeFXlist.add(Double.parseDouble(LagrangeFXTXT.getText()));
                lagrangeString += "Lagrange F(x)" + LagrangeFXlist.size() + " = " + LagrangeFXTXT.getText()+"\n";
                LagrangeLabel.setText(lagrangeString);
//                } else {
//                    LagrangeLabel.setText("you have filled the table, press Find");
//                }
            } else {
                LagrangeLabel.setText("Please Enter a correct value in F(x)");
            }
        } else if (event.getSource() == LagrangeXnBTN) {
            if (LagrangeXnTXT.getText() != null) {
                Xn = Double.parseDouble(LagrangeXnTXT.getText());
                lagrangeString += "The X you want to find Using Lagrange is " + Xn+"\n";
                LagrangeLabel.setText(lagrangeString);

            } else {
                LagrangeLabel.setText("Please Enter a correct value for X");
            }
        }
    }

    public void Lagrange() {
        lagrangeString += Lagrange.Largrange(LagrangeXlist, LagrangeFXlist, Xn);
        LagrangeLabel.setText(lagrangeString);
    }



    @FXML
    Label TrapLabel;
    @FXML
    TextField TrapTXT;

    public void Trap() {
        if (TrapTXT.getText() != null) {
            TrapLabel.setText(Trapezoidal.Trapezoidal(0, 3, Double.parseDouble(TrapTXT.getText())));
        } else {
            TrapLabel.setText("Please Enter a Correct Value");
        }
    }

    @FXML
    Label SimpLabel;
    @FXML
    TextField SimpTXT;

    public void Simp() {
        if (SimpTXT.getText() != null) {
            SimpLabel.setText(Simpson.Simpson(0, 3, Double.parseDouble(SimpTXT.getText())));
        } else {
            SimpLabel.setText("Please Enter a Correct Value");
        }
    }


    @FXML
    Label RomLabel;

    public void Romberg() {
        RomLabel.setText(Romberg.testRomberg(0, 8, 4));
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
        else if (event.getSource() == MainNewtonDivBTN) {
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
            TrapPane.setVisible(false);
            SimpPane.setVisible(false);
            RomPane.setVisible(false);
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
            TrapPane.setVisible(false);
            SimpPane.setVisible(false);
            RomPane.setVisible(false);
        }
    }


    @FXML
    AnchorPane TrapPane;
    @FXML
    AnchorPane SimpPane;
    @FXML
    AnchorPane RomPane;
    @FXML
    Button MainTrapBTN;
    @FXML
    Button MainSimpBTN;
    @FXML
    Button MainRomBTN;

    public void SwitchSubScenes(ActionEvent event) {
        if (event.getSource() == MainTrapBTN) {
            TrapPane.setVisible(true);
            SimpPane.setVisible(false);
            RomPane.setVisible(false);
        } else if (event.getSource() == MainSimpBTN) {
            TrapPane.setVisible(false);
            SimpPane.setVisible(true);
            RomPane.setVisible(false);
        } else if (event.getSource() == MainRomBTN) {
            TrapPane.setVisible(false);
            SimpPane.setVisible(false);
            RomPane.setVisible(true);
        }
    }


}


