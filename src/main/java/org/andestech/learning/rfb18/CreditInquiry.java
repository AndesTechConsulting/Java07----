package org.andestech.learning.rfb18;

/**
 * Created by Евгений on 28.08.2018.
 */
public class CreditInquiry {

    private int sumOfCredit;
    private int timeOfCredit;

    CreditInquiry(int sumOfCredit, int timeOfCredit) {
        this.sumOfCredit = sumOfCredit;
        this.timeOfCredit = timeOfCredit;
    }

    public int getSumOfCredit() {
        return sumOfCredit;
    }

    public void setSumOfCredit(int sumOfCredit) {
        this.sumOfCredit = sumOfCredit;
    }

    public int getTimeOfCredit() {
        return timeOfCredit;
    }

    public void setTimeOfCredit(int timeOfCredit) {
        this.timeOfCredit = timeOfCredit;
    }



    public static boolean FLAG_DES;

    public void makeDecision(Customer customer) throws CreditInquiryException {
        int age = customer.getAge();
        int salary = customer.getSalary();
        int creditRating = customer.getCreditRating();
        int sum = getSumOfCredit();
        int time = getTimeOfCredit();

        double payPerMonth = (sum / time) * 1.11;
        double b = salary / 2;


        try {
            if (payPerMonth < b & age < 50 & time < 120) {
                FLAG_DES= true;
            } else if (creditRating == 0 | payPerMonth > b | age > 50) {
                FLAG_DES = false;
                throw new CreditInquiryException();
            }
        } catch (CreditInquiryException e) {
            System.out.println("Кредит не одобрен");
        }

    }


}
