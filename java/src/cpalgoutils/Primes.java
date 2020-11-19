package cpalgoutils;

import java.util.*;

public class Primes {

    public static Integer[] sieve(int n){
        Set<Integer> notPrimes = new HashSet<>();
        Set<Integer> primes = new HashSet<>();

        for(int i=2; i<=n; ++i){
            if(!notPrimes.contains(i)){
                primes.add(i);
                for(int j=2*i; j<=n; j+=i){
                    notPrimes.add(j);
                }
            }
        }
        return primes.toArray(new Integer[primes.size()]);
    }

    public static boolean isPrime(int n){
        Set<Integer> notPrimes = new HashSet<>();
        for(int i=2; i<=n; ++i){
            if(!notPrimes.contains(i)){
                for(int j=2*i; j<=n; j+=i){
                    notPrimes.add(j);
                }
            }
        }
        return !notPrimes.contains(n);
    }


    public static void main(String[] args){

    }
}
