/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package textprocessing.stringmatching;

/**
 *
 * @author duyvu
 */
public class BruceForce {

    /**
     * Finding the first index appearing on the string
     *
     * @param str    an original string
     * @param subStr a sub strings
     *
     * @return -1 or index of the substring presents on the string
     */
    public static int firstIndexOfSubStr(String str, String subStr) {

        // return -1 if str length less than subStr
        if (str.length() < subStr.length()) {
            return -1;

        } // Return if the str or subStr is null
        else if (str.isEmpty() || subStr.isEmpty()) {
            return -1;
        }

        // Iterating each char in String as the beginning of the matching pattern
        int noIters = str.length() - subStr.length() + 1;
        for (int iStr = 0; iStr < noIters; iStr++) {
            int j = 0;
            while (j < subStr.length()) {

                // If some index has not founded, then break
                if (str.charAt(iStr + j) != subStr.charAt(j)) {
                    break;
                }

                // Increment j until reach the non-equal character
                j++;

                // If matching the whole substr, then return i
                if (j == subStr.length()) {
                    return iStr;
                }
            }
        }
        return -1;
    }

//    public static int lastIndexOfSubStr(String str, String subStr) {
//        
//    }
    
    public static void main(String[] args) {
        System.out.println(firstIndexOfSubStr("VU KIM DUY ", "DUY"));
    }
}
