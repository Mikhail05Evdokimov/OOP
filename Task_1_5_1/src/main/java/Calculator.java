import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class Calculator {

    public double calculator() {
        Parser input = new Parser();
        return calculator(input);
    }

    public double calculator(String inputString) {
        Parser input = new Parser(inputString);
        return calculator(input);
    }

    private double calculator(Parser input) {
        var operationsStack = input.operationsStack;
        var numberStack = input.numberStack;
        Parser.Operations oper;
        while(!(operationsStack.isEmpty())) {
            oper = operationsStack.pop();
            switch (oper) {
                case PLUS:
                    numberStack.push(numberStack.pop() + numberStack.pop());
                    break;
                case MINUS:
                    numberStack.push(numberStack.pop() - numberStack.pop());
                    break;
                case MULT:
                    numberStack.push(numberStack.pop() * numberStack.pop());
                    break;
                case DIV:
                    var a = numberStack.pop();
                    var b = numberStack.pop();
                    if (b == 0) {
                        throw new IllegalArgumentException("Деление на ноль!");
                    }
                    numberStack.push(a / b);
                    break;
                case POW:
                    numberStack.push(pow(numberStack.pop(), numberStack.pop()));
                    break;
                case SQRT:
                    a = numberStack.pop();
                    if (a < 0) {
                        throw new IllegalArgumentException("Корень из отр. числа!");
                    }
                    numberStack.push(sqrt(a));
                    break;
                case LOG:
                    a = numberStack.pop();
                    if (a <= 0) {
                        throw new IllegalArgumentException("LOG по числу <= 0!");
                    }
                    numberStack.push(log(a));
                    break;
                case SIN:
                    numberStack.push(sin(numberStack.pop()));
                    break;
                case COS:
                    numberStack.push(cos(numberStack.pop()));
                    break;
            }
        }
        return numberStack.pop();
    }
}
