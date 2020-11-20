package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different
 * possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 *
 *
 * SOLUTION
 * At evey operator divide assuming braces around each segment. Recursively do the same for both segments, return the results calculated from lower recursion levels
 * to higher ones. Iterate through these lists at every level and keep adding left and rights.
 */
public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<input.length(); ++i){
            if(input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*'){
                List<Integer> l = diffWaysToCompute(input.substring(0, i));
                List<Integer> r = diffWaysToCompute(input.substring(i+1, input.length()));

                for(Integer lValue : l){
                    for(Integer rValue : r){
                        int s = 0;
                        if(input.charAt(i) == '+'){
                            s = lValue + rValue;
                        }else if(input.charAt(i) == '-'){
                            s = lValue - rValue;
                        }else if(input.charAt(i) == '*'){
                            s = lValue * rValue;
                        }

                        res.add(s);
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
