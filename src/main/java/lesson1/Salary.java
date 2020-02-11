package lesson1;

import java.util.Scanner;

public class Salary {

    int salaryInHour;
    int hours;
    int syma;


    public int calculateMonthSalary(int salaryInHour,int hours){
        return salaryInHour*hours;
    }

    public int calculatePodatok(int syma){
        return (syma*15)/100;
    }

    public int calculateCleanSalary(int syma,int podatok){
        return syma-podatok;
    }


}
