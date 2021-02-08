package com.website.objects_and_classes.task3;

import java.util.Arrays;

public class Student {

    private  String FIO="";
    private  String groupNumber="0";
    private  int[] marks=new int[5];

    public  Student(){

    }

    public Student(String FIO, String groupNumber, int[] marks){

        this.FIO=FIO.trim();

        if(validGroupNumber(groupNumber)){
            this.groupNumber=groupNumber;
        }

        if(validMarks(marks)){
            this.marks=marks;
        }
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {

        if(validGroupNumber(groupNumber)){
            this.groupNumber=groupNumber;
        }
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {

        if(validMarks(marks)){
            this.marks=marks;
        }
    }





    private boolean validMarks(int[] marks){

        for(int i:marks){

            if(i<=0||i>10){
                return false;
            }

        }

        return true;

    }
    public static boolean validGroupNumber(String groupNumber){

       groupNumber= groupNumber.trim();

        for(char i:groupNumber.toCharArray()) {
                if(!(i>='0'&&i<='9'))
                {
                    return false;
                }

        }
        return  true;
    }


    @Override
    public String toString() {
        return "Student{" +
                "FIO='" + FIO + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
