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
                case plus -> numberStack.push(numberStack.pop() + numberStack.pop());
                case minus -> numberStack.push(numberStack.pop() - numberStack.pop());
                case mult -> numberStack.push(numberStack.pop() * numberStack.pop());
                case div -> numberStack.push(numberStack.pop() / numberStack.pop());
                case pow -> numberStack.push(pow(numberStack.pop(), numberStack.pop()));
                case sqrt -> numberStack.push(sqrt(numberStack.pop()));
                case log -> numberStack.push(log(numberStack.pop()));
                case sin -> numberStack.push(sin(numberStack.pop()));
                case cos -> numberStack.push(cos(numberStack.pop()));
            }
        }
        return numberStack.pop();
    }
}
