package com.website.objects_and_classes.task3;

public class View {

    public  void  printAllStudents(Student[] stud){
        for(Student i:stud)
        {
            System.out.println(i.toString());
        }
    }
}
