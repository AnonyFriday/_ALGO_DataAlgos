/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.foldertree;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author duyvu
 */
public class FolderTree {

    // Print content of a folder
    public static void print(File file,
                             int prefix) {

//        if (!file.exists()) {
//            return;
//        }
        if (prefix > 0) {

            // prefix * 3 + 3 = steps
            // +3 for the pattern |__ (3 characters)
            // * 
            int steps = (prefix - 3) / 3;
            for (int i = 1; i <= steps; i++) {
                System.out.print("|  ");
            }
            // prefix for file and folder
            // |_myfolder
            // | |_ file
            System.out.print("|__");
        }

        System.out.println(file.getName());

        // If it's a children then recursively calls to its children
        if (file.isDirectory()) {
            File[] children = file.listFiles();

            // Optional to sort the folder and file
            // Folder are put in front of the list
            // Filename is being ordered ascendingly
            Comparator<File> sortName = new Comparator<File>() {
                @Override
                public int compare(File o1,
                                   File o2) {
                    if (o1.isDirectory() && o2.isFile()) {
                        return -1;
                    } else if (o1.isFile() && o2.isDirectory()) {
                        return 1;
                    } else {
                        return o1.toString().toUpperCase().compareTo(o2.toString().toUpperCase());
                    }
                }
            };

            Arrays.sort(children, sortName);

            // Tail Recursion call adding each child an extra 3
            // if file is folder than keep spanning
            // if file is file, than appending filename to the next file
            for (File child : children) {

                // tail recursion, after calling children, they do not calculate anything then just elimiate activation record
                print(child, prefix + 3);
            }
        }
    }

    // Testing
    public static void main(String[] args) {
        String pathname = "E:\\Learning\\FPT\\2022_Semester-3\\CSD201\\AdvancedTopic\\Algorithms\\DataAlgos\\src\\recursion\\theories";
        File file = new File(pathname);

        print(file, 0);
    }
}
