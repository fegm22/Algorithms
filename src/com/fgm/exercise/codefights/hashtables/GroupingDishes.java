package com.fgm.exercise.codefights.hashtables;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupingDishes {

    /**
     *
        Input:
                dishes: [["Salad","Tomato","Cucumber","Salad","Sauce"],
                        ["Pizza","Tomato","Sausage","Sauce","Dough"],
                        ["Quesadilla","Chicken","Cheese","Sauce"],
                        ["Sandwich","Salad","Bread","Tomato","Cheese"]]

        Expected Output:
                        [["Cheese","Quesadilla","Sandwich"],
                        ["Salad","Salad","Sandwich"],
                        ["Sauce","Pizza","Quesadilla","Salad"],
                        ["Tomato","Pizza","Salad","Sandwich"]]
     *
     *
     */

    public static void main(String[] args) {

        String[][] dishes = {
                {"Salad","Tomato","Cucumber","Salad","Sauce"},
                {"Pizza","Tomato","Sausage","Sauce","Dough"},
                {"Quesadilla","Chicken","Cheese","Sauce"},
                {"Sandwich","Salad","Bread","Tomato","Cheese"}
            };

        String[][] expectedDishes = {
                {"Cheese","Quesadilla","Sandwich"},
                {"Salad","Salad","Sandwich"},
                {"Sauce","Pizza","Quesadilla","Salad"},
                {"Tomato","Pizza","Salad","Sandwich"}
        };


        String[][] groupDishes = groupingDishes(dishes);

        Assert.check( equal(groupDishes, expectedDishes) );

    }

    public static String[][] groupingDishes(String[][] dishes) {

        HashMap<String, HashSet<String>> ingredients = new HashMap<>();
        HashMap<String, HashSet<String>> ingredientsFinal = new HashMap<>();

        for(int i=0; i<dishes.length; i++) {

            for(int j=1; j<dishes[i].length; j++) {

                if( ingredients.containsKey( dishes[i][j] ) ) {
                    HashSet<String> existingFood = ingredients.get( dishes[i][j] );
                    existingFood.add( dishes[i][0] );
                    ingredients.put( dishes[i][j], existingFood );
                    ingredientsFinal.put( dishes[i][j], existingFood );
                } else {
                    HashSet<String> newFood = new HashSet<>();
                    newFood.add( dishes[i][0] );
                    ingredients.put( dishes[i][j], newFood );
                }
            }
        }

        List<String> sortedIngredients = getSortedSet(ingredientsFinal.keySet());

        String[][] groupDishes = new String[ingredientsFinal.size()][];
        int i=0;

        for (String dish : sortedIngredients) {
            Set<String> foods = ingredientsFinal.get(dish);

            String[] arrayFood = new String[foods.size()+1];
            arrayFood[0] = dish;

            int j=1;
            List<String> sortedFoods = getSortedSet(foods);

            for( String food : sortedFoods ){
                arrayFood[j++] = food;
            }

            groupDishes[i++] = arrayFood;

        }

        return groupDishes;

    }

    private static List<String> getSortedSet(Set<String> strings) {
        List<String> sortedIngredients = new ArrayList(strings);
        Collections.sort(sortedIngredients);
        return sortedIngredients;
    }

    public static boolean equal(final String[][] arr1, final String[][] arr2) {

        if (arr1 == null) {
            return (arr2 == null);
        }

        if (arr2 == null) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {

            if ( !Arrays.equals(arr1[i], arr2[i]) ) {
                return false;
            }
        }
        return true;
    }

}