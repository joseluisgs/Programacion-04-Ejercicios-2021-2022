package es.daniel.models;

import es.daniel.utils.Input;

public class Reloj {
    private int min;
    private int hour;
    private int second;
    private String version;

    public Reloj(int min, int hour, int second, String version) {
        this.min = min;
        this.hour = hour;
        this.second = second;
        this.version= version;
        comprobarVersion();
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void comprobarVersion(){
        if (getHour()>12 && getVersion().equals("12")){
            this.hour= getHour()-12;
        }

    }

    @Override
    public String toString() {
        return "Reloj: " +
                hour + "h "+
                min + "min "+
                second + "sgs";
    }
}
