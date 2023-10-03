/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package list.projects.softdrink;

/**
 *
 * @author duyvu
 */
public interface FileHandling<T> {

    public abstract T createObjectFromLine(String line);

    public void readObjectsFromFile(String filename);

    public void writeObjectsToBinaryFile(String filename);

    public void writeObjectsToTextFile(String filename);
}
