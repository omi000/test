package jp.co.internous.action;

public class Test {
	public static void main(String[] args){
		Person taro=new Person();


	Person saburo=new Person("saburo");
	System.out.println(saburo.name);
	System.out.println(saburo.age);

	Person nanasi=new Person(25);
	        System.out.println(nanasi.name);
	        System.out.println(nanasi.age);

	Person hanako=new Person(17,"hanako");
			System.out.println(hanako.name);
			System.out.println(hanako.age);

	}
}