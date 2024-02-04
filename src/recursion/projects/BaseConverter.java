/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects;

/**
 *
 * @author duyvu
 */
public class BaseConverter {

    public static String baseConverter(int num,
                                       int base) {
        if (num == 0) {
            return "0";
        } else {
            return baseConverter(num / base, base) + Character.forDigit(num % base, base);
        }
    }

    public static void main(String[] args) {
        System.out.println(baseConverter(266, 2));
        System.out.println(baseConverter(266, 10));
        System.out.println(baseConverter(266, 8));
        System.out.println(baseConverter(266, 16));
        System.out.println(baseConverter(266, 24));
    }
}
