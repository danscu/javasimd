import java.util.Random;

/**
 *
 * @author danke
 *
 */
public class VectorTestStressVersion {
	/**
	 *
	 * @param n
	 * @return
	 */
	private int testSum(int n) {
		int i;
		int sum = 0;
		for (i = 0; i < n; i++)
			sum += i;
		return sum;
	}

	/**
	 *
	 * @param ia
	 * @return
	 */
	private int testArraySum(int[] ia) {
		int sum = 0;
		for (int redundant = 0; redundant < 1000; redundant++) { 
			sum = 0;
			for (int i = 0; i < ia.length; i++)
				sum += ia[i];
		}
		return sum;
	}

	/**
	 *
	 * @param a
	 */
	private void testSort(int a[]) {
		int i, j, minp;
		for (i = 0; i < a.length - 1; i++) {
			minp = i;
			for (j = i + 1; j < a.length; j++)
				if (a[j] < a[minp])
					minp = j;
			int tmp = a[i];
			a[i] = a[minp];
			a[minp] = tmp;
		}
	}

	void testSLPVectorize(int a1, int a2, int b1, int b2, int A[], int B[]) {
		int i;
		int r;
		for (r = 0; r < 100; r++)
			for (i = 0; i < A.length; i++) {
				A[i] = a1*(a1 + b1)/b1 + 50*b1/a1;
				B[i] = a2*(a2 + b2)/b2 + 50*b2/a2;
			}
	}

	private void testNRMSort(int a[]) {
		if(a.length < 2)
			return;
		int step = 1;
		int startL, startR;
		while(step < a.length) {
			startL = 0;
			startR = step;
			while(startR + step <= a.length) {
				//merge
				int right[] = new int[step + 1];
				int left[] = new int[step + 1];
				for(int i = 0, k = startR; i < (right.length - 1); ++i, ++k) {
					right[i] = a[k];
				}
				for(int i = 0, k = startL; i < (left.length - 1); ++i, ++k) {
					left[i] = a[k];
				}
				right[right.length-1] = Integer.MAX_VALUE;
				left[left.length-1] = Integer.MAX_VALUE;
				for(int k = startL, m = 0, n = 0; k < (startR + step); ++k) {
					if(left[m] <= right[n]) {
						a[k] = left[m];
						m++;
					}
					else {
						a[k] = right[n];
						n++;
					}
				}

				startL = startR + step;
				startR = startL + step;
			}
			if(startR < a.length) {
				//merge
				int right[] = new int[a.length - startR + 1];
				int left[] = new int[step + 1];
				for(int i = 0, k = startR; i < (right.length - 1); ++i, ++k) {
					right[i] = a[k];
				}
				for(int i = 0, k = startL; i < (left.length - 1); ++i, ++k) {
					left[i] = a[k];
				}
				right[right.length-1] = Integer.MAX_VALUE;
				left[left.length-1] = Integer.MAX_VALUE;
				for(int k = startL, m = 0, n = 0; k < (a.length); ++k) {
					if(left[m] <= right[n]) {
						a[k] = left[m];
						m++;
					}
					else {
						a[k] = right[n];
						n++;
					}
				}
			}
			step *= 2;
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

	/**
	 *
	 * @param args
	 */
	public void executeTests(int no) {
		// Test 1 - Array Sum
		int[] ia = new int[1000000];
		int[] ib = new int[1000000];
		for (int i = 0; i < 1000000; i++){
			ia[i] = i;
			ib[i] = i * 2;
		}

		long test2Start=System.currentTimeMillis();
		this.testArraySum(ia);
		long test2End=System.currentTimeMillis();
		long test2dur=test2End-test2Start;

		// Test 2 - SLP
		long test3Start=System.currentTimeMillis();
		this.testSLPVectorize(10, 20, 30, 40, ia, ib);
		long test3End=System.currentTimeMillis();
		long test3dur=test3End-test3Start;

		// Test 3 - Selection Sort
		int N = 40000;
		Random r = new Random();
		ia = new int[N];
		for (int i = 0; i < N; i++)
			ia[i] = r.nextInt();

		long test4Start=System.currentTimeMillis();
		this.testSort(ia);
		long test4End=System.currentTimeMillis();
		long test4dur=test4End-test4Start;

		//Test 4 - Insertion Sort
		//System.out.println("Insertion Sort");
		Random r2 = new Random();
		int[] ia2 = new int[N];
		for (int i = 0; i < N; i++)
			ia2[i] = r2.nextInt();

		long startMs2 = System.currentTimeMillis();
		this.testInsertionSort(ia2);
		long durationMs2 = System.currentTimeMillis() - startMs2;
		//System.out.println(String.format("Insertion Sort time: %d ms", durationMs2));
		//System.err.println(durationMs2);

		//System.out.println("Insertion Sorting done, N = " + N);

		//System.out.println("Non Recursive Merge Sorting done, N = " + N);
		System.out.println(test2dur+";"+test3dur+";"+test4dur+";"+durationMs2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VectorTestStressVersion vec=new VectorTestStressVersion();

		for (int i=0;i<=49;i++){
			vec.executeTests(i);
		}
	}
}
