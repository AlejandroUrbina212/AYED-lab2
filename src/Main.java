import java.util.ArrayList;
import java.util.Arrays;

public class Main {
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
    public static void main(String[] args) {
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
        finalInputArrayList = cleanInput("1 2 + 4 * 3 + 0 / 2 +", acceptedInputs);

        Calculator myCalculator = new MyCalculator();
        Stack<Integer> myPila = new Pile<>();
        int result;

        for (int i = 0; i < finalInputArrayList.size(); i++) {
            System.out.println(finalInputArrayList.get(i));
            System.out.println(myPila.toString());
            if (finalInputArrayList.get(i).equals("+") || finalInputArrayList.get(i).equals("*") ||
                    finalInputArrayList.get(i).equals("-") || finalInputArrayList.get(i).equals("/")) {
                if (finalInputArrayList.get(i).equals("/") && finalInputArrayList.get(i - 1).equals("0")) {
                    myPila.pop();
                    System.out.println("No se puede dividir entre cero!");
                } else {
                    int num1 = myPila.pop();
                    int num2 = myPila.pop();
                    result = myCalculator.calculate(num1, num2, finalInputArrayList.get(i));
                    myPila.push(result);
                    System.out.println("Se ha ejecutado la operación: " + num2 + " " + finalInputArrayList.get(i) + " " + num1);
                    System.out.println("el estado actual de la pila es: " + myPila.toString());
                }
            } else {
                myPila.push(Integer.parseInt(finalInputArrayList.get(i)));
            }
        }
    }
}
