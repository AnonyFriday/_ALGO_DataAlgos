/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.theories.fractal;

/**
 * Drawing an English Ruler
 *
 * <br><br> For 1 inch, we place a numeric label => ----1
 * <br><br> For 1/2 inch, we place with 2 dashes => --
 * <br><br> For 1/4 inch, we place with 1 dash => -
 *
 * @author duyvu
 */
public class EnglishRuler {

    public static void drawRuler(int nInches, int majorInchesLength) {
	// Draw the first line at 0
	drawLine(majorInchesLength, 0);

	// Draw the otherr tick recursively
	for (int i = 1; i <= nInches; i++) {
	    if (majorInchesLength > 0) {
		drawInterval(majorInchesLength - 1);
		drawLine(majorInchesLength, i);
	    }
	}
    }

    // Draw interval reursively
    private static void drawInterval(int centralLength) {
	if (centralLength >= 1) {
	    drawInterval(centralLength - 1);
	    drawLine(centralLength);
	    drawInterval(centralLength - 1);
	}
    }

    // Function to draw a line "-"
    private static void drawLine(int tickLength, int tickLabel) {
	for (int i = 0; i < tickLength; i++) {
	    System.out.print("-");
	}

	// If having a label, then print it
	if (tickLabel >= 0) {
	    System.out.print(" " + tickLabel);
	}
	System.out.print("\n");
    }

    private static void drawLine(int tickLength) {
	drawLine(tickLength, -1);
    }

    /// Main functionto test the problem 
    public static void main(String[] args) {
//	drawLine(4);
	drawRuler(4, 3);
    }
}
