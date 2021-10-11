package com.leetcode;

public class Solution_273 {
    String hundred = "Hundred";
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        StringBuilder str = new StringBuilder();
        helper(str, num, 0);
        return str.toString().trim();
    }

    private void helper(StringBuilder str, int num, int i) {
        if (num == 0)
            return;
        helper(str, num / 1000, i + 1);
        int n = num % 1000;
        if (n == 0)
            return;
        if (n >= 100) {
            str.append(' ').append(singles[n / 100]).append(' ').append(hundred);
            n = n % 100;
        }
        if (n > 0) {
            str.append(' ');
            helper(str, n);
        }
        if (i > 0)
            str.append(' ').append(thousands[i]);
    }

    private void helper(StringBuilder str, int n) {
        if (n < 10)
            str.append(singles[n]);
        else if (n < 20)
            str.append(teens[n - 10]);
        else if (n < 100) {
            int a = n / 10;
            int b = n % 10;
            if (b == 0) {
                str.append(tens[a]);
            } else {
                str.append(tens[a]).append(' ').append(singles[b]);
            }
        }
    }

//    private String helper(int n) {
//        if (n == 0)
//            return "";
//        else if (n < 10)
//            return singles[n];
//        else if (n < 20)
//            return teens[n - 10];
//        else if (n < 100) {
//            int a = n / 10;
//            int b = n % 10;
//            return b == 0 ? tens[a] : tens[a] + " " + singles[b];
//        } else {
//            if (n % 100 == 0) {
//                return singles[n / 100] + ' ' + hundred;
//            }
//            return singles[n / 100] + ' ' + hundred + ' ' + helper(n % 100);
//        }
//    }
}
