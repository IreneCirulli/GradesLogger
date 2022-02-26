package com.company;

public class Grades {

    private String name;
    private String marks;
    private String totalmarks;
    static String average;
    static String finalmarks;
    static String allmarks;

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
        if(finalvalue == 0 && finalvalue < 15)
            result = 1;
        else if(finalvalue >= 15 && finalvalue < 30)
            result = 2;
        else if(finalvalue >= 30 && finalvalue < 40)
            result = 3;
        else if(finalvalue >= 40 && finalvalue < 50)
            result = 4;
        else if(finalvalue >= 50 && finalvalue < 60)
            result = 5;
        else if(finalvalue >= 60 && finalvalue < 70)
            result = 6;
        else
            result = 7;

       String answer = String.valueOf(result);
        return answer;

    }

}
