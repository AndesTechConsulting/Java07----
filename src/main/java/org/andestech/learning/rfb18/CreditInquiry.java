package org.andestech.learning.rfb18;

public class CreditInquiry {

    Double salary;
    int age;
    int creditRating;
    int sum;
    double countercredpersen;
    double everymonthpersen;
    String account = String.valueOf(1 + (int) (Math.random() * ((10 - 1) + 1)));

    public CreditInquiry(Customer customer, int sum) {
        this.salary = customer.salary;
        this.age = customer.age;
        this.sum = sum;
        this.creditRating = customer.creditRating;
    }

    public Boolean checkCustomer() {
        if (age < 18 || creditRating < 5 || (sum / 12) < salary) {
            if (0 > sum | sum <= 3000) {
                countercredpersen = 15;
                everymonthpersen = sum / 12;
            }
            if (sum > 3000 | sum < 10000) {
                countercredpersen = 10;
                everymonthpersen = sum / 14;
            } else {
                countercredpersen = 5;
                everymonthpersen = sum / 20;
            }
            return true;
          //  CreditAccount credAcc = new CreditAccount(sum, countercredpersen, everymonthpersen, String.valueOf(1 + (int) (Math.random() * ((10 - 1) + 1))));
        } else {
            try {
                throw new CreditInquiryException();
            } catch (CreditInquiryException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



}
