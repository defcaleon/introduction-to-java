package com.website.objects_and_classes.task4;

import java.util.Date;
import java.util.Objects;

public class Train {

    private String destination="";
    private String trainNum="";
    private Date date = new Date();

    public Train(){

    }

    public Train(String destination, String trainNum, Date date) {

        this.destination = destination;
        this.trainNum = trainNum;
        this.date = date;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        if(this.trainNum==train.trainNum&&this.date==train.date&&this.destination==train.destination)
        {
        return  true;
        }else
        {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, trainNum, date);
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", trainNum='" + trainNum + '\'' +
                ", date=" + date.getHours()+":"+date.getMinutes() +
                '}';
    }
}
