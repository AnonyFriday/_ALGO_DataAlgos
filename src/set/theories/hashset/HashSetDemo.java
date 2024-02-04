/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package set.theories.hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author duyvu
 */
public class HashSetDemo {

    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();

        Student student1 = new Student(1, "KIM");
        Student student2 = new Student(1, "KIM");
        Student student3 = new Student(99, "Trinh");
        Student student4 = new Student(123, "Duc");
        Student student5 = new Student(2, "Hand");

        System.out.println("Student 1: " + student1.hashCode());
        System.out.println("Student 2: " + student2.hashCode());
        System.out.println("Student 3: " + student3.hashCode());
        System.out.println("Student 4: " + student4.hashCode());
        System.out.println("Student 5: " + student5.hashCode());

        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student4);
        studentSet.add(student5);
        
        
        
        studentSet.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student t) {
                System.out.println(t);
            }
        });
    }
}
