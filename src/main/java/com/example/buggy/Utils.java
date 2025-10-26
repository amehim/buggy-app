package com.example.buggy;

public class Utils {

    // Magic number and poor naming
    public int calc(int x) {
        int result = x * 42; // 42 = magic number
        return result;
    }

    // Unused method
    public void deadMethod() {
        System.out.println("I am never used!");
    }

    // Poor null handling
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString(); // Risk of NPE
    }
}
