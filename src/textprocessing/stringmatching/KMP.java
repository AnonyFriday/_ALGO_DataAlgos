/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package textprocessing.stringmatching;

/**
 * KMP
 * - Time:
 *
 *
 * Longest Suffix Pattern Table
 *
 * - Starting state of the array
 * - P[index] == P[len] , so len = len + 1 and P[index] = len and index = index + 1
 * - P[index] != P[len] , so len = P[len-1] = 1
 *
 * https://medium.com/@aakashjsr/preprocessing-algorithm-for-kmp-search-lps-array-algorithm-50e35b5bb3cb
 *
 * @author duyvu
 */
public class KMP {

    public static void main(String[] args) {

    }
}
