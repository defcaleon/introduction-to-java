package com.website.objects_and_classes.task4;


public class Main {

    public  static  void  main(String[] args){

        final  int TRAINARRSIZE=5;

        Train[] trains = new Train[TRAINARRSIZE];

        //инициализация массива поездов
        TrainInitial init = new TrainInitial();
        init.trainsInit(trains, trains.length);

        //Класс для вывода массива поездов
        View show = new View();

        show.showTrains(trains);

        LogicTrains logic = new LogicTrains();

        logic.sortByTrainNames(trains);

        System.out.println("===================");
        show.showTrains(trains);


    }




}
