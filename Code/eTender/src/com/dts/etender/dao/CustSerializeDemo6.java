package com.dts.etender.dao;

//CustSerializeDemo6.java
import java.io.*;
class  Animal 
{
	int i = 10;
	Animal(int i)
	{
		System.out.println("Animal has called");
	}
}
class Dog extends Animal implements Serializable
{
	  int j =20;
	 Dog()
	 {
		 super(20);
		 System.out.println("Dog has called");
	 }

}
public class CustSerializeDemo6
{
	public static void main(String[] args) throws Exception
	{
		Dog a1 = new Dog();
		
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		System.out.println(a1.i+"=============="+a1.j);
		
		System.out.println("Deserialization is started");
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog a2 = (Dog)ois.readObject();
		System.out.println(a2.i+"=============="+a2.j);

	}
}
