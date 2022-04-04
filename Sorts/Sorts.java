package Sorts;// package com.foo.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
    protected ArrayList<Integer> data;
    protected int length;
    protected int size;
    protected int swaps;

    private long timeElapsed;
    private int totalSwaps;

    public Sorts(int size) {
        data = new ArrayList<>();
        length = 0;
        this.size = size;
        timeElapsed = 0;
        swaps = 0;
        totalSwaps = 0;
    }

    public void myInit(){
        // build an array
        data.clear();
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (25000)));
        }
        length = data.size();
        swaps = 0;
    }

    public ArrayList<Integer> mySort(){
        //nothing in Baseclass
        return data;
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void addTimeElapsed(Duration duration){
        timeElapsed += duration.getNano();
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void addSwaps(int swaps){
        totalSwaps += swaps;
    }

    public int getSwaps() { return totalSwaps; }

    public String myName() { return "None"; }

    public static void main(String[] args) {
        int sum=0, time=0, TIMES=12, SIZE=5000;
        ArrayList<Sorts> sortsList = new ArrayList<Sorts>();
        sortsList.add(new SelectionSort(SIZE));
        sortsList.add(new InsertionSort(SIZE));
        sortsList.add(new BubbleSort(SIZE));
        sortsList.add(new MergeSort(SIZE));
        //Duration timeElapsed;

        for(int i=0; i< TIMES; i++) {
            System.out.println("-------Round : " + i);;

            for (Sorts current : sortsList) {
                System.out.println("-- " + current.myName() + " --");
                current.myInit();
                System.out.println("Before sort " + current.getData());
                Instant start = Instant.now();  // time capture -- start
                current.mySort();
                Instant end = Instant.now();    // time capture -- end
                current.addTimeElapsed(Duration.between(start, end));
                current.addSwaps(current.swaps);
                System.out.println("After sort " + current.getData());
            }
        }

        for (Sorts current : sortsList) {
            System.out.println("-- " + current.myName() + " --");
            System.out.println("Average time " + current.getTimeElapsed()/TIMES);
            System.out.println("Average swaps " + current.getSwaps()/TIMES);
        }

        /**
        for(int i=0; i< TIMES; i++) {

            for(int j = 0; j<s.getData().size(); j++) {
                // To see data, uncomment next line
                // System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            System.out.println("Average random: " + sum / ((i+1)*SIZE));
            System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();

        }
        System.out.println("Average random: " + sum / (TIMES*SIZE));
        System.out.println("Total Nanoseconds: " + time );
        System.out.println("Total Seconds: " + time /1000000000.0);
         **/
    }

}
