import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorView {

    TextArea result = new TextArea("...");
    final FileChooser fileChooser = new FileChooser();

    private static ArrayList<String> cleanInput(String input, ArrayList<String> acceptedInputs) {
        ArrayList<String> stringsArrayList = new ArrayList<>(Arrays.asList(input.trim().split("")));
        ArrayList<String> cleanedInputArrayList = new ArrayList<>();
        for (String s : stringsArrayList) {
            if (acceptedInputs.contains(s)) {
                cleanedInputArrayList.add(s);
            }
        }
        return cleanedInputArrayList;
    }

    public void showCalculator(Stage stage){

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        BorderPane border = new BorderPane();
        HBox hbox = addHBox(stage);
        border.setTop(hbox);
        border.setLeft(addVBox());

        Scene scene = new Scene(border, 400, 400);
        stage.setTitle("Calculadora");
        //scene.getStylesheets().add(Calculadora.class.getResource("estilo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    public HBox addHBox(Stage stage) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(6);
        hbox.setStyle("-fx-background-color: #455a64;");

        Button buttonCurrent = new Button("Open File");
        buttonCurrent.setPrefSize(100, 20);
        buttonCurrent.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            if(selectedFile != null){
                ArrayList<String> myLines = readFile(selectedFile);
                for(String line: myLines){
                    String resultStr = operate(line);
                    result.appendText("\n" + line + " tiene como resultado: " + resultStr);
                }
            }

        });


        Button buttonProjected = new Button("Clear");
        buttonProjected.setPrefSize(100, 20);
        buttonProjected.setOnAction(e -> {
            result.clear();
        });

        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

    private ArrayList<String> readFile(File file){
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                lines.add(text);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(CalculatorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lines;
    }

    private String operate(String line) {
        ArrayList<String> acceptedInputs = new ArrayList<>();
        for (int index = 0; index <= 9; index++) {
            acceptedInputs.add(Integer.toString(index));
        }
        acceptedInputs.add("+");
        acceptedInputs.add("-");
        acceptedInputs.add("*");
        acceptedInputs.add("/");

        ArrayList<String> finalInputArrayList;
        //added dummy data to the method, the idea is to pass a string (does´t matter if it is with spaces
        //or wrong characters to clean it and assign the value of finalInputArrayList.
        finalInputArrayList = cleanInput(line, acceptedInputs);

        Calculator myCalculator = new MyCalculator();
        Stack<Integer> myPila = new Pile<>();
        int result = 0;

        for (int i = 0; i < finalInputArrayList.size(); i++) {
            System.out.println(finalInputArrayList.get(i));
            System.out.println(myPila.toString());
            if (finalInputArrayList.get(i).equals("+") || finalInputArrayList.get(i).equals("*") ||
                    finalInputArrayList.get(i).equals("-") || finalInputArrayList.get(i).equals("/")) {
                if (finalInputArrayList.get(i).equals("/") && finalInputArrayList.get(i - 1).equals("0")) {
                    myPila.pop();
                    System.out.println("No se puede dividir entre cero!");
                } else {
                    int num2 = myPila.pop();
                    int num1 = myPila.pop();
                    result = myCalculator.calculate(num1, num2, finalInputArrayList.get(i));
                    myPila.push(result);
                    System.out.println("Se ha ejecutado la operación: " + num2 + " " + finalInputArrayList.get(i) + " " + num1);
                    System.out.println("el estado actual de la pila es: " + myPila.toString());
                }
            } else {
                myPila.push(Integer.parseInt(finalInputArrayList.get(i)));
            }
        }
        return myPila.toString();
    }

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        result.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(result);

        return vbox;
    }
}
