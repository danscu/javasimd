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


    static {
	System.loadLibrary("HelloWorld");
    }

    private native int testSum(int n);
    private native int testArraySum(int arr[]);

    public static void main(String[] args) {
        System.out.println("Hello, World");
	HelloWorld inst = new HelloWorld();
	int res = inst.testSum(100);
	System.out.println("Sum = " + res); 

	int arr[] = new int[40];
	for (int i = 0; i < 40; i++)
		arr[i] = i;
	res = inst.testArraySum(arr);
	System.out.println("Sum of array = " + res);
    }
}

