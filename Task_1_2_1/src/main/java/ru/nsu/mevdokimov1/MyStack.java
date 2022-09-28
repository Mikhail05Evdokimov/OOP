package ru.nsu.mevdokimov1;

public class MyStack {

    public static int[] stack;
    public static int cnt = 0;

    /**
     * procedure push, which add one element to stack.
     *
     * @param arg - element to add
     */
    public static void push(int arg){
        stack[cnt] = arg;
        cnt++;
    }

    /**
     * procedure pushStack, which add one element to stack.
     *
     * @param arr - array of elements to add
     */
    public static void pushStack(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            stack[cnt] = arr[i];
            cnt++;
        }
    }

    /**
     * function pop, which extract one element from stack.
     * no params
     */
    public static int pop(){
        int ans = stack[cnt];
        cnt--;
        return ans;
    }

    /**
     * function popStack, which extract n elements from stack.
     *
     * @param n - number of elements to extract
     */
    public static int[] popStack(int n){
        int[] ansArr ;
        ansArr = new int[n];
        for(int i = 0; i < n; i++){
            ansArr[i] = stack[cnt];
            cnt--;
        }
        return ansArr;
    }

    public static void main(String[] args){

        stack = new int[2048];
        push(5);
        push(2);
        int[] brr = {3, 3};
        pushStack(brr);
        int a = pop();
        System.out.printf("%d %d %d", stack[0], stack[1], stack[2]);
    }

}

