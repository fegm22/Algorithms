package com.fgm.exercise.codefights.stacks;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecodeString {

    public static void main(String[] args) {
        String decode = "2[b3[a]]";
        DecodeString dec = new DecodeString();

        System.out.println(dec.decodeString(decode));
    }

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack();
        Stack<StringBuilder> strStack = new Stack();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = curr;
                curr = strStack.pop();
                for (int i = intStack.pop(); i > 0; i--) {
                    curr.append(tmp);
                }
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }

    public String decodeStringRegex(String s) {

        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("[0-9]|[a-zA-Z]");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            matcher.find();
            while (num-- != 0) {
                sb.append(matcher.group());
            }
        }

        return sb.toString();
    }
}
