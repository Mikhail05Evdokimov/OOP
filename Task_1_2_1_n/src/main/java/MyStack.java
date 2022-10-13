import java.util.Arrays;
import java.util.Objects;

/**
 * Container stack with push() and pop() operations.
 *
 * @param <T> - type of elements in stack
 */

public class MyStack<T> {

    private int cap = 8;
    private int cnt = 0;
    private T[] stack;

    /**
     * function to init the stack.
     */
    @SuppressWarnings("unchecked")
    public void createStack() {
        this.cap = 4;
        this.cnt = 0;
        this.stack = (T[]) new Object[cap];
    }

    /**
     * Overridden "equals" method.
     *
     * @param elem the element to compare.
     *
     * @return returns true if two stacks are equal, else returns false
     */
    public boolean equals(Object elem) {
        if (this == elem) {
            return true;
        }
        if (elem == null || getClass() != elem.getClass()) {
            return false;
        }
        MyStack<?> expected = (MyStack<?>) elem;
        if (cnt != expected.cnt) {
            return false;
        }
        for (int i = 0; i < cnt; i++) {
            if (stack[i] != expected.stack[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Overridden "hashCode" method.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(cnt, cap);
        result = 31 * result + Arrays.hashCode(stack);
        return result;
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
     * procedure pushStack, which add one element to stack.
     *
     * @param arr - array of elements to add
     */
    public void pushStack(T[] arr) {
        for (T t : arr) {
            push(t);
        }
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
     * function popStack, which extract n elements from stack.
     *
     * @param n - number of elements to extract
     *
     */

    public void popStack(int n) {
        for (int i = 0; i < n; i++) {
            pop();
        }
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