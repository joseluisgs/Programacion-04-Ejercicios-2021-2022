package com.company.Model;

import java.util.ArrayList;
import java.util.List;
import com.company.builder.ProcessBuilder;

public class RoundRobin {

    private ArrayList<Process> queue = new ArrayList<>();

    public void setQueue() {
    }

    public void add(Process p){
        queue.add(p);
    }

    public void cicleWOP(){
        while(queue.size() > 0) {
            for (Process p:queue) {
                p.process(200);
            }
            for (int i = 0; i < queue.size(); i++) {
                if(queue.get(i).isdone()){
                    queue.remove(i);
                    i--;
                }
            }
        }
    }

    public void cicleWP(){
        while(queue.size() > 0) {
            queue.sort(Process::compareTo);
            for (Process p:queue) {
                p.process(200);
            }
            for (int i = 0; i < queue.size(); i++) {
                if(queue.get(i).isdone()){
                    queue.remove(i);
                    i--;
                }
            }
        }
    }

    public void randomFillWOP(int amount){
        for (int i = 0; i < amount; i++) {
            queue.add(ProcessBuilder.randomBuildWOP());
        }
    }

    public void randomFillWP(int amount){
        for (int i = 0; i < amount; i++) {
            queue.add(ProcessBuilder.randomBuildWP());
        }
    }
}
