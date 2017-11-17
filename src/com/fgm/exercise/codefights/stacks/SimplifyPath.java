package com.fgm.exercise.codefights.stacks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {

        String path = "/a/b/c/../..";

        System.out.println(simplifyPath(path));

        String date = "20171116";

        try {
            System.out.println(changeFormatDate(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    static String simplifyPath(String path) {

        String[] dirs = path.split("/");
        Stack<String> s = new Stack<>();

        printArray(dirs);

        for (String str : dirs) {
            if (!str.equals(".") && !str.isEmpty()) {
                if (str.equals("..")) {
                    if (!s.isEmpty())
                        s.pop();
                } else {
                    s.push(str);
                }
            }
        }

        if (s.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (String st : s) {
            res.append("/" + st);
        }

        return res.toString();
    }

    static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void printArray2(String[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public static String changeFormatDate(String date) throws ParseException {
        DateFormat dateFormat = null;

        if (date.contains("-")) {
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        } else {
            dateFormat = new SimpleDateFormat("yyyyMMdd");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNewFormat = dateFormat.parse(date);

        return formatter.format(dateNewFormat);
    }
}
