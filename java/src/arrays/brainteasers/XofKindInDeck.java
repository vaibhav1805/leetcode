package arrays.brainteasers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PROBLEM
 *
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 *
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */

/**
 * APPROACH
 * 1. Create a Map with count
 * 2. Find GCD of all counts
 * 3. Return true if GCD >= 2
 */
public class XofKindInDeck {
    public int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();

        for(int i=0; i<deck.length; ++i){
            int count = map.getOrDefault(deck[i], 0);
            map.put(deck[i], count+1);
        }

        for(Integer k :  map.keySet()){
            l.add(map.get(k));
        }

        if(l.size() == 1){
            return (l.get(0) < 2) ? false:true;
        }

        int g = l.get(0);
        for(int i=1; i<l.size(); ++i){
            g = gcd(g, l.get(i));
        }

        return g>=2;
    }
}
