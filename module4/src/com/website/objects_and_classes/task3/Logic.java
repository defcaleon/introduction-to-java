package com.website.objects_and_classes.task3;

public class Logic {

    public void printBestStudents(Student[] stud, int minMark ) {

        System.out.println("Students with marks higher/equal than: "+minMark);

       for(Student i:stud){

           if(bestAchievement(i.getMarks(),minMark))
           {
               System.out.println(i.toString());
           }

       }

    }

    private boolean bestAchievement(int[] marks, int minMark){

        for(int i:marks){

            if(i<minMark){
                return false;
            }

        }

        return true;
    }

}
