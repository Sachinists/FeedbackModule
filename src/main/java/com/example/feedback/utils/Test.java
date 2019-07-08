package com.example.feedback.utils;

public class Test {

	public static void main(String[] args) {
		String s1 = new String("amay");
		String s2 = new String("Arun");
		String s3 = "Arun";
		String a = "Aa";
		String b = "BB";
		
//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
//		System.out.println(a == b);

//		System.out.println(s3.hashCode());
//		System.out.println(s1 == s2);
		
//		System.out.println(s3.equals(s2));
//		System.out.println(s2.equals(s1));
//		System.out.println(s1.equals(s3));
		
		s1.concat("Yadav");
		System.out.println(s1);
		
		
		StringBuffer sB = new StringBuffer("Arun");
		System.out.println("amay".hashCode());
//		sB.append("Pg");
//		System.out.println(sB.hashCode());
//		System.out.println(sB);
	}

}
