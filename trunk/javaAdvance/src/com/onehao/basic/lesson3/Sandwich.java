package com.onehao.basic.lesson3;

/**
 * from thinking in java
 * @author onehao
 * 
 *  order of constructor calls for a complex object is as follows: Feedback
 *  The base-class constructor is called. This step is repeated recursively such that 
 *  the root of the hierarchy is constructed first, followed by the next-derived class, etc., 
 *  until the most-derived class is reached. Feedback
 *  Member initializers are called in the order of declaration. Feedback
 *  The body of the derived-class constructor is called. Feedback
 */
class Meal {
	  Meal() { System.out.println("Meal()"); }
	}

	class Bread {
	  Bread() { System.out.println("Bread()"); }
	}

	class Cheese {
	  Cheese() { System.out.println("Cheese()"); }
	}

	class Lettuce {
	  Lettuce() { System.out.println("Lettuce()"); }
	}

	class Lunch extends Meal {
	  Lunch() { System.out.println("Lunch()"); }
	}

	class PortableLunch extends Lunch {
	  PortableLunch() { System.out.println("PortableLunch()");}
	}

	public class Sandwich extends PortableLunch {
	  private Bread b = new Bread();
	  private Cheese c = new Cheese();
	  private Lettuce l = new Lettuce();
	  public Sandwich() {
	    System.out.println("Sandwich()");
	  }
	  public static void main(String[] args) {
	    new Sandwich();
	  }
	} ///:~