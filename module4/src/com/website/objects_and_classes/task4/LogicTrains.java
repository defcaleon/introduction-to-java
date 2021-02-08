package com.website.objects_and_classes.task4;

public class LogicTrains {

    public void sortByTrainNames(Train[] trains){

            if (trains.length == 0) {
                return;
            }

            for (int i = 0; i < trains.length - i; i++) {

                String min = trains[i].getTrainNum();
                int minIndex = i;
                String max = trains[i].getTrainNum();
                int maxIndex = i;

                for (int j = i + 1; j < trains.length - i; j++) {
                    if (trains[j].getTrainNum().compareTo(max) > 0) {
                        max = trains[j].getTrainNum();
                        maxIndex = j;
                    } else {
                        if (trains[j].getTrainNum().compareTo(min) <0) {
                            min = trains[j].getTrainNum();
                            minIndex = j;
                        }
                    }

                }

                Train temp= trains[maxIndex];
                trains[maxIndex] = trains[trains.length - i - 1];
                trains[trains.length - i - 1] = temp;

                if (minIndex == trains.length - i - 1) {
                    minIndex = maxIndex;
                }

                temp=trains[minIndex];
                trains[minIndex] = trains[i];
                trains[i] = temp;
            }
    }

    public void findTrainByTrainNumber(Train[] trains, String trainNum){



        for (Train i: trains){

            if(i.getTrainNum().compareTo(trainNum)==0){
                System.out.println(i.toString());
                return;
            }
        }

        System.out.println("Not found");
    }

    public void sortTrainsByDestinatination(Train[] trains){

    }

    private  void sortTrainsByTime(Train[] trains, int start, int end){

    }
}
