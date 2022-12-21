import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Parser {

    Stack<Operations> operationsStack;
    Stack<Double> numberStack;

    public enum Operations {
        plus, minus, mult, div, log, pow, sqrt, sin, cos
    }

    public Parser() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            realParser(scan);
        } else {
            throw new IllegalArgumentException("Nothing to calculate");
        }

    }

    public Parser(String inputString) {
        Scanner scan = new Scanner(inputString);
        realParser(scan);
    }

    private void realParser(Scanner scan) {
        operationsStack = new Stack<>();
        numberStack = new Stack<>();
        int expectedNumber = 1;
        while (!(scan.hasNextDouble() || scan.hasNextInt())) {
            switch (scan.next()) {
                case " ":
                    break;
                case "+":
                    operationsStack.push(Operations.plus);
                    expectedNumber++;
                    break;
                case "-":
                    operationsStack.push(Operations.minus);
                    expectedNumber++;
                    break;
                case "*":
                    operationsStack.push(Operations.mult);
                    expectedNumber++;
                    break;
                case "/":
                    operationsStack.push(Operations.div);
                    expectedNumber++;
                    break;
                case "log":
                    operationsStack.push(Operations.log);
                    break;
                case "pow":
                    operationsStack.push(Operations.pow);
                    expectedNumber++;
                    break;
                case "sin":
                    operationsStack.push(Operations.sin);
                    break;
                case "sqrt":
                    operationsStack.push(Operations.sqrt);
                    break;
                case "cos":
                    operationsStack.push(Operations.cos);
                    break;
                default:
                    System.out.println(operationsStack);
                    throw new IllegalArgumentException("Wrong operations format");
            }
        }

        if (operationsStack.isEmpty()) {
            throw new IllegalArgumentException("Wrong operations format");
        }

        while (scan.hasNextDouble() || scan.hasNextInt()) {
            numberStack.push(scan.nextDouble());
        }
        if (numberStack.empty()) {
            throw new IllegalArgumentException("Wrong numbers format");
        }
        if (numberStack.size() != expectedNumber) {
            throw new IllegalArgumentException("Incorrect ratio of operations/numbers");
        }
    }
}
