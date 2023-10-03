/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.projects.softdrink;

/**
 *
 * @author duyvu
 */
public class SoftDrink implements Comparable<SoftDrink> {

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
    /**
     * Constructor used for comparing 2 objects
     *
     * @param productLine
     */
    public SoftDrink(String productLine) {
        this.productLine = productLine;
    }

    public SoftDrink(String productLine,
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
    /**
     * Check if 2 objects are equal or not based on productLine
     *
     * @param obj: object SoftDrink
     * @return true if productLine equals otherwise return false
     */
    @Override
    public boolean equals(Object obj) {
        return this.productLine.equals(((SoftDrink) obj).productLine);
    }

    /**
     * To string representation of the object
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%d,%d", productLine, company, volume, price);
    }

    @Override
    public int compareTo(SoftDrink o) {
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

    // ====================================
    // = Getters & Setters
    // ====================================
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
