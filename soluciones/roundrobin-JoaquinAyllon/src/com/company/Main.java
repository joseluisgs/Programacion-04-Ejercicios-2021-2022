package com.company;

import com.company.Model.RoundRobin;

public class Main {

    public static void main(String[] args) {

        RoundRobin r = new RoundRobin();

        r.randomFillWOP(20);

        r.cicleWOP();

        r.randomFillWP(20);

        r.cicleWP();
    }
}
