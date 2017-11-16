package com.fgm.exercise.hackerrank.arrays;

public class LeftRotation {

    public static void main(String[] args) {
        int[] a = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
        int n = 20;
        int k = 10;
        //41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51
        //77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77

        int[] newArray = new int[n];
        for(int i=0; i<n; i++){
            int newIndex = n + (i-k);
            if(newIndex>=n) newIndex = newIndex - n;
            newArray[newIndex] = a[i];
        }

        for(int i=0; i<n; i++){
            System.out.print(newArray[i] + " ");
        }
    }
}