package com.website.objects_and_classes.task4;

public class LogicTrains {


    private  void swap(Train train1, Train train2){
        Train temp=train1;
        train1=train2;
        train2=train1;
    }
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

                swap(trains[maxIndex],trains[trains.length - i - 1]);

                /*Train temp= trains[maxIndex];
                trains[maxIndex] = trains[trains.length - i - 1];
                trains[trains.length - i - 1] = temp;*/

                if (minIndex == trains.length - i - 1) {
                    minIndex = maxIndex;
                }

                swap(trains[minIndex],trains[i]);
                /*temp=trains[minIndex];
                trains[minIndex] = trains[i];
                trains[i] = temp;*/
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

        if (trains.length == 0) {
            return;
        }

        for (int i = 0; i < trains.length - i; i++) {

            String min = trains[i].getDestination();
            int minIndex = i;
            String max = trains[i].getDestination();
            int maxIndex = i;

            for (int j = i + 1; j < trains.length - i; j++) {
                if (trains[j].getDestination().compareTo(max) > 0) {
                    max = trains[j].getDestination();
                    maxIndex = j;
                } else {
                    if (trains[j].getDestination().compareTo(min) <0) {
                        min = trains[j].getDestination();
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

    private  void sortTrainsByTime(Train[] trains, int start, int end) {

        if(start==end){
            return;
        }

        for (int i = start; i <= end; i++) {
            for (int j = start; j < end - i ; j++) {

                    if (trains[j].getDate().compareTo(trains[j + 1].getDate()) >0 ) {
                        Train temp = trains[j];
                        trains[j] = trains[j + 1];
                        trains[j + 1] = temp;
                    }



            }
        }



    }


}
