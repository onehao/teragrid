package com.onehao;

public class Person {

	/**
	 * @param args
	 */
	public String firstName = "Onehao";
	public String lastName = "Wan";
	public int age = 27;
	public Person[] children = new Person[0];
	public Person parent = null;
	public Person(String firstName,String lastname,int age){
		this.firstName = firstName;
		this.lastName = lastname;
		this.age = age;
	}
	
	public Person(String firstName,String lastName,int age,Person[] children){
		this(firstName,lastName,age);
		this.children = children;
		for (int i = 0; i < children.length; i++){
			children[i].parent = this;
		}
	}
	
	public static Person[] example(){
		return new Person[]{
				new Person("ONE","HAO",27,new Person[]{
					new Person("Beth","Rubel",11),
					new Person("David","Rubel",6)}),
				new Person("Eric","Clayberg",42,new Person[]{
					new Person("Lauren","ZClayberg",9),
					new Person("Lee","Clayberg",7)}),
				new Person("Michael","taylor",55)
				};
		}
	public String toString(){
		return firstName + " " +lastName;
	}
	}
