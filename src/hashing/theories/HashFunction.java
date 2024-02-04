/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashing.theories;

/**
 *
 * @author duyvu
 */
public class HashFunction {

    // HashFunction: "SE12345" -> "12345" -> 12345 % hashSize
    public int hashFunction(String key,
                            int hashSize) {

        // Extracting the 12345
        String numKeyStr = key.substring(key.length() - 5, key.length());

        int numKey = Integer.parseInt(numKeyStr);
        return numKey % hashSize;
    }

    // Testing purpose
    public static void main(String[] args) {
        HashFunction hashObj = new HashFunction();
        String key1 = "SE12345";
        int hashSize = 12;
        int index = hashObj.hashFunction(key1, hashSize);
        System.out.println(index);
    }
}
