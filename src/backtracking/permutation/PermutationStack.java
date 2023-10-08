/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 * @author duyvu
 */
public class PermutationStack {

    public List<List<Integer>> permutationStack(int num) {
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<Integer> tempStack = new Stack<>();

        backTracking(num, resultList, tempStack);
        return resultList;
    }

    public void backTracking(int num,
                             List<List<Integer>> resultList,
                             Stack<Integer> tempStack) {

        if (num == tempStack.size()) {
            // Copy the value of the state when stack equals to number of element
            resultList.add(new ArrayList<>(tempStack));
            return;
        }

        for (int i = 1; i <= num; i++) {

            // e.g. 1 _ _ => _ has to be unique
            if (tempStack.contains(i)) {
                continue;
            }

            // branch 1 -> push(1) then push(2) then push(3)
            tempStack.push(i);
            backTracking(num, resultList, tempStack);

            // branch 1 -> pop(3) then pop (2)
            tempStack.pop();
        }
    }

    public static void main(String[] args) {
        PermutationStack permutation = new PermutationStack();
        System.out.println(permutation.permutationStack(3));

        // Convert Stack to String Using Stream API
        ArrayList<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

//        list.add(stack.stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
//        list.add(stack.stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
//        list.add(stack.stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
        System.out.println(list);

        // Convert Stack to String Using Iterator
        Iterator<Integer> iter = stack.iterator();
        String str = "";
        while (iter.hasNext()) {
            str += iter.next();

        }
        list.add(str);

        System.out.println(list);
    }
}
