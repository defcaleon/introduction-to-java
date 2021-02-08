package com.website.objects_and_classes.task3;

import java.util.Random;

public class Initialization {

        public Student[] initStudent(String groupNum){

            final int NUMOFSTUDENTS=10;
            final  int NUMOFMARKS=5;

            Student[] stud=new Student[NUMOFSTUDENTS];

            for (int i=0;i< stud.length-2;i++) {

                stud[i]= new Student();

                stud[i].setGroupNumber(groupNum);
                stud[i].setFIO("stud "+(i+1));

                int[] marks = new int[NUMOFMARKS];

                Random rand = new Random();

                for (int j = 0; j < marks.length; j++) {
                    marks[j] = rand.nextInt(10)+1;
                }

                stud[i].setMarks(marks);
            }

            stud[stud.length-2]=new Student("stud "+(stud.length-2),groupNum, new int[]{9, 9, 9, 9, 9});
            stud[stud.length-1]=new Student("stud "+(stud.length-1),groupNum, new int[]{10, 9, 10, 9, 9});


            return  stud;
        }


}
