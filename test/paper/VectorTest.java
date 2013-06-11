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
    private int testArraySum(int[] ia) {
      int sum = 0;
      for (int redundant = 0; redundant < 1000; redundant++) { 
	   sum = 0;
	   for (int i = 0; i < ia.length; i++)
		 sum += ia[i];
      }
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
	int i;
	int r;
	for (r = 0; r < 100; r++)
	for (i = 0; i < A.length - 1; i += 2) {
        	A[i] = a1*(a1 + b1)/b1 + 50*b1/a1;
        	A[i + 1] = a2*(a2 + b2)/b2 + 50*b2/a2;
	}
    }

    private void testInsertionSort(int a[]) {
		int i, j, key;
		for(j = 1; j < a.length; j++) {
			key = a[j];
			for(i = j-1; (i >= 0) && (a[i] < key); i--) {
				a[i+1] = a[i];
			}
			a[i+1] = key;
		}
    }

    public static void main(String[] args) {
	VectorTest inst = new VectorTest();
	long startMs;
	long durationMs;
	int res;

	int[] ia = new int[1000000];
	int[] ib = new int[1000000];
	for (int i = 0; i < 1000000; i++) {
		ia[i] = i;
		ib[i] = i * 2;
	}

	// Test 1 array sum
	startMs = System.currentTimeMillis();	
	res = inst.testArraySum(ia);
	durationMs = System.currentTimeMillis() - startMs;

	System.out.println("Array sum = " + res); 
	System.out.println(String.format("Array sum time: %d ms", durationMs));
	System.err.println(durationMs);

	// Test 2 SLP
	startMs = System.currentTimeMillis();
	inst.testSLPVectorize(10, 20, 30, 40, ia);
	durationMs = System.currentTimeMillis() - startMs;
	System.out.println("Straight line program result = " + ia[0] + " " +
		ia[1]);
	System.out.println(String.format("SLP time: %d ms", durationMs));
	System.err.println(durationMs);

	// Test 3 -- selection sort
	int N = 40000;
	Random r = new Random(0);
	ia = new int[N];
	for (int i = 0; i < N; i++)
		ia[i] = r.nextInt();

	startMs = System.currentTimeMillis();
	inst.testSort(ia);
	durationMs = System.currentTimeMillis() - startMs;
	System.out.println(String.format("Sort time: %d ms", durationMs));
	System.err.println(durationMs);

	boolean showSorted = false;
	if (showSorted) {
		for (int i = 0; i < N; i++)
			System.out.print(ia[i] + " ");
		System.out.println();
	}

	System.out.println("Selection sorting done, N = " + N);

	// Test 4 -- insertion sort
	r = new Random(0);
	ia = new int[N];
	for (int i = 0; i < N; i++)
		ia[i] = r.nextInt();
	startMs = System.currentTimeMillis();
	inst.testInsertionSort(ia);
	durationMs = System.currentTimeMillis() - startMs;
	System.out.println(String.format("Insertion sort time: %d ms", durationMs));
	System.err.println(durationMs);

	if (showSorted) {
		for (int i = 0; i < N; i++)
			System.out.print(ia[i] + " ");
		System.out.println();
	}
    }
}

