package com.fgm.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonCodeTest {

    public static class OOP {

        public interface Shape {

            void resize(Point a, Point b);

            int getArea();

            int getPerimeter();
        }

        public class Point {
            public int x;
            public int y;
        }


        public class Line implements Shape {
            public Point begin;
            public Point end;


            public void resize(Point newBegin, Point newEnd) {
                begin = newBegin;
                end = newEnd;
            }

            public int getPerimeter() {
                return 0;
            }

            public int getArea() {
                return 0;
            }
            //The other methods to overwrite of the interface

        }

        public class Circle implements Shape {
            Point center;
            Integer radius;

            public void resize(Point newCenter, Point pointRadius) {
                center = newCenter;
                radius = (pointRadius.x - pointRadius.x);
            }

            public int getPerimeter() {
                return 0;
            }

            public int getArea() {
                return 0;
            }
        }

        public class Rectangle implements Shape {
            Point vertexA;
            Point vertxB;

            public void resize(Point newBegin, Point newEnd) {
                vertexA = newBegin;
                vertxB = newEnd;
            }

            public int getPerimeter() {
                return 0;
            }

            public int getArea() {
                return 0;
            }
        }

    }


//    Setup:
//    Assume primitive Facebook. FB has Members.
//    class Member {
//        String name;
//        String email;
//        List<Member> friends;
//    }
//
//    Question:
//    Code printSocialGraph(Member m). Direct friends of m are Level 1 friends. Friends of friends are level 2 friends.....and so on
//    Print level 1 friends first. Then print level 2 friends....and so on
//
//    void printSocialGraph (Member m){
//
//        //Your code here
//
//    }

    public class Member {
        String name;
        String email;
        List<Member> friends;
    }

    public void printSocialGraph(Member m) {

    }

//    Write an efficient function that returns the n’th Fibonacci number (There are many ways to solve this problem. Please write the most efficient method possible).
//    Each Fibonacci number is the sum of the last two.  The first 10 are: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.
//    long getNthFibonacci(long i) { ... }

    public static long getNthFibonacci(long i) {
        long seq[] = new long[(int) i];

        seq[0] = seq[1] = 1;

        for (int n = 2; n < i; n++) {
            seq[n] = seq[n - 1] + seq[n - 2];
        }
        return seq[(int) i - 1];
    }

    public static long getNthFibonacci2(long i) {

        if (i == 1 || i == 2) return 1;
        long aux1 = 1;
        long aux2 = 1;

        long sum = 0;
        for (int n = 2; n < i; n++) {
            sum = aux1 + aux2;
            aux1 = aux2;
            aux2 = sum;
        }

        return sum;
    }

    public static int modifiedAnagrams(String a, String b) {
        int count = 0;
        if (a.length() != b.length()) {
            return -1;
        } else {
            int[] lettersA = new int[26];
            int[] lettersB = new int[26];

            for (int i = 0; i < a.length(); i++) {
                Character letterA = a.charAt(i);
                lettersA[letterA - 'a']++;
            }
            for (int j = 0; j < b.length(); j++) {
                Character letterB = b.charAt(j);
                lettersB[letterB - 'a']++;
            }

            count = 0;
            for (int z = 0; z < 26; z++) {
                count = Math.abs(lettersA[z] - lettersB[z]) + count;
            }
        }
        return count;
    }

    public static int[] amazonTestAnagrams(String[] A, String[] B) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            String a = A[i];
            String b = B[i];
            result[i] = modifiedAnagrams(a, b);
        }

        return result;
    }

    public static int[] maxCardinals(int[] nums, int[] maxes) {
        Map<Integer, Integer> mapNums = new HashMap<>();
        int maxNums = getMaximum(nums);
        int maxMaxes = getMaximum(maxes);

        for (int i = 0; i < nums.length; i++) {
            if (mapNums.containsKey(nums[i])) {
                int cont = mapNums.get(nums[i]);
                mapNums.put(nums[i], ++cont);
            } else {
                mapNums.put(nums[i], 1);
            }
        }

        int count = 0;
        int[] arrayAux = new int[maxMaxes + 1];
        for (int i = 0; i <= maxMaxes; i++) {
            if (mapNums.containsKey(i)) {
                arrayAux[i] = mapNums.get(i) + count;
                count = arrayAux[i];
            } else {
                arrayAux[i] = count;
            }
        }

        int[] result = new int[maxes.length];
        for (int i = 0; i < maxes.length; i++) {
            result[i] = arrayAux[maxes[i]];
        }

        return result;
    }

    public static int getMaximum(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 4};
        int[] maxes = {3, 5};

        int[] result = maxCardinals(nums, maxes);

        printArray(result);
    }

    public static void mainAnagram(String[] args) {
        //System.out.println(getNthFibonacci2(9));

        String[] A = new String[3];
        String[] B = new String[3];

        A[0] = "aaaabbbbccccddddhhhh";
        A[1] = "aabb";
        A[2] = "aaaccc";
        B[0] = "aaaabbbbccccddddhhhe";
        B[1] = "bbaa";
        B[2] = "aaaddd";

        int[] result = amazonTestAnagrams(A, B);

    }

}
