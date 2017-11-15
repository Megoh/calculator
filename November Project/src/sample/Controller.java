package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField result;
    private double number1 = 0;
    private double number2 = 0;
    private String operator = "";
    private boolean start = true;
    private boolean activated = false;
    private double memory = 0;
    private Model model = new Model();

    @FXML
    public void switchOn() {
        activated = true;
        result.setText("0");
    }

    @FXML
    public void switchOff() {
        activated = false;
        result.setText("");
    }

    @FXML
    public void processCE() {
        if (activated)
            result.setText("0");
    }

    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }
        if (activated) {
            if (result.getText().equals("0") || result.getText().equals("0.0"))
                result.setText("");
            String value = ((Button) event.getSource()).getText();
            result.setText(result.getText() + value);
        }
    }

    @FXML
    public void processOperators(ActionEvent event) {
        if (activated) {
            String value = ((Button) event.getSource()).getText();
            if (!value.equals("=") && !value.equals("%")) {
                operator = value;
                number1 = Double.parseDouble(result.getText());
                result.setText("");
            }
            else if (value.equals("%") && !result.getText().equals("")) {
                number2 = Double.parseDouble(result.getText());
                double output = model.calculatePercent(number1, number2, operator);
                result.setText(String.valueOf(output));
                operator = "";
                start = true;
            }
            else if (!result.getText().isEmpty()) {
                if (operator.isEmpty())
                    return;
                number2 = Double.parseDouble(result.getText());
                double output = model.calculate(number1, number2, operator);
                result.setText(String.valueOf(output));
                operator = "";
                start = true;
            }
        }
    }

    @FXML
    public void processSqrt() {
        if (activated) {
            number1 = Double.parseDouble(result.getText());
            result.setText(String.valueOf(model.calculateSqrt(number1)));
        }
    }

    @FXML
    public void processDot() {
        if (activated && !result.getText().contains("."))
            result.setText(result.getText() + ".");
    }

    @FXML
    public void processMemoryPlus() {
        if (activated)
            memory += Double.parseDouble(result.getText());
    }

    @FXML
    public void processMemoryMinus() {
        if (activated)
            memory -= Double.parseDouble(result.getText());
    }

    @FXML
    public void processMemoryRecall() {
        if (activated)
            result.setText(String.valueOf(memory));
    }

    @FXML
    public void processMemoryClear() {
        if (activated)
            memory = 0;
    }

    @FXML
    public void processPlusMinus() {
        if (activated) {
            if (result.getText().charAt(0) == '-')
                result.setText(result.getText().replace("-", ""));
            else
                result.setText("-" + result.getText());
        }
    }

}