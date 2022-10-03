package ru.nsu.mevdokimov1;

import java.util.Arrays;

public class MyStack <T>{

    public int cap = 8;
    public int cnt = 0;
    public T[] stack;

    /**
     * function to init the stack.
     */
    @SuppressWarnings("unchecked")
    public void CreateStack(){
        cap = 8;
        cnt = 0;
        stack = (T[]) new Object[cap];
    }

    /**
     * procedure push, which add one element to stack.
     *
     * @param arg - element to add
     */
    public void push(T arg){
        if(cnt >= cap){
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
    public void pushStack(T[] arr){
        for (T t : arr) {
            push(t);
        }
    }

    /**
     * function pop, which extract one element from stack.
     * no params
     */
    public T pop(){
        if(cnt == 0){
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

    public void popStack(int n){
        for(int i = 0; i < n; i++){
            pop();
        }
    }

    /**
     * function which return the amount of elements in stack.
     * @return cnt - amount of el. in stack.
     */
    public int count() {
        return cnt;
    }

}

