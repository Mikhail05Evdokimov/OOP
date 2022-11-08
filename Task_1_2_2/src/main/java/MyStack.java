import java.util.Arrays;

/**
 * Container stack with push() and pop() operations.
 *
 * @param <T> - type of elements in stack
 */

public class MyStack<T> {

    private int cap = 16;
    private int cnt = 0;
    private T[] stack;

    /**
     * function to init the stack.
     */
    @SuppressWarnings("unchecked")
    public void createStack() {
        this.cap = 16;
        this.cnt = 0;
        this.stack = (T[]) new Object[cap];
    }

    /**
     * procedure push, which add one element to stack.
     *
     * @param arg - element to add
     */
    public void push(T arg) {
        if (cnt >= cap) {
            cap *= 2;
            stack = Arrays.copyOf(stack, cap);
        }
        stack[cnt] = arg;
        cnt++;
    }

    /**
     * function pop, which extract one element from stack.
     * no params
     */
    public T pop() {
        if (cnt == 0) {
            return null;
        }
        cnt--;
        T ans = stack[cnt];
        stack[cnt] = null;
        return ans;
    }

    /**
     * function which return the amount of elements in stack.
     *
     * @return cnt - amount of el. in stack.
     */
    public int count() {
        return cnt;
    }

}