package com.company;

public class Grades {

    private String name;
    private String marks;
    private String totalmarks;
    static String average;
    static String finalmarks;
    static String allmarks;
    static double oneg = 15.0;
    static double twog = 30.0;
    static double threeg = 40.0;
    static double fourg = 50.0;
    static double fiveg = 60.0;
    static double sixg = 70.0;

    public Grades(String name, String marks, String totalmarks) {
        this.name = name;
        this.marks = marks;
        this.totalmarks = totalmarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(String totalmarks) {
        this.totalmarks = totalmarks;
    }

    public String getPercentage() {

        double marks1 = Double.parseDouble(marks);
        double totalmarks1 = Double.parseDouble(totalmarks);
        double perc = (marks1/totalmarks1) * 100;
        String answer = String.valueOf(perc);
        return answer;
    }

    public static String getFinalMark(String finals){
        double finalvalue = Double.parseDouble(finals);
        double result;
        if(finalvalue >= 0 && finalvalue < oneg)
            result = 1;
        else if(finalvalue >= oneg && finalvalue < twog)
            result = 2;
        else if(finalvalue >= twog && finalvalue < threeg)
            result = 3;
        else if(finalvalue >= threeg && finalvalue < fourg)
            result = 4;
        else if(finalvalue >= fourg && finalvalue < fiveg)
            result = 5;
        else if(finalvalue >= fiveg && finalvalue < sixg)
            result = 6;
        else
            result = 7;

       String answer = String.valueOf(result);
        return answer;

    }

}
