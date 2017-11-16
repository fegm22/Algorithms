package com.fgm.exercise.hackerrank.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KMostFrequent {

    public static void main(String[] args) {

        int k = 2;
        String sequence = "aabcd";

        System.out.println(kMostFrequent(sequence.length(), k, sequence));

    }

    public static String kMostFrequent(int length, int k, String sequence) {

        int abc[] = new int[26];
        int maxFrecuency = 0;

        for (int i = 0; i < length; i++) {
            char character = sequence.charAt(i);
            int frec = ++abc[character - 'a'];
            if (frec > maxFrecuency) maxFrecuency = frec;
        }

        Map<Integer, List<String>> listFrecuencias = new HashMap<>();

        for (int i = 0; i < abc.length; i++) {
            if (abc[i] > 0) {
                if (listFrecuencias.get(abc[i]) == null) {
                    List<String> frecCharNew = new ArrayList<String>();
                    frecCharNew.add(String.valueOf((char) (i + 'a')));
                    listFrecuencias.put(abc[i], frecCharNew);
                } else {
                    List<String> frecCharExist = listFrecuencias.get(abc[i]);
                    frecCharExist.add(String.valueOf((char) (i + 'a')));
                }
            }
        }

        Set<Integer> setFrencuency = listFrecuencias.keySet();

        List<Integer> sortedFrecuency = new ArrayList(setFrencuency);
        Collections.sort(sortedFrecuency,  Collections.reverseOrder());

        List<String> result = null;
        for(int i=0; i<sortedFrecuency.size(); i++){
            if(i+1==k){
                result = listFrecuencias.get(sortedFrecuency.get(i));
            }
        }


        if (result== null  || result.isEmpty()) {
            return "NONE";
        } else {
            if (result.size() > 1) {

                Collections.sort(result);
                return result.get(0);

            } else {
                return result.get(0);
            }
        }
    }


    public static String kMostFrequent2(int length, int k, String sequence) {

        int abc[] = new int[26];
        int maxFrecuency = 0;

        for (int i = 0; i < length; i++) {
            char character = sequence.charAt(i);
            int frec = ++abc[character - 'a'];
            if (frec > maxFrecuency) maxFrecuency = frec;
        }

        List<String>[] listFrecuencias = new List[maxFrecuency + 1];

        for (int i = 0; i < abc.length; i++) {
            if (abc[i] > 0) {
                if (listFrecuencias[abc[i]] == null) {
                    List<String> frecCharNew = new ArrayList<>();
                    frecCharNew.add(String.valueOf((char) (i + 'a')));
                    listFrecuencias[abc[i]] = frecCharNew;
                } else {
                    List<String> frecCharExist = listFrecuencias[abc[i]];
                    frecCharExist.add(String.valueOf((char) (i + 'a')));
                }
            }
        }

        List<String> result = listFrecuencias[k];

        if (result.isEmpty()) {
            return "NONE";
        } else {
            if (result.size() > 1) {

                Collections.sort(result);
                return result.get(0);

            } else {
                return result.get(0);
            }
        }
    }

}
