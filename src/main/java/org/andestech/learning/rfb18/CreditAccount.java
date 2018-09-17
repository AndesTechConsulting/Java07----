package org.andestech.learning.rfb18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Евгений on 29.08.2018.
 */
public class CreditAccount {

    private String cusName;
    private String cusSName;
    private int cusAge;
    private int cusSalary;
    private int creditRating;
    private int sumOfCredit;
    private int timeOfCredit;
    private double payPerMonth;


    CreditAccount(String cusName, String cusSName, int cusAge, int cusSalary,
                  int creditRating, int sumOfCredit, int timeOfCredit) {
        this.cusName = cusName;
        this.cusSName = cusSName;
        this.cusAge = cusAge;
        this.cusSalary = cusSalary;
        this.creditRating = creditRating;
        this.sumOfCredit= sumOfCredit;
        this.timeOfCredit = timeOfCredit;
        //this.payPerMonth = payPerMonth;
    }



    public int getTimeOfCredit() {
        return timeOfCredit;
    }

    public void setTimeOfCredit(int timeOfCredit) {
        this.timeOfCredit = timeOfCredit;
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusSName() {
        return cusSName;
    }

    public int getSumOfCredit() {
        return sumOfCredit;
    }





//        // внесение денег (ежемесячный пдатеж)
        public void payMoney (int sumOfPay) throws NotEnoughMaonthlyPaymentException {
            int a = getTimeOfCredit();
            int b = a - 1;
            setTimeOfCredit(b);

            int c = getSumOfCredit();
            payPerMonth = c / a * 1.11;

            try {
                if (sumOfPay < payPerMonth) {
                    throw new NotEnoughMaonthlyPaymentException();
                }
            } catch (NotEnoughMaonthlyPaymentException e) {
                System.out.println("Внесено недостаточно денег.");
            }
            
            repList.add("Внесено: " + sumOfPay + " рублей. " + getCusName() + " " + getCusSName());
            System.out.println("Внесено: " + sumOfPay + " рублей. " + getCusName() + " " + getCusSName());
        }



    // вывод отчета операций по кредиту

    ArrayList repList = new ArrayList<>();

    public void getReport() {
        for(int i = 0; i < repList.size(); i++) {
            System.out.println(repList.get(i));
        }
    }

    public void writeReport() {

        String FileAcc = "C:\\JavaWriteTest\\";

        try (FileOutputStream fos = new FileOutputStream(FileAcc + "Accounts.csv")) {

            for (int i = 0; i < repList.size(); i++) {
                String a = (String) repList.get(i);
                String b = " ";
                byte[] arr = a.getBytes("utf8");
                fos.write(arr);
                byte[] arr2 = b.getBytes("utf8");
                fos.write(arr2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



