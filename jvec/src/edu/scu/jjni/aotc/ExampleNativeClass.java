package edu.scu.jjni.aotc;

public class ExampleNativeClass {
    private native int testSum(int n);

    public static void main(String[] args) {
        System.out.println("Hello, World");
        ExampleNativeClass inst = new ExampleNativeClass();
        int res = inst.testSum(100);
        System.out.println("Sum = " + res);
    }
    
    static {
        System.loadLibrary("HelloWorld");
    }

    static {
    	System.out.println("Again");
    }       
}
