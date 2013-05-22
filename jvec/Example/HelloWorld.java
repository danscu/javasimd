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
    }
}

