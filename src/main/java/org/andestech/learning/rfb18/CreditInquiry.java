package org.andestech.learning.rfb18;

public class CreditInquiry {

    private int sumOfCredit;

    CreditInquiry(int sumOfCredit) {
        this.sumOfCredit = sumOfCredit;
    }

    public int getSumOfCredit() {
        return sumOfCredit;
    }

    public void setSumOfCredit(int sumOfCredit) {
        this.sumOfCredit = sumOfCredit;
    }

    public static boolean ACCEPT;

    public void doCreditInquiry(Customer customer) throws CreditInquiryException {
        int age = customer.getAge();
        int salary = customer.getSalary();
        String creditRating = customer.getCreditRating();
        int sum = getSumOfCredit();


        try {
            if (salary > 50000 & age > 18 & age < 60 & sum < salary) {
                ACCEPT = true;
                System.out.println("Выдан кредит");
            } else if (creditRating == "BAD" | age > 60 | age < 18) {
                ACCEPT = false;
                throw new CreditInquiryException();
            }
        } catch (CreditInquiryException e) {
            System.out.println("Кредит не выдавать");
        }
    }



}