/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects;

/**
 *
 * @author duyvu
 */
public class IsPalindrome {

    /**
     * Check if the string is palindrome or not
     *
     * @param c
     * @param n
     * @return
     */
    static boolean isPalindrome(char c[],
                                int n) {
        // If len = 1, then return true;
        if (n == 1) {
            return true;
        }
        int len = c.length;

        // If char at left != char at right then return false
        if (c[len - n] != c[n - 1]) {
            return false;
        } else {
            return isPalindrome(c, n - 1);
        }
    }

    static boolean isPalindrome(char c[]) {
        return isPalindrome(c, c.length);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("VUV".toCharArray()));
    }
}
