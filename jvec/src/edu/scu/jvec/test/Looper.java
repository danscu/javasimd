package edu.scu.jvec.test;

public class Looper {
	public int sum(int[] A) {
		int i = 0;
		int sum = 0;
		for (i = 0; i < A.length; i++)
			sum += A[i];
		return sum;
	}
}