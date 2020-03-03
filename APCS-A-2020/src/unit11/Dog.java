package unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class Dog 
{
	// information about the dog
    private int age;
    private String name;
    
    // constructor: initialize attributes
    public Dog(int a, String n) 
    {
    	age = a;
    	name = n;
    } 
    
    // getters
    public String getName() {return name;}
    
    public int getAge() {return age;}
    
    // toString with information about the dog
    public String toString()
    {
    	return "" + age + " " + name;
    }  
}