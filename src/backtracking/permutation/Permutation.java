/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Generating a permutation of the string or the number based on the given value
 *
 * @author duyvu
 */
public class Permutation {

    public List<List<Character>> permutation(String givenNums) {

        // contains a result of each scenario
        // e.g. a -> abcd : print 1 scenario to the screen
        List<List<Character>> resultList = new ArrayList<>();
        ArrayList<Character> tempList = new ArrayList<>();

        // calling the backtracking function
        backtracking(givenNums, resultList, tempList);

        return resultList;
    }

    public void backtracking(String givenNums,
                             List<List<Character>> resultList,
                             ArrayList<Character> tempList) {

        // Base condition
        // e.g. [AB] -> add to result [AB]
        // If tempList is equals to givenNums, then add to result
        // Create new instance, not passing a tempList since tempList reference to 
        //      the only instance that being removed, delete, add for operation
        if (tempList.size() == givenNums.length()) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        // Iterating each recursion to reach every scenario
        for (int i = 0; i < givenNums.length(); i++) {

            // if does not check, then adding every char to the empty, which we dont want
            // e.g. A _ _ => remaining position has to be unique, if A again then continue
            // e.g. A A _ => NO, dont do it, thats why we continue
            if (tempList.contains(givenNums.charAt(i))) {
                continue;
            }

            // e.g. ABC, at A
            // at A, at B(1) or at C(2) => tempList [A]
            //    => since A added, have to skip if containing A again, same at B and C
            // at B(1) then at C => tempList [A B] -> tempList [A B C] return 
            // at C(2) then at B => tempList [A C B -> tempList [A C B] return
            tempList.add(givenNums.charAt(i));

            // Go to every single character when put under for
            backtracking(givenNums, resultList, tempList);

            // Reclaim back the tempList by removing character at each iteration
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation per = new Permutation();

        System.out.println(per.permutation("ABC"));
    }
}
