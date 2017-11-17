package com.fgm.exercise;

import com.fgm.exercise.codefights.arrays.Arrays;
import org.junit.Test;

/**
 * Created by fogd on 15.06.17.
 */
public class CodeFightsTests {


    @Test
    public void testArrayMaxConsecutiveSum2() {
        int[] arrayInteger = {-2, 2, 5, -11, 6};

        int result = Arrays.arrayMaxConsecutiveSum2(arrayInteger);

        System.out.println(result);
    }

    @Test
    public void testFindLongestSubarrayBySumMine(String[] args) {
        int[] arrayInteger = {1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10};

        int[] result = Arrays.findLongestSubarrayBySumMine(15, arrayInteger);

        System.out.println(result);
    }

    @Test
    public void testMatrixElementsSum() {
        int[][] matrixInteget = {{0, 1, 1, 2}, {0, 5, 0, 0}, {2, 0, 3, 3}};

        System.out.println(Arrays.matrixElementsSum(matrixInteget));
    }

    @Test
    public void testAlmostIncreasingSequence() {
        int[] arrayInteger = {1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10};

        System.out.println(Arrays.almostIncreasingSequence(arrayInteger));
    }

    @Test
    public void testIsCryptSolution() {
        String[] crypt = {"SEND", "MORE", "MONEY"};
        char[][] solution = {{'O', '0'}, {'M', '1'}, {'Y', '2'}, {'E', '5'}, {'N', '6'}, {'D', '7'}, {'R', '8'}, {'S', '9'}};

        Arrays.isCryptSolution(crypt, solution);
    }

    @Test
    public void testCommonCharacterCount() {
        String s1 = "aabcc";
        String s2 = "adcaa";

        System.out.println(Arrays.commonCharacterCount(s1, s2));
    }

    @Test
    public void testSortByHeight() {
        int[] arrayInteger = {1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10};

        System.out.println(Arrays.sortByHeight(arrayInteger));
    }

    @Test
    public void testHasPairSum() {
        int[] pairSum = {1, 2, 3, 7, 4};

        System.out.println(Arrays.hasPairSum(pairSum, 8));
    }

    @Test
    public void testReverseParentheses() {

        System.out.println(Arrays.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }


}
