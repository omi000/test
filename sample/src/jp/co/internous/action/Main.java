package jp.co.internous.action;

public class Main {

	public static void main(String[] args){
		System.out.println("Hello World");
		System.out.println(hikizan(10,10));
		System.out.println(kakezan(10,10));
		System.out.println(warizan(10,10));
	}
	public static int hikizan(int namber1,int namber2){
		return namber1-namber2;
	}
	public static int kakezan(int namber1,int namber2){
		return namber1*namber2;
	}
	public static int warizan(int namber1,int namber2){
		return namber1/namber2;
	}
	
}
