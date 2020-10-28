package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

//PROBLEM
/*
Given two sequences pushed and popped with distinct values,
return true if and only if this could have been the result of a sequence of push
and pop operations on an initially empty stack.

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */

//APPROACH
/*
1. Push elements in stack from pushed till we meet the first element in popped.
2. Pop the elements in stack and move pointer in popped if value match
3. Loop it since pushed array is over
4. Check if stack is Empty
 */
public class ValidateStackSequences {
    public boolean validateStackSequencesGreedy(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0, j = 0;
        while(i<pushed.length){
            while((stack.isEmpty()  || stack.peek() != popped[j]) && i<pushed.length) {
                stack.push(pushed[i]);
                i++;
            }

            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }
}
