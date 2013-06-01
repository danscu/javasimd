/*************************************************************************
 *  Compilation:  javac VectorTest.java
 *  Execution:    java VectorTest
 *
 *  % java VectorTest
 *
 *  Provides functions that may be auto-vectorized.
 *************************************************************************/

import java.util.Random;

public class VectorTest {
    private int testSum(int n) {
	int i;
	int sum = 0;
	for (i = 0; i < n; i++)
		sum += i;
	return sum;
    }

    private int testArraySum(int[] ia) {
      int sum = 0;
      for (int i = 0; i < ia.length; i++)
         sum += ia[i];
      return sum;
    }

    private void testSort(int a[]) {
	int i, j, minp;
	for (i = 0; i < a.length - 1; i++) {
		minp = i;
	for (j = i + 1; j < a.length; j++)
		if (a[j] < a[minp])
			minp = j;
		int tmp = a[i]; a[i] = a[minp]; a[minp] = tmp;
	}
    }

    void testSLPVectorize(int a1, int a2, int b1, int b2, int A[]) {
        A[0] = a1*(a1 + b1)/b1 + 50*b1/a1;
        A[1] = a2*(a2 + b2)/b2 + 50*b2/a2;
    }

    public static void main(String[] args) {
	VectorTest inst = new VectorTest();

	// Test 1	
	int res = inst.testSum(100);
	System.out.println("Sum = " + res); 

	// Test 2
	int[] ia = new int[100];
	for (int i = 0; i < 100; i++)
		ia[i] = i;
	res = inst.testArraySum(ia);
	System.out.println("Array sum = " + res); 

	// Test 4
	inst.testSLPVectorize(10, 20, 30, 40, ia);
	System.out.println("Straight line program result = " + ia[0] + " " +
		ia[1]); 

	// Test 3
	int N = 100000;
	Random r = new Random();
	ia = new int[N];
	for (int i = 0; i < N; i++)
		ia[i] = r.nextInt();

	long startMs = System.currentTimeMillis();
	inst.testSort(ia);
	long durationMs = System.currentTimeMillis() - startMs;
	System.out.println(String.format("Sort time: %d ms", durationMs));
	System.err.println(durationMs);

	boolean showSorted = false;
	if (showSorted) {
		for (int i = 0; i < N; i++)
			System.out.print(ia[i] + " ");
		System.out.println();
	}

	System.out.println("Sorting done, N = " + N);
    }
}

