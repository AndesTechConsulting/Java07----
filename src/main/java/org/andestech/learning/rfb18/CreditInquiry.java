package org.andestech.learning.rfb18;

public class CreditInquiry {

    private int id;
    private int customer_id;
    private double amount_of_credit;
    private int maturity;//monht
    private double rate;
    private boolean status;
    private String creditRating;//Bad,Good,Excellent

    public CreditInquiry(int customer_id, double amount_of_credit, int maturity, double rate, String creditRating){
        this.id = 1;
        this.customer_id = customer_id;
        this.amount_of_credit = amount_of_credit;
        this.maturity = maturity;
        this.rate = rate;
        this.creditRating = creditRating;
    }

    public void decisionCreditInqury () {

        if (rate >= 0.08 && rate < 0.10
                && amount_of_credit >= 1_000_000
                && maturity >= 60 && maturity <= 120
                && creditRating.equals("EXCELLENT")) {
            this.status = true;
        } else if (rate >= 0.1 && rate < 0.15
                && amount_of_credit < 1_000_000
                && maturity <= 60
                && (creditRating.equals("GOOD")) || creditRating.equals("EXCELLENT")) {
            this.status = true;
        } else {
            this.status = false;
        }
    }

    public void checkStatus (){
        if(status){
            System.out.println("Кредит одобрен");
        }
        else if(!status){
            System.out.println("В кредите отказано");
        }
        else {
            System.out.println("Заявка не обработана");
        }
    }
}
