/*************************************************************************
 *  Compilation:  javac HelloWorld.java
 *  Execution:    java HelloWorld
 *
 *  Prints "Hello, World". By tradition, this is everyone's first program.
 *
 *  % java HelloWorld
 *  Hello, World
 *
 *  These 17 lines of text are comments. They are not part of the program;
 *  they serve to remind us about its properties. The first two lines tell
 *  us what to type to compile and test the program. The next line describes
 *  the purpose of the program. The next few lines give a sample execution
 *  of the program and the resulting output. We will always include such 
 *  lines in our programs and encourage you to do the same.
 *
 *************************************************************************/

import java.util.Random;

public class HelloWorld {
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

    public static void main(String[] args) {
        System.out.println("Hello, World");
	HelloWorld inst = new HelloWorld();

	// Test 1	
	int res = inst.testSum(100);
	System.out.println("Sum = " + res); 

	// Test 2
	int[] ia = new int[200];
	for (int i = 0; i < 200; i++)
		ia[i] = i;
	res = inst.testArraySum(ia);
	System.out.println("Array sum = " + res); 

	// Test 3
	int N = 100000;
	Random r = new Random();
	ia = new int[N];
	for (int i = 0; i < N; i++)
		ia[i] = r.nextInt();
	inst.testSort(ia);
	if (false) {	
	for (int i = 0; i < N; i++)
		System.out.print(ia[i] + " ");
	System.out.println();
	}
	System.out.println("Sorting done, N = " + N);
    }
}

