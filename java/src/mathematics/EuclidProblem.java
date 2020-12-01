package mathematics;

import java.lang.reflect.Array;
import java.util.*;

/**
 * PROBLEM
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1045
 *
 * SOLUTION
 * Extended Euclid Algorithm
 */

public class EuclidProblem {
    static class Answer{
        public int x;
        public int y;
        public int d;

        public Answer(){}
    }

    public static void euclidProblem(int a, int b, Answer ans){
        if(b == 0){
            ans.d = a;
            ans.x = 1;
            ans.y = 0;
            return;
        }

        euclidProblem(b, a%b, ans);
        int x = ans.x;
        ans.x = ans.y;
        ans.y = x - ans.y * (a/b);
    }

    public static void main(String[] args){
        Answer answer = new Answer();
        euclidProblem(4,6, answer);
        System.out.println(String.format("%d %d %d", answer.x, answer.y, answer.d));
    }
}
