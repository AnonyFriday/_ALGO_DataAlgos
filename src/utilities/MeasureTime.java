/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 * A small Object to measure time needed to run an algorithm
 *
 * @author duyvu
 */
public class MeasureTime {

    /**
     * A simulation of using Measure Time
     *
     * @return
     */
    public static double duration() {
        double S = 0.0;
        for (long i = 0; i < 1000000000; i++) {
            S += 0.1;
        }
        return S;
    }

    public static void main(String[] args) {

        // Using nanoTime() or currentTimeMillis() to measure the algorithm's time
        long t1 = System.nanoTime();
        double S = MeasureTime.duration();
        long t2 = System.nanoTime();

        System.out.println("Result: " + S);
        System.out.println("Duration of operation: " + (t2 - t1) + " milisec");
    }
}
