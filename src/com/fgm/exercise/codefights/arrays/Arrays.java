package com.fgm.exercise.codefights.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class Arrays {

    public static int arrayMaxConsecutiveSum2(int[] inputArray) {
        //Kadane's algorithm
        int maxC = inputArray[0];
        int maxG = maxC;

        for(int i=1; i<inputArray.length; i++ ) {
            maxC = maxValue(inputArray[i], inputArray[i] + maxC);
            maxG = maxValue(maxC, maxG);
        }
        return maxG;
    }

    public static int maxValue(int actual, int acumulado){
        return actual > acumulado ? actual : acumulado;
    }

    public static int[] findLongestSubarrayBySum3(int s, int[] arr) {
        int maxL = -1, maxR = -1, sum = 0, r = 0, l = 0;

        while(r < arr.length)
        {
            sum += arr[r++];
            while(sum > s)
            {
                sum -= arr[l++];
            }
            if(sum == s)
            {
                if(r - l > maxR - maxL)
                {
                    maxL = l;
                    maxR = r;
                }
            }
        }

        return maxL < 0 ? new int[] { -1 } : new int[] {maxL + 1, maxR};
    }

    public static int[] findLongestSubarrayBySumMine(int s, int[] arr) {
        int[] presuma = preSum(arr);
        int leftIndex = 0;
        int rigthIndex = 0;
        int maxRigth = -1;
        int maxLeft = -1;

        for(int i=1; i<presuma.length; i++){
            rigthIndex++;
            while(presuma[rigthIndex]-presuma[leftIndex-1]>s ){
                leftIndex++;
            }

            if(presuma[rigthIndex]-presuma[leftIndex-1]==s){
                if((rigthIndex-leftIndex)>(maxRigth-maxLeft)){
                    maxRigth = rigthIndex;
                    maxLeft = leftIndex;
                }
            }
        }

        return maxRigth<0 ? new int[]{-1} : new int[]{maxLeft, maxRigth};
    }

    static int[] preSum(int[] arr){
        int[] suma = new int[arr.length+1];
        suma[0] = 0;
        for(int i=1; i<=arr.length; i++){
            suma[i] = suma[i-1] + arr[i-1];
        }
        return suma;
    }


    public static int[] findLongestSubarrayBySum(int s, int[] arr) {
        int L = 0, R = 0, sum = 0;
        int bestLen = 0, bestL = -1, bestR = -1;
        while (true) {
            if (sum == s && R-L > bestLen) {
                bestR = R; bestL = L; bestLen = R-L;
            }
            if (sum > s) sum -= arr[L++];
            else {
                if (R == arr.length) break;
                sum += arr[R++];
            }
        }
        return bestLen == 0 ? new int[]{-1} : new int[]{bestL+1,bestR};
    }

    public static int[] findLongestSubarrayBySum2(int s, int[] arr) {
        int[] longest = new int[]{-1, -2};

        int left = 0, right = 0;
        int sum = 0;

        while (right < arr.length) {
            sum += arr[right];

            while (sum > s && left <= right) sum -= arr[left++];

            if (sum == s && right - left > longest[1] - longest[0]) {
                longest[0] = left+1;
                longest[1] = right+1;
            }

            right++;
        }

        if (longest[0] == -1 || longest[1] == -1) return new int[]{-1};

        return longest;
    }


    static String[] addBorder(String[] picture) {

        String[] frame = new String[picture.length + 2];

        for(int i=0; i<frame.length; i++){
            if(i==0 || i==frame.length-1) {
                frame[i] = new String(new char[picture.length + 2]).replace("\0", "*");
            }else{
                frame[i] = "*" + picture[i-1]  + "*";
            }
        }

        return frame;
    }


    public static boolean isCryptSolution(String[] crypt, char[][] solution) {

        HashMap<Character, Integer> deco = new HashMap<>();
        int sum = 0;

        for(int i=0; i<solution.length; i++){
            deco.put(solution[i][0], Character.getNumericValue(solution[i][1]));
        }


        for(int i=0; i<crypt.length; i++){
            String word = crypt[i];
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<word.length(); j++){
                Character letra = word.charAt(j);
                Integer num = deco.get(letra);
                if(num!=null){
                    sb.append(num);
                }else{
                    return false;
                }
            }
            int valor = Integer.valueOf(sb.toString());
            if(i<2) {
                sum=sum + valor;
            }else {
                sum = sum - valor;
            }
        }

        if(sum == 0) return true;

        return false;

    }

    public static boolean hasPairSum(int[] a, int sum){
        HashSet<Integer> comp = new HashSet<>();

        for(int i=0; i<a.length; i++){
            if( comp.contains(a[i]) ) return true;
            comp.add(sum - a[i]);
        }
        return false;
    }

    public static String reverseParentheses(String s) {
        boolean flag = false;
        StringBuilder rever = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            int j=0;
            if(s.charAt(i)==')'){
                rever = new StringBuilder();
                j=i-1;
                while (j>=0 && s.charAt(j)!='('){
                    rever.append(s.charAt(j));
                    j--;
                }
                flag = true;
            }
            if(flag){
                s = s.substring(0,j) + rever + s.substring(i+1,s.length());
                flag = false;
                i=i-2;
            }
        }
        return s;
    }

    //[1, 3, -1, 23, 43, -1, -1, 54, -1, -1, -1, 77]
    public static int[] sortByHeight(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            if(a[i]==-1) {
                continue;
            }
            int j = i;
            int pivot = j;

            while ( j > 0  && ( a[j - 1] > a[pivot] || a[j - 1] ==-1 ) ) {
                if(a[pivot]==-1 || a[j - 1]==-1){
                    --j;
                    continue;
                }
                swap(a, pivot, j - 1);
                pivot=j-1;
                --j;
            }
        }
        return a;
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private static void showArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + "  ");
        }
    }

    public static int commonCharacterCount(String s1, String s2) {
        int suma = 0;

        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            for(int j=0; j<s2.length(); j++){
                char c2 = s2.charAt(j);
                if(c1 == c2){
                    s2 = s2.replaceFirst(String.valueOf(c2), " ");
                    suma++;
                }
            }
        }
        return suma;
    }


    public static int matrixElementsSum(int[][] matrix) {
        int suma = 0;
        for(int j=0; j<matrix[0].length; ++j){
            for(int i=0; i<matrix.length; ++i){
                if(matrix[i][j]!=0){
                    suma= suma + matrix[i][j];
                }else{
                    break;
                }
            }
        }
        return suma;
    }

    public static boolean almostIncreasingSequence(int[] sequence) {
        int length = sequence.length;
        if(length ==1) return true;
        if(length ==2 && sequence[1] > sequence[0]) return true;
        int count = 0;
        int index = 0;
        boolean iter = true;

        while(iter){
            index = checkSequence(sequence,index);
            if(index != -1){
                count++;
                index++;
                if(index >= length-1){
                    iter=false;
                }else if(index-1 !=0){
                    if(sequence[index-1] <= sequence[index]){
                        iter=false;
                        count++;
                    }else if(((sequence[index] <= sequence[index-2])) && ((sequence[index+1] <= sequence[index-1]))){
                        iter=false;
                        count++;
                    }
                }
            }else{
                iter = false;
            }
        }
        if(count > 1) return false;
        return true;
    }

    private static int checkSequence(int[] sequence, int index){
        for(; index < sequence.length-1; index++){
            if(sequence[index+1] <= sequence[index]){
                return index;
            }
        }
        return -1;
    }
}
