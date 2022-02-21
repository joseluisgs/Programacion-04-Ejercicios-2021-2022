package com.company.Model;

public class Process {

    int time;
    int priority;
    int count = 0;
    String name = "P" + id;
    private static int id = 0;

    public Process(int time, int priority){

        this.time= time;
        this.priority=priority;
        id++;

    }

    public void process(int milsec){
        count += milsec;
        System.out.println("Process {"+ name + "} running for " + milsec + " milisec");
        count = Math.min(count,time);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isdone(){
        return this.count==this.time;
    }

    @Override
    public String toString() {
        return "{"+ name +"}";
    }

    public int compareTo(Process p){
        return p.priority-this.priority;
    }
}
