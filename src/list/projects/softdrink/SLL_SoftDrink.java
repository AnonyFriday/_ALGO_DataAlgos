/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.projects.softdrink;

/**
 *
 * @author duyvu
 */
public class SLL_SoftDrink implements Comparable<SLL_SoftDrink> {

    // ====================================
    // = Fields
    // ====================================
    private String productLine;     // type of product
    private String company = null;  // manufacturer
    private int volume = 0;
    private int price = 0;

    // ====================================
    // = Constructor
    // ====================================
    public SLL_SoftDrink(String productLine) {
        this.productLine = productLine;
    }

    public SLL_SoftDrink(String productLine,
                         String company,
                         int volume,
                         int price) {
        this.productLine = productLine;
        this.company = company;
        this.volume = volume;
        this.price = price;
    }

    // ====================================
    // = Tools for Search Operations
    // ====================================
    @Override
    public boolean equals(Object obj) {
        return this.productLine.equals(((SLL_SoftDrink) obj).productLine);
    }

    /**
     * Sorting ascending by price then ascending by productLine
     *
     * @param o: object of SoftDrink class
     * @return -1, 1, 0 depends on the comparison
     */
    @Override
    public int compareTo(SLL_SoftDrink o) {
        // Comparising price difference to sort price 
        int priceDiff = this.price - o.price;
        if (priceDiff > 0) {
            return 1;
        }
        if (priceDiff < 0) {
            return -1;
        }
        return this.productLine.compareTo(productLine);
    }
}
