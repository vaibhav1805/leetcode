package graphs;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class MinimumJumpstoReachHome {
    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int i : forbidden){
            set.add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        PriorityQueue<OIMatrix.Pair> pq =new PriorityQueue<>(10, Collections.reverseOrder(Comparator.comparingInt(o -> o.d)));
        pq.poll();

        Set<Integer> prevs  = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; ++i){
                int curr = q.poll();
                if(visited.contains(curr)){
                    continue;
                }
                visited.add(curr);
                if(curr == x){
                    return count;
                }

                if(curr<0 || curr>2000){
                    break;
                }

                if(!set.contains(curr+a)){
                    q.add(curr+a);
                }

                if(!set.contains(curr-b) && curr-b >=0){
                    if(!prevs.contains(curr+b)){
                        q.add(curr-b);
                        prevs.add(curr);
                    }else{
                        prevs.remove(curr+b);
                    }
                }

            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] forbidden = {8,3,16,6,12,20};
        int res = minimumJumps(forbidden, 15,13,11);
        System.out.print(res);
    }
}
