package com.cola.algorithm06;

public class CountSubStr {

    //回文子串
    public static int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i <= 2*n-1; i++) {
            int left = i /2;
            int right = left + i%2;
            while(left >=0 && right< n &&s.charAt(left) == s.charAt(right)){
                result ++;
                left --;
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println("回文子串" + countSubstrings(s));
    }
}
