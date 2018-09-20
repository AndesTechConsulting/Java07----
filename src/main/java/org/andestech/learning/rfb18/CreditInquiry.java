package org.andestech.learning.rfb18;

import org.andestech.learning.rfb18.ExceptionConteiner.CreditInquiryException;

public class CreditInquiry
{
    private int creditInquiryId;

    public CreditInquiry(int creditInquiryId)
    {
        this.creditInquiryId = creditInquiryId;
    }

    public String checkCustomerCreditChance(Customer customer, float creditAmount, short repaymentPeriod)
                                            throws CreditInquiryException
    {
        //TODO:Реализовать логику выдачи кредита
        if(1==2)
        {
            throw new CreditInquiryException();
        }
        return "Approved";
    }

    //TODO:Над названием класса ещё подумать
    public boolean createCreditAccount(Customer customer, float creditAmount, short repaymentPeriod)
                                        throws CreditInquiryException
    {
        float percent = 0 ;
        try
        {
            checkCustomerCreditChance(customer, creditAmount, repaymentPeriod);
        }
        catch(CreditInquiryException e)
        {
            return false;
        }
        new CreditAccount(customer, creditAmount, percent);
        return true;
    }
}
