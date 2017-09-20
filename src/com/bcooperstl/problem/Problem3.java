package com.bcooperstl.problem;

import java.math.BigDecimal;

import com.bcooperstl.util.PrimeNumberUtils;

public class Problem3 {
	private static final String PROBLEM_DESCRIPTION = 
			"The prime factors of 13195 are 5, 7, 13 and 29.\n" + 
			"\n" + 
			"What is the largest prime factor of the number 600851475143 ?";
	
	public static void main(String[] args) {
		System.out.println(PROBLEM_DESCRIPTION);
		
		BigDecimal number = new BigDecimal("600851475143");
		BigDecimal largest = BigDecimal.ONE;
		
		BigDecimal current = new BigDecimal(2);
		while (current.pow(2).compareTo(number) != 1) {
			if (PrimeNumberUtils.isPrimeBruteForce(current)) {
				System.out.println("Factor " + current + " is prime");
				while (number.remainder(current) == BigDecimal.ZERO) {
					System.out.println("Current " + current + " divides " + number);
					largest = current;
					number = number.divide(current);
					System.out.println("Number is now set to " + number);
				}
			}
			current = current.add(BigDecimal.ONE);
		}
		if (PrimeNumberUtils.isPrimeBruteForce(number)) {
			System.out.println("Largest prime factor set to remaining value " + number);
			largest = number;
		}
		else
		{
			System.err.println("Something went wrong!");
		}
		System.out.println("Answer: " + largest);
	}

}
