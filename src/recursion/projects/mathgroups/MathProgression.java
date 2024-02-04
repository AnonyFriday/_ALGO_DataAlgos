/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.mathgroups;

/**
 *
 * @author duyvu
 */
public class MathProgression {

    /**
     * Calculate Geometric Progression (tail recursion)
     *
     * <br><br> Formula: q * (1 - q^n) / 1 - q
     * <br><br> Un = U1 * q^(n-1)
     *
     * @param nth
     * @param a
     * @param q
     * @return
     */
    public static double geometricProgression(int nth,
                                              double a,
                                              double q) {
        if (nth == 1) {
            return a;
        } else {
            return geometricProgression(nth - 1, a * q, q);
        }
    }

    /**
     * Calculate Sum Progression (tail recursion)
     *
     * <br><br> Formula: n/2 *(2 * a + (n - 1)*d)
     *
     * @param nth
     * @param sum
     * @param q
     * @return
     */
    public static double arithmeticProgression(int nth,
                                            double a,
                                            double d) {
        if (nth == 1) {
            return a;
        } else {
            return arithmeticProgression(nth - 1, a + d, d);
        }
    }

    public static void main(String[] args) {
        System.out.println("GP: " + geometricProgression(6, 1.5, 2));
        System.out.println("AP: " + arithmeticProgression(3, 1.5, 6));
    }
}
