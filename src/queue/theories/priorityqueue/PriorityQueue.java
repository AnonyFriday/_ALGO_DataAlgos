/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.theories.priorityqueue;

import java.util.Comparator;
import java.util.Queue;

/**
 *
 * @author duyvu
 */
public class PriorityQueue {

    public static void maxHeapCustomized() {

        Comparator<Student> comparatorStudent = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getRollNo() - o2.getRollNo();
            }
        };

        Queue<Student> queue = new java.util.PriorityQueue<>(comparatorStudent);

        queue.add(new Student(3, "Vu Kim Duy"));
        queue.add(new Student(-20, "Vu"));
        queue.add(new Student(34, "Kim"));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void minHeap() {
        // By default it is min heap
        Queue<Integer> queue = new java.util.PriorityQueue<>();

        queue.add(6);
        queue.add(8);
        queue.add(4);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void maxHeap() {
        // Max Heap
        Queue<Student> queue = new java.util.PriorityQueue<>(Comparator.reverseOrder());

        queue.add(new Student(3, "Vu Kim Duy"));
        queue.add(new Student(30, "Vu"));
        queue.add(new Student(34, "Kim"));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void main(String[] args) {

//        PriorityQueue.maxHeap();
        PriorityQueue.maxHeapCustomized();
    }
}
