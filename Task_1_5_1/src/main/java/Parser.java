import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.pow;

public class Parser {

    Stack<Operations> operationsStack;
    Stack<Number> numberStack;

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

    public void realParser(Scanner scan) {
        operationsStack = new Stack<>();
        numberStack = new Stack<>();
        String i;

        while (!(scan.hasNextDouble() || scan.hasNextInt())) {
            switch (scan.next()) {
                case " ":
                    break;
                case "+":
                    operationsStack.push(Operations.plus);
                    break;
                case "-":
                    operationsStack.push(Operations.minus);
                    break;
                case "*":
                    operationsStack.push(Operations.mult);
                    break;
                case "/":
                    operationsStack.push(Operations.div);
                    break;
                case "l":
                    if (Objects.equals(scan.next(), "o")) {
                        if (Objects.equals(scan.next(), "g")) {
                            operationsStack.push(Operations.log);
                        }
                    }
                    break;
                case "p":
                    if (Objects.equals(scan.next(), "o")) {
                        if (Objects.equals(scan.next(), "w")) {
                            operationsStack.push(Operations.pow);
                        }
                    }
                    break;
                case "s":
                    if (Objects.equals(scan.next(), "i")) {
                        if (Objects.equals(scan.next(), "n")) {
                            operationsStack.push(Operations.sin);
                        }
                    } else {
                        if (Objects.equals(scan.next(), "q")) {
                            if (Objects.equals(scan.next(), "r")) {
                                if (Objects.equals(scan.next(), "t"))
                                    operationsStack.push(Operations.sqrt);
                            }
                        }
                    }
                    break;
                case "c":
                    if (Objects.equals(scan.next(), "o")) {
                        if (Objects.equals(scan.next(), "s")) {
                            operationsStack.push(Operations.cos);
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Wrong operations format");
            }
        }

        if (operationsStack.empty()) {
            throw new IllegalArgumentException("Wrong operations format");
        }

        while (scan.hasNextDouble() || scan.hasNextInt()) {
            numberStack.push(scan.nextDouble());
        }
        if (numberStack.empty()) {
            throw new IllegalArgumentException("Wrong numbers format");
        }
        if (numberStack.size() - 1 != operationsStack.size()) {
            throw new IllegalArgumentException("Incorrect ratio of operations/numbers");
        }
//Передаём стэки чисел и операций в класс калькулятор
    }
}
