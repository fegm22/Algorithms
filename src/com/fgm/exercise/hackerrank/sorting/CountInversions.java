package com.fgm.exercise.hackerrank.sorting;

import java.util.Scanner;

public class CountInversions {
    
    public static long count = 0;

    static long countInversions(int arr[]) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length-1);
        return count;
    }
    
    static void mergeSort(int arr[], int aux[], int low, int high){
        if(low >= high) return;
        
        int middle = (low+high)/2;
        
        mergeSort(arr, aux, low, middle);
        mergeSort(arr, aux, middle+1, high);
        merge(arr, aux, low, middle, high);       
    }
    
    static void merge(int arr[], int aux[], int low, int middle, int high){
        
        for(int i=low; i<=high; i++){
            aux[i] = arr[i];
        }

        count++;

        int left = low;
        int right = middle +1;
        int index = low;
        
        while(left<=middle && right<=high){
            if(aux[left] <= aux[right]){
                arr[index] = aux[left];
                left++;
            }else{
                arr[index] = aux[right];
                right++;
            }
            index++;
        }
        
        while(left<=middle){
            arr[index] = aux[left];
            left++;
            index++;
        }
        while(right<=high){
            arr[index] = aux[right];
            right++;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] arrayInteger = {2, 1, 3, 1, 2};
        long result = countInversions(arrayInteger);
        System.out.println(result);



    }

}

