package com.employeeMannagement.problemSolving;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		System.out.println( (360 % number == 0) ? "1" : "0");
		System.out.println( (number <= 360) ? "1" : "0");
		System.out.println( (((number * (number + 1)) / 2) <= 360) ? "1" : "0");
	}
}
