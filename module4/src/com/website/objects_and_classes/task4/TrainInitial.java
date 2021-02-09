package com.website.objects_and_classes.task4;

import java.util.Date;

public class TrainInitial {

    public Train[] trainsInit(Train[] trains,int arrSize){



        for(int i=0;i<arrSize;i++){

            trains[i]=new Train();
            Date date = new Date();

            switch (i){
                case 0:{

                    trains[i].setTrainNum("ccc");
                    //trains[i].setDestination("Minsk");
                    trains[i].setDestination("Moscow");
                    date.setHours(14);
                    date.setMinutes(28);
                    trains[i].setDate(date);
                    break;

                }
                case 1:{
                    trains[i].setTrainNum("bbb");
                    trains[i].setDestination("Moscow");
                    date.setHours(15);
                    date.setMinutes(36);
                    trains[i].setDate(date);
                    break;
                }
                case 2:{
                    trains[i].setTrainNum("xxx");
                    trains[i].setDestination("Praga");
                    date.setHours(19);
                    date.setMinutes(11);
                    trains[i].setDate(date);
                    break;
                }
                case 3:{
                    trains[i].setTrainNum("zzz");
                    trains[i].setDestination("Berlin");
                    date.setHours(22);
                    date.setMinutes(44);
                    trains[i].setDate(date);
                    break;
                }
                case 4:{
                    trains[i].setTrainNum("aaa");
                    trains[i].setDestination("Warsaw");
                    date.setHours(20);
                    date.setMinutes(20);
                    trains[i].setDate(date);
                    break;
                }

            }
        }

        return  trains;
    }
}
