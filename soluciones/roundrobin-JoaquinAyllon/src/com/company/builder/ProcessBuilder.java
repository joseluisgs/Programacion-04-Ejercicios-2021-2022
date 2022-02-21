package com.company.builder;

import com.company.Model.Process;

public class ProcessBuilder {

    public static Process randomBuildWOP(){
        int time = (int)(Math.random()*3 + 1);
        time = time*1000;
        return new Process(time, 0);
    }

    public static Process randomBuildWP(){
        int time = (int)(Math.random()*3 +1);
        int prio = (int)(Math.random()*3);
        time = time *1000;
        return new Process(time, prio);
    }
}
