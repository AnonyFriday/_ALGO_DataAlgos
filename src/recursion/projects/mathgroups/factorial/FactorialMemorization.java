/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.mathgroups.factorial;

/**
 * The Factorial Technique using memorization
 *
 * <br></br> Reduce the time of redundant looping
 *
 * @author duyvu
 */
public class FactorialMemorization {

    static int[] term = new int[1001];

    static int fib(int n) {

        // Base case
        if (n <= 1) {
            return n;
        }

        // if fib(n) has already been computed we do not do
        // further recursive calls and hence reduce the number of repreated work 
        if (term[n] != 0) {
            return term[n];
        } else {
            term[n] = fib(n - 1) + fib(n - 2);
            System.out.println(term[n]);
            return term[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
