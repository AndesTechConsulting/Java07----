package org.andestech.learning.rfb18;

import org.andestech.learning.rfb18.ExceptionConteiner.CreditInquiryException;

public class CreditInquiry
{

    //====================CONST=====================
    private final int SALARY_MIN = 10_000;
    private final int SALARY_MAX = 1_000_000_000;
    private final int SALARY_WEIGHT = 3;

    private final int AGE_MIN = 18;
    private final int AGE_MAX = 72;
    private final double AGE_WEIGHT = 0.5;

    private final int CREDIT_RATING_MIN = 0;
    private final int CREDIT_RATING_MAX = 10;
    private final int CREDIT_RATING_WEIGHT = 5;

    private final int CREDIT_AMOUNT_MIN = 10_000;
    private final int CREDIT_AMOUNT_MAX = 1_000_000_000;

    private final int REPAYMENT_PERIOD_MIN = 6;
    private final int REPAYMENT_PERIOD_MAX = 120;

    private final double FIX_PERCENT = 0.024;

    public CreditInquiry()
    { }


    public String checkCustomerCreditChance(Customer customer, int creditAmount, int repaymentPeriod)
    {
        if (!checkBorderValues(SALARY_MIN, SALARY_MAX, customer.getSalary())) {
            return "Denied";
        }
        if (!checkBorderValues(CREDIT_RATING_MIN, CREDIT_RATING_MAX, customer.getCreditRating())) {
            return "Denied";
        }
        if (!checkBorderValues(AGE_MIN, AGE_MAX, customer.getAge())) {
            return "Denied";
        }
        if (!checkBorderValues(CREDIT_AMOUNT_MIN, CREDIT_AMOUNT_MAX, creditAmount)) {
            return "Denied";
        }
        if (!checkBorderValues(REPAYMENT_PERIOD_MIN, REPAYMENT_PERIOD_MAX, repaymentPeriod)) {
            return "Denied";
        }

        double decisiveRating = customer.getAge()*AGE_WEIGHT + customer.getCreditRating()*CREDIT_RATING_WEIGHT +
                                (customer.getSalary() - (creditAmount * (FIX_PERCENT * repaymentPeriod/12) +
                                creditAmount)/repaymentPeriod)
                                 *SALARY_WEIGHT;
        if(decisiveRating < 100)
        {
          return "Denied";
        } else {
            return "Approved";
        }
    }

    private boolean checkBorderValues(int min, int max, int currentValue)
    {
        if(currentValue < min || currentValue > max)
        { return false; }
        else
        { return true; }
    }

    public boolean createCreditAccount(Customer customer, int creditAmount, int repaymentPeriod)
    {
        String decision = checkCustomerCreditChance(customer, creditAmount, repaymentPeriod);
        if(decision.equals("Denied"))
        {
            return false;
        }
        else if(decision.equals("Approved"))
        {
            new CreditAccount(customer, creditAmount, FIX_PERCENT, repaymentPeriod);
            System.out.println("Credit account has been created");
            return true;
        }
        else
        {
            return false;
        }
    }
}
