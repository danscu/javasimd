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

public class H1 {
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

    private int primeCount(int range) {
	int count = 0;
	int number;
	int i;

	for (number = 2; number <= range; number++) {
		boolean isPrime = true;
		// test prime by definition
		for (i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime)
			count++;
	}

	return count;
    }

    private int factorial(int number) {
	int i, result = 1;
	for(i = 1 ; i <= number; i++)
	{
		result = result * i;
	}
	return result;
    }

    private int gcd(int a, int b) {
	int temp;	
	while(b != 0){
		temp = b;
		b = a % b;
		a = temp;
	}
	return a;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World");
	H1 inst = new H1();

	// Test 1	
	int res = inst.testSum(100);
	System.out.println("Sum = " + res); 

	// Test 2
	int[] ia = new int[100];
	for (int i = 0; i < 100; i++)
		ia[i] = i;
	res = inst.testArraySum(ia);
	System.out.println("Array sum = " + res); 

	// Test 4 - Prime Count

	int i, facresult;
	long startMs = System.currentTimeMillis();
	final int primeRange = 100000;
	int count = inst.primeCount(primeRange);
	long durationMs = System.currentTimeMillis() - startMs;
	System.err.println(durationMs);
	System.out.println("There are " + count + " primes <= " + primeRange);

	// Test 5

	for(i = 1; i < 10; i++)
	{
		facresult = inst.factorial(i);
		System.out.println(facresult);
	}

	// Test 6
	
	int res2 = inst.gcd(2322, 654);
	System.out.println("The GCD of 2322 and 654 is " + res2);
    }
}

