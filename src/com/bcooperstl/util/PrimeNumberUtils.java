package com.bcooperstl.util;

import java.math.BigDecimal;

public class PrimeNumberUtils {
	public static Boolean isPrimeBruteForce(BigDecimal target) {
		
		BigDecimal current = new BigDecimal("2");

		// only need to iterate up to the square root of target to divide by the factor.
		// BigDecimal doesn't have a square root, so we can compare the current factor squared.
		while (current.pow(2).compareTo(target) != 1) {
			if (target.remainder(current).compareTo(BigDecimal.ZERO) == 0) {
				return false;
			}
			current = current.add(BigDecimal.ONE);
		}
		// never found a factor - it is prime
		return true;
	}
}
