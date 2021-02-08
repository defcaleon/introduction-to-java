package com.website.objects_and_classes.task4;

public class View {

    public void showTrains(Train[] trains){

        for(Train i: trains){
            System.out.println(i.toString());
        }
    }

}
