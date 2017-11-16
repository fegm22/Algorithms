package com.fgm.exercise.hackerrank.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberNeeded {

    public static int numberNeeded(String first, String second) {
        Map<String, Integer> mapFirst =  new HashMap<>();
        Map<String, Integer> mapSecond = new HashMap<>();
        Set<String> letters = new HashSet<>();

        for(int i=0; i<first.length(); i++){
            String letter = String.valueOf(first.charAt(i));
            if(mapFirst.containsKey(letter)){
                int count = mapFirst.get(letter);
                mapFirst.put(letter, ++count);
            }else{
                mapFirst.put(letter, 1);
            }
            letters.add(letter);
        }
        for(int i=0; i<second.length(); i++){
            String letter = String.valueOf(second.charAt(i));
            if(mapSecond.containsKey(letter)){
                int count = mapSecond.get(letter);
                mapSecond.put(letter, ++count);
            }else{
                mapSecond.put(letter, 1);
            }
            letters.add(letter);
        }

        int sum = 0;
        for(String l : letters){
            int letterFirst = 0;
            int letterSecond = 0;
            if(mapFirst.containsKey(l)){
                letterFirst = mapFirst.get(l);
            }
            if(mapSecond.containsKey(l)){
                letterSecond = mapSecond.get(l);
            }

            sum = sum + Math.abs(letterFirst-letterSecond);

        }

        return sum;

    }

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(numberNeeded(a, b));
    }
}
