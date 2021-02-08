package com.website.objects_and_classes.task3;

public class Main {

    public static void main(String[] args){

        Student[] group;

        //класс для инициализации студентов
        Initialization init =new Initialization();

        group= init.initStudent("951004");

        //класс для вывода всех студентов
        View output = new View();

        output.printAllStudents(group);

        Logic logic = new Logic();

        logic.printBestStudents(group,9);


    }
}
