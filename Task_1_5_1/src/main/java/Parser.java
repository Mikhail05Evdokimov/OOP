import java.util.Scanner;
import java.util.Stack;

/**
 * Parser for input string.
 * Scans the line symbol by symbol and saves operations
 * and numbers into two stacks.
 */
public class Parser {

    Stack<Operations> operationsStack;
    Stack<Double> numberStack;

    /**
     * Constants to store operation's order in stack.
     */
    public enum Operations {
        PLUS, MINUS, MULT, DIV, LOG, POW, SQRT, SIN, COS
    }

    /**
     * Constructor for console calculator's parser.
     */
    public Parser() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            realParser(scan);
        } else {
            throw new IllegalArgumentException("Nothing to calculate");
        }

    }

    /**
     * Constructor for non-console calculator's parser.
     * @param inputString - expression to parse.
     */
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
                    operationsStack.push(Operations.PLUS);
                    expectedNumber++;
                    break;
                case "-":
                    operationsStack.push(Operations.MINUS);
                    expectedNumber++;
                    break;
                case "*":
                    operationsStack.push(Operations.MULT);
                    expectedNumber++;
                    break;
                case "/":
                    operationsStack.push(Operations.DIV);
                    expectedNumber++;
                    break;
                case "log":
                    operationsStack.push(Operations.LOG);
                    break;
                case "pow":
                    operationsStack.push(Operations.POW);
                    expectedNumber++;
                    break;
                case "sin":
                    operationsStack.push(Operations.SIN);
                    break;
                case "sqrt":
                    operationsStack.push(Operations.SQRT);
                    break;
                case "cos":
                    operationsStack.push(Operations.COS);
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
