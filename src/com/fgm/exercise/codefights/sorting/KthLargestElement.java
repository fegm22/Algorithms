package com.fgm.exercise.codefights.sorting;

public class KthLargestElement {

    public static void main(String[] args) {
//        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        int result = kthLargestElement(arr, 2);

        System.out.println(result);

    }

    static int kthLargestElement(int[] nums, int k) {
        int[] helper = new int[nums.length];

        mergeSort(nums, helper, 0, nums.length-1);

        return nums[nums.length-k];
    }

    static void mergeSort(int arr[], int aux[], int low, int high){
        if(low >= high) return;

        int middle = (high + low) / 2;

        mergeSort(arr, aux, low, middle);

        mergeSort(arr, aux, middle+1, high);

        merge(arr, aux, low, middle, high);
    }

    static void merge(int arr[], int aux[], int low, int middle, int high){

        for(int i=low; i<=high; i++){
            aux[i] = arr[i];
        }

        int left = low;
        int right = middle +1;
        int index = low;

        System.out.println("");

        System.out.println("low: " + low + " right: " + right + " middle: " + middle + " high: " + high);
        System.out.println("Pre order: ");

        printArray(aux);

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

        System.out.println("Post order: ");
        printArray(arr);

    }

    static void printArray(int[] arr){
        System.out.print("[");
        for(int i=0; i<arr.length; i++){
            if(arr[i]/10 > 0){
                System.out.print(" " + i + " ");
            }else {
                System.out.print(i + " ");
            }
        }
        System.out.print("]");

        System.out.println(" ");

        System.out.print(" ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println(" ");
    }
}