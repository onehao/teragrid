package com.onehao.basic.lesson3;

public class TIJNote {
	  private String noteName;
	  private TIJNote(String noteName) {
	    this.noteName = noteName;
	  }
	  public String toString() { return noteName; }
	  public static final TIJNote
	    MIDDLE_C = new TIJNote("Middle C"),
	    C_SHARP  = new TIJNote("C Sharp"),
	    B_FLAT   = new TIJNote("B Flat");
	    // Etc.
	} ///:~