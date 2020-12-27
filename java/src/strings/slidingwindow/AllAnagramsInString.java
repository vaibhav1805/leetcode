package strings.slidingwindow;

import bst.utils.TreeNode;

import java.util.*;

public class AllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length()-1;
        int k = p.length()-1;

        if(k>n){
            return res;
        }

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        String sc= "";
        sc.indexOf('.');


        for(int i=0; i<=k; ++i){
            int count = pMap.getOrDefault(p.charAt(i), 0);
            pMap.put(p.charAt(i), count+1);
        }

        for(int i=0; i<=n; ++i){
            int count = sMap.getOrDefault(s.charAt(i), 0);
            sMap.put(s.charAt(i), count+1);

            if(i>k){
                int c = sMap.get(s.charAt(i-k-1));
                if(c == 1){
                    sMap.remove(s.charAt(i-k-1));
                }else{
                    sMap.put(s.charAt(i-k-1), c-1);
                }
            }

            if(pMap.equals(sMap)){
                res.add(i-k);
            }

        }
        return res;
    }
}
