package com.example.feedback.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateTime = LocalDate.parse("2019-05-10", formatter);
		LocalDate time = LocalDate.now();
		System.out.println(time);
		System.out.println(dateTime);
		System.out.println(dateTime.compareTo(time));
	}

}
