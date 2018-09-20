package org.andestech.learning.rfb18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CreditAccount {

    private int customerId;
    private int sumOfCredit;
    private int timeOfCredit;

    @Override
    public String toString(){
        return  " выдан кредит на " + this.sumOfCredit + " руб, сроком на " + this.timeOfCredit;
    }

    CreditAccount(int customerId, int sumOfCredit, int timeOfCredit) {
        this.customerId = customerId;
        this.sumOfCredit= sumOfCredit;
        this.timeOfCredit = timeOfCredit;
    }
    public int getTimeOfCredit() {
        return timeOfCredit;
    }

    public void setTimeOfCredit(int timeOfCredit) {
        this.timeOfCredit = timeOfCredit;
    }


    public int getSumOfCredit() {
        return sumOfCredit;
    }



}