public class TestClassLoader
{
	public static void main(String[] args)
	{
		Person p = new Person();
		
		System.out.println(Person.class);
		
		System.out.println(Person.class.getClassLoader().getParent());
	}
}

class Person
{
	String name;
}
