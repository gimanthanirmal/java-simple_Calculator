package com.example.calculatorv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class CalculatorController {

    @FXML
    private TextField textDisplay;

    @FXML
    private TextArea historyDisplay;
    private String operator = "";
    private double num1 = 0;
    private double num2 = 0;
    private double result = 0;
    private boolean startNewNumber = true;
    static double history[] = new double[10];
    static int historyCount = 0;

    @FXML
    void onNumberClick(ActionEvent event) {
        if (startNewNumber) {
            textDisplay.clear();
            startNewNumber = false;
        }
        String buttonText = ((Button) event.getSource()).getText();
        textDisplay.appendText(buttonText);
    }

    @FXML
    void onOperatorClick(ActionEvent event) {
        operator = ((Button) event.getSource()).getText();
        num1 = Double.parseDouble(textDisplay.getText());
        startNewNumber = true;
    }

    @FXML
    void onEqualClick(ActionEvent event) {
        num2 = Double.parseDouble(textDisplay.getText());


        switch (operator) {
            case "+" -> result = MathProcessor.add(num1, num2);
            case "-" -> result = MathProcessor.sub(num1, num2);
            case "X" -> result = MathProcessor.mul(num1, num2);
            case "/" -> {
                if (num2 == 0) {
                    textDisplay.setText("Can't Devide by 0");
                    return;
                }
                result = MathProcessor.div(num1, num2);
            }
        }

        textDisplay.setText(String.valueOf(result));
        showHistory(history, result);
        startNewNumber = true;
    }

    @FXML
    void onHistoryClick(ActionEvent event) {
        historyDisplay.clear();

        for (int i = 0; i < historyCount; i++) {
            historyDisplay.appendText(  (i +1)+": " + history[i] +"\n");
        }
    }

    @FXML
    void onBackspaceClick (ActionEvent event){

        String currentText = textDisplay.getText();

        if (currentText.length()>0){

            String newText = currentText.substring(0,currentText.length() - 1);
            textDisplay.setText(newText);

        }
    }

    @FXML
    void onMinusClick (ActionEvent event){

        String currentText = textDisplay.getText();

        if( !currentText.isEmpty() && !currentText.equals("0")){

            double val = Double.parseDouble(currentText);

            val = val * -1;

            textDisplay.setText(String.valueOf(val));
        }


    }

    @FXML
    void onClearClick(ActionEvent event) {
        textDisplay.clear();
        historyDisplay.clear();
        num1 = 0;
        num2 = 0;
        result = 0;
        operator = "";
        startNewNumber = true;
    }

    public void showHistory(double[] history, double res) {
        if(historyCount < history.length){

            history[historyCount] = res;
            historyCount++;
        }else {
            for (int i = 0; i < history.length - 1; i++) {
                history[i] = history[i + 1];
            }
            history[history.length - 1] = res;
        }
    }
}