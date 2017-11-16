package com.fgm.exercise.hackerrank.inheritance;

public class Student extends Person{
    private int[] testScores;

    /*
    *   Class Constructor
    *
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here

    public Student(String firstName, String lastName, int id, int[] testScores){
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    /*
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here

    public String calculate() {
        double total = 0;
        double a = 0;
        for(int i=0; i<this.testScores.length; i++){
            total = total + testScores[i];
        }
        a = total / testScores.length;

        if (a < 40.0){
            return "T";
        }else if(a<=40.0 && a<55.0){
            return "D";
        }else if (a<=55.0 && a<70.0){
            return "P";
        }else if(a<=70.0 && a<80.0){
            return "A";
        }else if(a<=80.0 && a<90.0){
            return "E";
        }else if(a<=90.0 && a<=100.0){
            return "O";
        }

        return "";
    }
}