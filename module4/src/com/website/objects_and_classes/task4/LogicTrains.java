package com.website.objects_and_classes.task4;

public class LogicTrains {


    private  void swap(Train[] trains, int index1, int index2){
        Train temp=trains[index1];
        trains[index1]=trains[index2];
        trains[index2]=temp;
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

                swap(trains,maxIndex,trains.length - i - 1);

                if (minIndex == trains.length - i - 1) {
                    minIndex = maxIndex;
                }

                swap(trains,minIndex,i);

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

            swap(trains,minIndex,i);

            if (minIndex == trains.length - i - 1) {
                minIndex = maxIndex;
            }

            swap(trains,minIndex,i);
        }

        int i=0;
        while (i<trains.length){

            int end=getEndWithSameDestination(trains,i);

            sortTrainsByTime(trains,i,end);

            i=end;
        }

    }

    private int getEndWithSameDestination(Train[] trains,int start){

        if(start>=trains.length)
        {
            return  -1;
        }


        int end=start;
        String compDestin=trains[start].getDestination();

        end++;
        while (end< trains.length&&compDestin.compareTo(trains[end].getDestination())==0){
            end++;
        }

        return  end;
    }

    private  void sortTrainsByTime(Train[] trains, int start, int end) {


        System.out.println(trains[start].getDestination()+" "+start+" "+end);
        if(start+1==end){
            return;
        }

        for (int i = start; i < end; i++) {
            for (int j = start; j < end - i-1 ; j++) {

                    if (trains[j].getDate().compareTo(trains[j + 1].getDate()) >0 ) {
                        swap(trains,j,j+1);
                    }

            }
        }



    }


}
