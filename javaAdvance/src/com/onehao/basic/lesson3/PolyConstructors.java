package com.onehao.basic.lesson3;

/**
 * from thinking in java
 * @author onehao
 *
 *process of initialization is:
 *
 *	The storage allocated for the object is initialized to binary zero before anything else happens. Feedback
 *	The base-class constructors are called as described previously. At this point, the overridden draw( ) 
 *  method is called (yes, before the RoundGlyph constructor is called), which discovers a radius value of zero, 
 *  due to Step 1. Feedback
 *	Member initializers are called in the order of declaration. Feedback
 *	The body of the derived-class constructor is called. Feedback
 */
abstract class Glyph {
	  abstract void draw();
	  Glyph() {
	    System.out.println("Glyph() before draw()");
	    draw();
	    System.out.println("Glyph() after draw()");
	  }
	}

	class RoundGlyph extends Glyph {
	  public int radius = 1;
	  RoundGlyph(int r) {
	    radius = r;
	    System.out.println(
	      "RoundGlyph.RoundGlyph(), radius = " + radius);
	  }
	  void draw() {
	    System.out.println(
	      "RoundGlyph.draw(), radius = " + radius);
	  }
	}

	public class PolyConstructors {
	  public static void main(String[] args) {
	    new RoundGlyph(5);
	  }
	} ///:~