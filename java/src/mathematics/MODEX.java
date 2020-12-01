package mathematics;


import java.util.Scanner;

/**
 * PROBLEM
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3671
 *
 * SOLUTION
 * Binary Exponentiation
 * (xy)mod n = ((x mod n) * (y mod n)) mod n
 */

public class MODEX {

    public static long modex(int x, int y, int n){
        long res = 1;
        x = x%n;
        while(y>0){
            int check = y & 1;
            if(check ==  1)
                res = (res  * x)%n;

            x = (x * x) %n;
            y >>= 1;
        }

        return res;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int c = s.nextInt();
        for(int i=0; i<c; ++i){
            int x = s.nextInt();
            int y = s.nextInt();
            int n = s.nextInt();


            long res = modex(x,y,n);
            System.out.println(res);
        }
    }
}
